package org.akavity.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.akavity.annotations.TestData;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JsonReader implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(org.junit.jupiter.api.extension.ExtensionContext context) throws Exception {
        Method testMethod = context.getTestMethod().orElseThrow(() -> new RuntimeException("No test method found"));
        TestData testDataAnnotation = testMethod.getAnnotation(TestData.class);

        if (testDataAnnotation == null) {
            throw new RuntimeException("TestData annotation is missing on method: " + testMethod.getName());
        }

        String jsonData = JsonParser.parseReader(new FileReader("src/test/resources/test-data/"
                + testDataAnnotation.folder() + "/"
                + testDataAnnotation.jsonFile() + ".json")).toString();

        ArrayList<Object> list;
        try {
            list = new Gson().fromJson(jsonData, TypeToken.getParameterized(List.class,
                    Class.forName("org.akavity.models." + testDataAnnotation.folder()
                            + "." + testDataAnnotation.model())).getType());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Model class not found", e);
        }

        return Objects.requireNonNull(list).stream()
                .map(Arguments::of);
    }
}
