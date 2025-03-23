package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {
    private final ElementsCollection priceFields = $$(By.cssSelector("div[class*='price-new']"));
    private final SelenideElement finalPriceField = $(By.cssSelector("p[class*='total line'] span[data-link]"));

    public ElementsCollection getPriceFields() {
        return priceFields;
    }

    public SelenideElement getFinalPriceField() {
        return finalPriceField;
    }
}
