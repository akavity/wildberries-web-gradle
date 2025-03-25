package org.akavity.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.akavity.annotations.TestData;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JsonReader implements ArgumentsProvider {
    private static final Gson GSON = new Gson(); // Singleton Gson (потокобезопасный)

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        Method testMethod = context.getTestMethod()
                .orElseThrow(() -> new RuntimeException("No test method found"));
        TestData testDataAnnotation = testMethod.getAnnotation(TestData.class);

        if (testDataAnnotation == null) {
            throw new RuntimeException("TestData annotation is missing on method: " + testMethod.getName());
        }

        String filePath = "src/test/resources/test-data/"
                + testDataAnnotation.folder() + "/"
                + testDataAnnotation.jsonFile() + ".json";

        // Читаем JSON безопасно
        String jsonData;
        try (Reader reader = new FileReader(filePath)) {
            jsonData = JsonParser.parseReader(reader).toString();
        }

        // Загружаем класс безопасно
        Class<?> modelClass;
        synchronized (this) { // Синхронизируем загрузку класса
            modelClass = Class.forName("org.akavity.models." + testDataAnnotation.folder()
                    + "." + testDataAnnotation.model());
        }

        // Десериализация JSON
        List<?> list = GSON.fromJson(jsonData, TypeToken.getParameterized(List.class, modelClass).getType());

        return Objects.requireNonNull(list).stream().map(Arguments::of);
    }
}
