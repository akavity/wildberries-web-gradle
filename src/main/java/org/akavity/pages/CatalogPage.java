package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    private final SelenideElement tileField = $(By.cssSelector("h1[class='catalog-title']"));
    private final ElementsCollection productCards = $$(By.cssSelector("div[class='product-card__wrapper']"));
    private final ElementsCollection newTips = $$(By.cssSelector("span[class*='product-card__tip--new']"));
    private final ElementsCollection popupButtons = $$(By.cssSelector("button[class*='open-product-popup']"));
    private final ElementsCollection saleTips = $$(By.cssSelector("p[class*='tip--sale']"));
    private final ElementsCollection pricesFields = $$(By.cssSelector("span[class='price__wrap'] ins"));
    private final ElementsCollection productNames = $$(By.cssSelector("span[class='product-card__name']"));
    private final ElementsCollection brandFields = $$(By.cssSelector("span[class='product-card__brand']"));
    private final ElementsCollection productCounts = $$(By.cssSelector("p[class*='rating'] span[class*='card__count']"));
    private final ElementsCollection productRatings = $$(By.cssSelector("p[class*='rating'] span[class*='rate-mini']"));
    private final ElementsCollection addBasketButtons = $$(By.cssSelector("p[class='product-card__order-wrap']"));
    private final SelenideElement popupBlock = $(By.cssSelector("div[class*='popup-list']")); // check
    private final ElementsCollection sizeListButtons = $$(By.cssSelector("div[class*='slideUp'] li[class='sizes-list__item']")); // check

    public SelenideElement getSearchTitleField(String title) {
        return $(By.xpath("//h1[@class='searching-results__title' and contains(text(),'" + title + "')]"));
    }

    public SelenideElement getTileField() {
        return tileField;
    }

    public ElementsCollection getPricesFields() {
        return pricesFields;
    }

    public ElementsCollection getProductNames() {
        return productNames;
    }

    public ElementsCollection getProductCards() {
        return productCards;
    }

    public ElementsCollection getPopupButtons() {
        return popupButtons;
    }

    public ElementsCollection getBrandFields() {
        return brandFields;
    }

    public ElementsCollection getAddBasketButtons() {
        return addBasketButtons;
    }

    public SelenideElement getPopupBlock() {
        return popupBlock;
    }

    public ElementsCollection getSizeListButtons() {
        return sizeListButtons;
    }

    public ElementsCollection getNewTips() {
        return newTips;
    }

    public ElementsCollection getProductCounts() {
        return productCounts;
    }

    public ElementsCollection getProductRatings() {
        return productRatings;
    }

    public ElementsCollection getSaleTips() {
        return saleTips;
    }
}
