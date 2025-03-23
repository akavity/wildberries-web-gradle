package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.BasketPage;
import org.akavity.utils.Utils;

@Log4j2
public class BasketSteps {
    BasketPage basketPage = new BasketPage();
    Utils utils = new Utils();

    @Step
    public double getFinalPrice() {
        utils.sleep(2000);
        double price = utils.extractDoubleFromText(basketPage.getFinalPriceField().text());
        log.info("Get final price: {}", price);
        return price;
    }
}
