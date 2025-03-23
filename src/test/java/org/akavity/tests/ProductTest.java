package org.akavity.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.productTest.SearchData;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    CatalogSteps catalogSteps = new CatalogSteps();
    ProductSteps productSteps = new ProductSteps();
    UserActivitySteps userActivitySteps = new UserActivitySteps();
    PopupSteps popupSteps = new PopupSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    BasketSteps basketSteps = new BasketSteps();

    @TestData(jsonFile = "searchData", model = "SearchData", folder = "productTest")
    @Test(description = "Search by product name", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void productSearch(SearchData searchData) {
        headerSteps.enterTextInSearchField(searchData.getText());
        headerSteps.clickLoupeButton();

        Assert.assertTrue(catalogSteps.doProductNamesContainText(searchData.getText()));
    }

    @Test(description = "View reviews")
    public void viewReviews() {
        catalogSteps.selectFirstProductCard();
        productSteps.clickViewAllCommentsButton();

        Assert.assertTrue(userActivitySteps.isFeedbackButtonDisplayed());
    }

    @Test(description = "View Questions")
    public void viewQuestions() {
        catalogSteps.selectFirstProductCard();
        productSteps.clickQuestionsButton();
        productSteps.clickViewAllQuestionButton();

        Assert.assertTrue(userActivitySteps.isQuestionTitleDisplayed());
    }

    @Test(description = "Open product popup")
    public void openProductPopup() {
        String cardBrand = catalogSteps.getFirstProductCardBrand();
        double cardPrice = catalogSteps.getFirstProductCardPrice();
        catalogSteps.clickFirstPopupButton();
        String popupBrand = popupSteps.getProductBrand();
        double popupPrice = popupSteps.getProductPrice();

        Assert.assertTrue(popupSteps.isPopupBlockDisplayed());
        Assert.assertEquals(cardBrand, popupBrand);
        Assert.assertEquals(cardPrice, popupPrice);
    }

    @Test(description = "Add product to basket")
    public void addProductToBasket() {
        double cardPrice = catalogSteps.getFirstProductCardPrice();
        catalogSteps.clickFirstButtonAddToBasket();
        catalogSteps.clickFirstButtonOfSizeList();
        headerSteps.clickBasketButton();
        double basketPrice = basketSteps.getFinalPrice();

        Assert.assertEquals(cardPrice, basketPrice);
    }
}
