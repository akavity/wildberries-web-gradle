package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PromoPage {
    public SelenideElement getPromoItem(String item) {
        return $(By.xpath("//div[@class='promo-page__item']//span[contains(text(),'" + item + "')]/../.."));
    }

    // BelGoods
    public SelenideElement getMenuItem(String item) {
        return $(By.xpath("//li[@class='menu-category__item']/a[contains(text(),'" + item + "')]"));
    }

    public SelenideElement getContentItem(String item) {
        return $(By.xpath("//div[contains(@class,'list-category')]//span[contains(text(),'" + item + "')]/.."));
    }
}
