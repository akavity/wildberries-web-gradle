package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProductPage;
import org.akavity.utils.Utils;

@Log4j2
public class ProductSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    ProductPage productPage = new ProductPage();
    Utils utils = new Utils();

    @Step
    public void clickCommentsButton() {
        log.info("Click comments button");
        productPage.getCommentsButton().scrollTo().click();
    }

    @Step
    public void clickQuestionsButton() {
        utils.sleep(1000);
        log.info("Click questions button");
        productPage.getQuestionsButton().scrollTo().click();
    }

    @Step
    public void clickViewAllCommentsButton() {
        utils.sleep(1300);
        log.info("Click \"View All Comments\" button");
        productPage.getViewAllCommentsButton().scrollIntoView(PARAMETER).click();
    }

    @Step
    public void clickViewAllQuestionButton() {
        utils.sleep(1300);
        log.info("CLick \"View All Question\" button");
        productPage.getViewAllQuestionsButton().scrollIntoView(PARAMETER).click();
    }
}
