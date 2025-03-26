package org.akavity.tests;

import io.qameta.allure.Description;
import org.akavity.annotations.TestData;
import org.akavity.models.faqTest.FaqData;
import org.akavity.models.faqTest.QuestionData;
import org.akavity.models.faqTest.RefundPaymentData;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.InfoSteps;
import org.akavity.utils.JsonReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;


public class FAQTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    InfoSteps infoSteps = new InfoSteps();

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "faqTest", jsonFile = "faqData", model = "FaqData")
    @Description("Select frequently asked question")
    public void selectFAQ(FaqData faqData) {
        headerSteps.clickAddressButton();
        infoSteps.clickServiceMenuItem(faqData.getServiceMenuItem());
        infoSteps.clickFAQMenuItem(faqData.getFaqMenuItem());
        infoSteps.clickDropDownTitle(faqData.getTitle());                    // without iframe

        Assertions.assertTrue(infoSteps.isDropDownContentDisplayed(faqData.getTitle(), faqData.getContent()));
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "faqTest", jsonFile = "refundPaymentData", model = "RefundPaymentData")
    @Description("Check information about refund and payment methods")
    public void checkRefundAndPaymentInfo(RefundPaymentData refundPayment) {
        headerSteps.clickAddressButton();
        infoSteps.clickServiceMenuItem(refundPayment.getMenuItem());
        infoSteps.clickDropDownTitle(refundPayment.getTitle());              // with iframe

        Assertions.assertTrue(infoSteps.isDropDownContentDisplayed(refundPayment.getTitle(), refundPayment.getContent()));
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "faqTest", jsonFile = "questionData", model = "QuestionData")
    @Description("Search for a question in the frequently asked questions")
    public void searchForQuestion(QuestionData questionData) {
        headerSteps.clickAddressButton();
        infoSteps.clickServiceMenuItem(questionData.getMenuItem());
        infoSteps.enterTextIntoSearchField(questionData.getSearchField());
        infoSteps.clickFirstSearchResultButton();
        infoSteps.clickSearchDropDownTitle();

        Assertions.assertTrue(infoSteps.isFAQTitleDisplayed(questionData.getTitle()));
    }
}
