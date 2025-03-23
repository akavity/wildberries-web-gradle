package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.InfoPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class InfoSteps {
    InfoPage infoPage = new InfoPage();
    Utils utils = new Utils();

    @Step
    public void clickServiceMenuItem(String item) {
        log.info("Click service menu item: {}", item);
        infoPage.getServiceMenuItem(item).shouldBe(clickable).click();
    }

    @Step
    public void clickFAQMenuItem(String item) {
        log.info("Click FAQ menu item: {}", item);
        switchTo().frame(infoPage.getServiceIframe());                     // Service iframe
        infoPage.getFAQMenuItem(item).click();
    }

    @Step
    public boolean isFAQTitleDisplayed(String title) {
        utils.sleep(1000);
        boolean res = infoPage.getFAQTitle(title).isDisplayed();
        log.info("Is FAQ title displayed: {}", res);
        return res;
    }

    @Step
    public void clickFAQ(String question) {
        log.info("Click FAQ");
        infoPage.getFAQ(question).click();
    }

    @Step
    public void clickDropDownTitle(String title) {
        log.info("Click dropdown title: {}", title);
        utils.sleep(1000);
        if (infoPage.getServiceIframe().exists()) {
            switchTo().frame(infoPage.getServiceIframe());                     // Service iframe
        }
        infoPage.getDropDownTitle(title).click();
    }

    @Step
    public void clickSearchDropDownTitle() {
        log.info("Click first search dropdown title");
        infoPage.getSearchDropDownTitles().first().click();
    }

    @Step
    public boolean isDropDownContentDisplayed(String title, String cont) {
        utils.sleep(1000);
        boolean result = infoPage.getDropDownContent(title, cont).isDisplayed();
        log.info("Dropdown content displayed: {}", result);
        return result;
    }

    @Step
    public void enterTextIntoSearchField(String text) {
        switchTo().frame(infoPage.getServiceIframe());
        log.info("Enter text into the search field: {}", text);
        infoPage.getSearchField().setValue(text).pressEnter();
    }

    @Step
    public void clickFirstSearchResultButton() {
        log.info("Click the first button from the search results buttons");
        infoPage.getSearchResultButtons().first().click();
    }
}
