package org.akavity.tests;

import io.qameta.allure.Description;
import org.akavity.annotations.TestData;
import org.akavity.models.productTest.SearchData;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;


public class ProductTest extends BaseTest {
    CatalogSteps catalogSteps = new CatalogSteps();
    ProductSteps productSteps = new ProductSteps();
    UserActivitySteps userActivitySteps = new UserActivitySteps();
    PopupSteps popupSteps = new PopupSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    BasketSteps basketSteps = new BasketSteps();

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "productTest", jsonFile = "searchData", model = "SearchData")
    @Description("Search by product name")
    public void productSearch(SearchData searchData) {
        headerSteps.enterTextInSearchField(searchData.getText());
        headerSteps.clickLoupeButton();

        Assertions.assertTrue(catalogSteps.doProductNamesContainText(searchData.getText()));
    }

    @Test
    @Description("View reviews")
    public void viewReviews() {
        catalogSteps.selectFirstProductCard();
        productSteps.clickViewAllCommentsButton();

        Assertions.assertTrue(userActivitySteps.isFeedbackButtonDisplayed());
    }

    @Test
    @Description("View Questions")
    public void viewQuestions() {
        catalogSteps.selectFirstProductCard();
        productSteps.clickQuestionsButton();
        productSteps.clickViewAllQuestionButton();

        Assertions.assertTrue(userActivitySteps.isQuestionTitleDisplayed());
    }

    @Test
    @Description("Open product popup")
    public void openProductPopup() {
        String cardBrand = catalogSteps.getFirstProductCardBrand();
        double cardPrice = catalogSteps.getFirstProductCardPrice();
        catalogSteps.clickFirstPopupButton();
        String popupBrand = popupSteps.getProductBrand();
        double popupPrice = popupSteps.getProductPrice();

        Assertions.assertTrue(popupSteps.isPopupBlockDisplayed());
        Assertions.assertEquals(cardBrand, popupBrand);
        Assertions.assertEquals(cardPrice, popupPrice);
    }

    @Test
    @Description("Add product to basket")
    public void addProductToBasket() {
        double cardPrice = catalogSteps.getFirstProductCardPrice();
        catalogSteps.clickFirstButtonAddToBasket();
        catalogSteps.clickFirstButtonOfSizeList();
        headerSteps.clickBasketButton();
        double basketPrice = basketSteps.getFinalPrice();

        Assertions.assertEquals(cardPrice, basketPrice);
    }
}
