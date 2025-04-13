package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.PopupPage;
import org.akavity.utils.Utils;

@Log4j2
public class PopupSteps {
    PopupPage popupPage = new PopupPage();

    @Step
    public boolean isPopupBlockDisplayed() {
        Utils.sleep(1000);
        boolean res = popupPage.getPopupBlock().isDisplayed();
        log.info("Is popup block displayed: {}", res);
        return res;
    }

    @Step
    public double getProductPrice() {
        double price = Utils.extractDoubleFromText(popupPage.getProductPrice().text());
        log.info("Popup product price: {}", price);
        return price;
    }

    @Step
    public String getProductBrand() {
        String brand = popupPage.getProductBrand().getText();
        log.info("Popup product brand: {}", brand);
        return brand;
    }
}
