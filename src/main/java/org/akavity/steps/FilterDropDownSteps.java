package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.FilterDropDownPage;

@Log4j2
public class FilterDropDownSteps {
    FilterDropDownPage filter = new FilterDropDownPage();

    @Step
    public void clickButtonDDF(String button) {
        log.info("Click dropdown-filter button: {}", button);
        filter.getButton(button).hover().click();
    }

    @Step
    public void selectSortType(String type) {
        log.info("Select sort type: {}", type);
        filter.getRadioButton(type).click();
    }

    @Step
    public void enterMinAmount(String min) {
        log.info("Enter min amount: {}", min);
        filter.getMinPrice().setValue(min);
    }

    @Step
    public void enterMaxAmount(String max) {
        log.info("Enter max amount: {}", max);
        filter.getMaxPrice().setValue(max);
    }

    @Step
    public void clickPriceReadyButton() {
        log.info("Click \"Price is ready\" button");
        filter.getPriceReadyButton().click();
    }

    @Step
    public void enterMinMaxAmount(String min, String max) {
        log.info("Enter min {} and max {} amount", min, max);
        filter.getMinPrice().setValue(min);
        filter.getMaxPrice().setValue(max);
        log.info("Click submit button");
        filter.getPriceReadyButton().click();
    }
}
