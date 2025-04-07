package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement catalogButton = $(By.cssSelector("button[data-wba-header-name='Catalog']"));
    private final SelenideElement mailList = $(By.cssSelector("ul[class='menu-burger__main-list']"));
    private final SelenideElement searchField = $(By.cssSelector("input[id='searchInput']"));
    private final SelenideElement loupeButton = $(By.cssSelector("button[id='applySearchBtn']"));
    private final SelenideElement addressButton = $(By.cssSelector("div[class*='item-addresses']"));
    private final SelenideElement iframe = $(By.cssSelector("iframe[class='service-page__iframe']"));
    private final SelenideElement currencyButton = $(By.cssSelector("span[class='simple-menu__currency']"));
    private final SelenideElement geolocationButton = $(By.cssSelector("span[class*='geocity']"));
    private final SelenideElement basketButton = $(By.cssSelector("a[data-wba-header-name='Cart']"));

    public SelenideElement getServiceMenuItem(String item) {
        return $(By.xpath("//li[contains(@class,'service-menu__item')]/a[contains(text(),'" + item + "')]"));
    }

    public SelenideElement getServiceMenuTitle(String title) {
        return $(By.xpath("//div[@class='service-page-iframe']//h1[contains(text(),'" + title + "')]"));
    }

    public SelenideElement getCurrencyItem(String item) {
        return $(By.xpath("//span[@class='radio-with-text__name' and contains(text(),'" + item + "')]/.."));
    }

    public SelenideElement getGeolocationButtonByText(String address) {
        return $(By.xpath("//span[contains(@class,'details') and contains(text(),'" + address + "')]"));
    }

    public SelenideElement getCatalogButton() {
        return catalogButton;
    }

    public SelenideElement getMailList() {
        return mailList;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getLoupeButton() {
        return loupeButton;
    }

    public SelenideElement getAddressButton() {
        return addressButton;
    }

    public SelenideElement getIframe() {
        return iframe;
    }

    public SelenideElement getCurrencyButton() {
        return currencyButton;
    }

    public SelenideElement getGeolocationButton() {
        return geolocationButton;
    }

    public SelenideElement getBasketButton() {
        return basketButton;
    }
}
