package org.akavity.utils;

import com.codeborne.selenide.ElementsCollection;
import lombok.extern.log4j.Log4j2;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class Utils {
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean relationalMethod(ElementsCollection col, Predicate<Double> predicate) {
        boolean result;
        if (col.isEmpty()) {
            log.info("Collection is empty");
            result = false;
        } else {
            result = col.asDynamicIterable()
                    .stream()
                    .map(el -> extractDoubleFromText(el.getText()))
                    .peek(p -> log.info("Element price: {}", p))
                    .allMatch(predicate);
        }
        return result;
    }

    public double extractDoubleFromText(String text) {
        double result = 0.0;
        Pattern pattern = Pattern.compile("\\d?[ ]?\\d+[,.]\\d{2}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Double.parseDouble(matcher.group().replace(" ", "").replace(",", "."));
        }
        return result;
    }
}
