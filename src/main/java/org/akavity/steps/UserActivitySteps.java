package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.UserActivityPage;
import org.akavity.utils.Utils;

@Log4j2
public class UserActivitySteps {
    UserActivityPage userActivityPage = new UserActivityPage();

    @Step
    public boolean isFeedbackButtonDisplayed() {
        Utils.sleep(1500);
        boolean result = userActivityPage.getFeedbackButton().isDisplayed();
        log.info("Is a feedback button displayed: {}", result);
        return result;
    }

    @Step
    public boolean isQuestionTitleDisplayed() {
        Utils.sleep(1500);
        boolean result = userActivityPage.getQuestionTitle().isDisplayed();
        log.info("Is a question title is displayed: {}", result);
        return result;
    }
}
