package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NavigationPage {
    private final SelenideElement mailListElement = $(By.cssSelector("ul[class='menu-burger__main-list']"));

    public SelenideElement getMainListItem(String item) {
        return $(By.xpath("//ul[contains(@class,'main-list')]//a[.='" + item + "']/.."));
    }

    public SelenideElement getFirstDropListItem(String itemML, String itemDL) {
        String id = getId(itemML);
        return $(By.xpath("//div[@data-menu-id='" + id + "']//div[contains(@class,'burger__first')]//a[.='" + itemDL + "'] " +
                "| //div[@data-menu-id='" + id + "']//span[.='" + itemDL + "']"));
    }

    public SelenideElement getSecondDropListItem(String itemML, String itemDL) {
        String id = getId(itemML);
        return $(By.xpath("//div[@data-menu-id='" + id + "']//div[contains(@class,'burger__second')]//a[contains(text(),'" + itemDL + "')]"));
    }

    public SelenideElement getDropListTitle(String itemML, String title) {
        String id = getId(itemML);
        return $(By.xpath("//div[@data-menu-id='" + id + "']//span[contains(@class,'title-name') and contains(text(),'" + title + "')]"));
    }

    public SelenideElement getMailListElement() {
        return mailListElement;
    }

    private String getId(String itemML) {
        String id = "";
        switch (itemML.toLowerCase()) {
            case "женщинам" -> id = "306";
            case "обувь" -> id = "629";
            case "детям" -> id = "115";
            case "мужчинам" -> id = "566";
            case "дом" -> id = "258";
            case "красота" -> id = "543";
            case "аксессуары" -> id = "1";
            case "электроника" -> id = "4830";
            case "игрушки" -> id = "481";
            case "мебель" -> id = "62827";
            case "товары для взрослых" -> id = "62057";
            case "продукты" -> id = "10296";
            case "бытовая техника" -> id = "16107";
            case "зоотовары" -> id = "6119";
            case "спорт" -> id = "784";
            case "автотовары" -> id = "6994";
            case "книги" -> id = "519";
            case "для ремонта" -> id = "17006";
            case "сад и дача" -> id = "4863";
            case "здоровье" -> id = "10326";
            case "канцтовары" -> id = "5486";
            case "акции" -> id = "2192";
            default -> log.info("Incorrect item name: {}", itemML);
        }
        log.info("Main list item: \"{}\" have id: {}", itemML, id);
        return id;
    }
}
