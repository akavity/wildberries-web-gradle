package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.PromoPage;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class PromoSteps {
    PromoPage promoPage = new PromoPage();

    @Step
    public void clickPromoItem(String item) {
        log.info("Click promo item");
        promoPage.getPromoItem(item).shouldBe(visible).click();
    }

    @Step
    public void clickContentItem(String firstItem, String secondItem, String thirdItem) {
        log.info("Click first item of content list: {}", firstItem);
        promoPage.getContentItem(firstItem).click();
        if (secondItem.equalsIgnoreCase("no")) {
            log.info("Content list doesn't have second item");
        } else {
            log.info("Click second item of content list: {}", secondItem);
            promoPage.getContentItem(secondItem).shouldBe(visible).click();
            if (thirdItem.equalsIgnoreCase("no")) {
                log.info("Content list doesn't have third item");
            } else {
                promoPage.getContentItem(thirdItem).shouldBe(visible).click();
            }
        }
    }
}
