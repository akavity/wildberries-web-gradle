package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FilterDropDownPage {
    private final SelenideElement minPrice = $(By.cssSelector("div[class*='filter__price'] input[name*='start']"));
    private final SelenideElement maxPrice = $(By.cssSelector("div[class*='filter__price'] input[name*='end']"));
    private final SelenideElement priceReadyButton = $(By.xpath("//button[contains(@class,'filter-btn') and contains(.,'Готово')]"));

    public SelenideElement getButton(String name) {
        return $(By.xpath("//div[contains(@class,'filter__btn') and contains(.,'" + name + "')]"));
    }

    public SelenideElement getRadioButton(String name) {
        return $(By.xpath("//span[contains(@class,'radio-with-text') and contains(.,'" + name + "')]"));
    }

    public SelenideElement getCheckBox(String name) {
        return $(By.xpath("//span[@class='checkbox-with-text__text' and .='" + name + "']"));
    }

    public SelenideElement getMinPrice() {
        return minPrice;
    }

    public SelenideElement getMaxPrice() {
        return maxPrice;
    }

    public SelenideElement getPriceReadyButton() {
        return priceReadyButton;
    }
}
