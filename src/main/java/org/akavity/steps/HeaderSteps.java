package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HeaderPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();
    Utils utils = new Utils();

    @Step
    public void clickCatalogButton() {
        utils.sleep(1600);
        log.info("Click catalog button");
        headerPage.getCatalogButton().shouldBe(clickable).click();
    }

    @Step
    public void enterTextInSearchField(String text) {
        log.info("Enter text in the search field");
        headerPage.getSearchField().sendKeys(text);
    }

    @Step
    public void clickLoupeButton() {
        log.info("Click the loupe button");
        headerPage.getLoupeButton().click();
    }

    @Step
    public void clickAddressButton() {
        log.info("Click the address button");
        headerPage.getAddressButton().click();
    }

    @Step
    public void clickServiceMenuItem(String item) {
        log.info("Click service menu item: {}", item);
        headerPage.getServiceMenuItem(item).click();
    }

    @Step
    public boolean isTitleVDisplayed(String title) {
        utils.sleep(2000);
        log.info("Switch to frame");
        switchTo().frame(headerPage.getIframe());                               //  iframe
        boolean result = headerPage.getServiceMenuTitle(title).isDisplayed();
        log.info("Is the title displayed: {}", result);
        return result;
    }

    @Step
    public void selectCurrency(String cur) {
        log.info("Click currency button");
        headerPage.getCurrencyButton().click();
        log.info("Select currency: {}", cur);
        headerPage.getCurrencyItem(cur).shouldBe(visible).click();
    }

    @Step
    public void clickGeolocationButton() {
        log.info("Click geolocation button");
        headerPage.getGeolocationButton().shouldBe(clickable);
        headerPage.getGeolocationButton().click();
    }

    @Step
    public boolean isAddressPickUpPointDisplayed(String address) {
        utils.sleep(2000);
        log.info("Check address of pick up point");
        boolean res = headerPage.getGeolocationButtonByText(address).isDisplayed();
        if (res == true) {
            log.info("Address {} is displayed", address);
        } else {
            log.info("Address {} isn't displayed", address);
        }
        return res;
    }

    @Step
    public void clickBasketButton() {
        log.info("Click basket button");
        headerPage.getBasketButton().click();
    }
}
