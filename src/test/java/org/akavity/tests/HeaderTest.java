package org.akavity.tests;

import io.qameta.allure.Description;
import org.akavity.annotations.TestData;
import org.akavity.models.headerTest.*;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class HeaderTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    GeoSteps geoSteps = new GeoSteps();
    PromoSteps promoSteps = new PromoSteps();

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "headerTest", jsonFile = "catalogData", model = "CatalogData")
    @Description("Import class")
    public void catalogNavigation(CatalogData catalog) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(catalog.getMainListItem());
        navigationSteps.clickDropListItem(catalog.getMainListItem(), catalog.getFirstDropListItem(), catalog.getSecondDropListItem());

        String actual = catalogSteps.extractTextFromTitle();
        Assertions.assertEquals(actual, catalog.getTitle());
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "headerTest", jsonFile = "serviceMenuData", model = "ServiceMenuData")
    @Description("Service menu navigation")
    public void serviceMenuNavigation(ServiceMenuData serviceMenuData) {
        headerSteps.clickAddressButton();
        headerSteps.clickServiceMenuItem(serviceMenuData.getItem());

        Assertions.assertTrue(headerSteps.isTitleVDisplayed(serviceMenuData.getTitle()));
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "headerTest", jsonFile = "currencyData", model = "CurrencyData")
    @Description("Select a currency type")
    public void selectCurrencyType(CurrencyData currencyData) {
        headerSteps.selectCurrency(currencyData.getCurrency());

        Assertions.assertTrue(catalogSteps.isCurrencyCorrect(currencyData.getSymbol()));
    }

    @Test
    @Description("Select a pickup point")
    public void selectPickUpPoint() {
        headerSteps.clickGeolocationButton();
        geoSteps.clickFirstPickupPoint();

        Assertions.assertTrue(geoSteps.isPickupPointTitleDisplayed());
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "headerTest", jsonFile = "localWarehouseData", model = "LocalWarehouseData")
    @Description("Select a product from the local warehouse")
    public void selectProductFromLocalWarehouse(LocalWarehouseData belGoods) {
        headerSteps.clickCatalogButton();
        navigationSteps.hoverMainListItem(belGoods.getMainListItem());
        navigationSteps.clickDropListItem(belGoods.getMainListItem(), belGoods.getFirstDropListItem(), belGoods.getSecondDropListItem());
        promoSteps.clickContentItem(belGoods.getFirstContentItem(), belGoods.getSecondContentItem(), belGoods.getThirdContentItem());

        String actual = catalogSteps.extractTextFromTitle();
        Assertions.assertEquals(actual, belGoods.getTitle());
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "headerTest", jsonFile = "promotionData", model = "PromotionData")
    @Description("Select a promotion")
    public void selectPromotion(PromotionData promotion) {
        headerSteps.clickCatalogButton();
        navigationSteps.hoverMainListItem(promotion.getMainListItem());
        navigationSteps.clickDropListItem(promotion.getMainListItem(), promotion.getFirstDropListItem(), promotion.getSecondDropListItem());

        String actual = catalogSteps.extractTextFromTitle();
        Assertions.assertEquals(actual, promotion.getTitle());
    }
}
