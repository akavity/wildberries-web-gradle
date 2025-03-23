package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PopupPage {
    private final SelenideElement popupBlock = $(By.cssSelector("div[class*='product-popup shown']"));
    private final SelenideElement productName = $(By.cssSelector("span[data-link*='goodsName']"));
    private final SelenideElement productPrice = $(By.cssSelector("div[class='product__content'] ins[class*='final-price']"));
    private final SelenideElement productBrand = $(By.cssSelector("div[class*='product__content'] span[class*='brand-name']"));

    public SelenideElement getPopupBlock() {
        return popupBlock;
    }

    public SelenideElement getProductName() {
        return productName;
    }

    public SelenideElement getProductPrice() {
        return productPrice;
    }

    public SelenideElement getProductBrand() {
        return productBrand;
    }
}
