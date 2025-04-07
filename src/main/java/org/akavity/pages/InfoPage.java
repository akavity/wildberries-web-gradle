package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InfoPage {
    public SelenideElement getServiceMenuItem(String item) {
        return $(By.xpath("//div[@class='service-menu']//a[contains(text(),'" + item + "')]/.."));
    }

    public SelenideElement getDropDownTitle(String title) {
        return $(By.xpath("//h2[contains(@class,'dropdown-t') and contains(text(),'" + title + "')]/.."));
    }

    public SelenideElement getDropDownContent(String cont) {  // String title, String cont
        return $(By.xpath("//h1[@class='faq-title c-h1']/..//p[contains(text(),'" + cont + "')] " +
                " | //h2[contains(@class,'dropdown-title')]/..//p[contains(text(),'" + cont + "')]"));

    }

    // Frequently asked questions (FAQ)
    public SelenideElement getFAQMenuItem(String item) {
        return $(By.xpath("//div[contains(@class,'faq-menu')]//span[contains(text(),'" + item + "')]/.."));
    }

    public SelenideElement getFAQTitle(String title) {
        return $(By.xpath("//div[contains(@class,'faq-contain')]//h1[contains(text(),'" + title + "')]"));
    }

    public SelenideElement getFAQ(String q) {
        return $(By.xpath("//div[contains(@class,'faq-contain')]//h2[contains(text(),'" + q + "')]"));
    }

    private final SelenideElement serviceIframe = $(By.cssSelector("iframe[id='pageInfoIfr']"));

    private final SelenideElement searchField = $(By.cssSelector("input[class='faq-search-input']"));

    private final ElementsCollection searchResultButtons = $$(By.cssSelector("ul[class*='search-results'] li"));

    private final ElementsCollection searchDropDownTitles = $$(By.cssSelector("div[id='search-selection'] div[class='faq-dropdown-item']"));

    public SelenideElement getServiceIframe() {
        return serviceIframe;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public ElementsCollection getSearchResultButtons() {
        return searchResultButtons;
    }

    public ElementsCollection getSearchDropDownTitles() {
        return searchDropDownTitles;
    }
}
