package org.akavity.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.faqTest.FaqData;
import org.akavity.models.faqTest.QuestionData;
import org.akavity.models.faqTest.RefundPaymentData;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.InfoSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FAQTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    InfoSteps infoSteps = new InfoSteps();

    @TestData(jsonFile = "faqData", model = "FaqData", folder = "faqTest")
    @Test(description = "Select frequently asked question", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectFAQ(FaqData faqData) {
        headerSteps.clickAddressButton();
        infoSteps.clickServiceMenuItem(faqData.getServiceMenuItem());
        infoSteps.clickFAQMenuItem(faqData.getFaqMenuItem());
        infoSteps.clickDropDownTitle(faqData.getTitle());                    // without iframe

        Assert.assertTrue(infoSteps.isDropDownContentDisplayed(faqData.getTitle(), faqData.getContent()));
    }

    @TestData(jsonFile = "refundPaymentData", model = "RefundPaymentData", folder = "faqTest")
    @Test(description = "Check information about refund and payment methods", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkRefundAndPaymentInfo(RefundPaymentData refundPayment) {
        headerSteps.clickAddressButton();
        infoSteps.clickServiceMenuItem(refundPayment.getMenuItem());
        infoSteps.clickDropDownTitle(refundPayment.getTitle());              // with iframe

        Assert.assertTrue(infoSteps.isDropDownContentDisplayed(refundPayment.getTitle(), refundPayment.getContent()));
    }

    @TestData(jsonFile = "questionData", model = "QuestionData", folder = "faqTest")
    @Test(description = "Search for a question in the frequently asked questions", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void searchForQuestion(QuestionData questionData) {
        headerSteps.clickAddressButton();
        infoSteps.clickServiceMenuItem(questionData.getMenuItem());
        infoSteps.enterTextIntoSearchField(questionData.getSearchField());
        infoSteps.clickFirstSearchResultButton();
        infoSteps.clickSearchDropDownTitle();

        Assert.assertTrue(infoSteps.isFAQTitleDisplayed(questionData.getTitle()));
    }
}
