package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.GeoPage;
import org.akavity.utils.Utils;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class GeoSteps {
    GeoPage geoPage = new GeoPage();
    Utils utils = new Utils();

    @Step
    public void clickAddressButton(String address) {
        geoPage.getGeoTitleField().shouldBe(visible);
        log.info("Click address button: {}", address);
        geoPage.getAddressButton(address).scrollTo().click();
    }

    @Step
    public void clickFirstPickupPoint() {
        utils.sleep(3000);
        log.info("CLick first pickup point");
        geoPage.getPickUpPointButtons().shouldHave(sizeGreaterThan(0), Duration.ofSeconds(5)).first().click();
    }

    @Step
    public void clickTakeFromHereButton() {
        log.info("Click button 'Take from here'");
        geoPage.getTakeFromHereButton().click();
    }

    @Step
    public boolean isPickupPointTitleDisplayed() {
        utils.sleep(1500);
        boolean res = geoPage.getGeoTitleField().isDisplayed();
        log.info("Is pickup point displayed: {}", res);
        return res;
    }
}
