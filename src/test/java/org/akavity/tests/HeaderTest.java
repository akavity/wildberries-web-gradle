package org.akavity.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.headerTest.*;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    GeoSteps geoSteps = new GeoSteps();
    PromoSteps promoSteps = new PromoSteps();


    @TestData(jsonFile = "catalogData", model = "CatalogData", folder = "headerTest")
    @Test(description = "Catalog navigation", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void catalogNavigation(CatalogData catalog) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(catalog.getMainListItem());
        navigationSteps.clickDropListItem(catalog.getMainListItem(), catalog.getFirstDropListItem(), catalog.getSecondDropListItem());

        String actual = catalogSteps.extractTextFromTitle();
        Assert.assertEquals(actual, catalog.getTitle());
    }

    @TestData(jsonFile = "serviceMenuData", model = "ServiceMenuData", folder = "headerTest")
    @Test(description = "Service menu navigation", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void serviceMenuNavigation(ServiceMenuData serviceMenuData) {
        headerSteps.clickAddressButton();
        headerSteps.clickServiceMenuItem(serviceMenuData.getItem());

        Assert.assertTrue(headerSteps.isTitleVDisplayed(serviceMenuData.getTitle()));
    }

    @TestData(jsonFile = "currencyData", model = "CurrencyData", folder = "headerTest")
    @Test(description = "Select a currency type", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectCurrencyType(CurrencyData currencyData) {
        headerSteps.selectCurrency(currencyData.getCurrency());

        Assert.assertTrue(catalogSteps.isCurrencyCorrect(currencyData.getSymbol()));
    }

    @Test(description = "Select a pickup point")
    public void selectPickUpPoint() {
        headerSteps.clickGeolocationButton();
        geoSteps.clickFirstPickupPoint();

        Assert.assertTrue(geoSteps.isPickupPointTitleDisplayed());
    }

    @TestData(jsonFile = "localWarehouseData", model = "LocalWarehouseData", folder = "headerTest")
    @Test(description = "Select a product from the local warehouse", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectProductFromLocalWarehouse(LocalWarehouseData belGoods) {
        headerSteps.clickCatalogButton();
        navigationSteps.hoverMainListItem(belGoods.getMainListItem());
        navigationSteps.clickDropListItem(belGoods.getMainListItem(), belGoods.getFirstDropListItem(), belGoods.getSecondDropListItem());
        promoSteps.clickContentItem(belGoods.getFirstContentItem(), belGoods.getSecondContentItem(), belGoods.getThirdContentItem());

        String actual = catalogSteps.extractTextFromTitle();
        Assert.assertEquals(actual, belGoods.getTitle());
    }

    @TestData(jsonFile = "promotionData", model = "PromotionData", folder = "headerTest")
    @Test(description = "Select a promotion", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectPromotion(PromotionData promotion) {
        headerSteps.clickCatalogButton();
        navigationSteps.hoverMainListItem(promotion.getMainListItem());
        navigationSteps.clickDropListItem(promotion.getMainListItem(), promotion.getFirstDropListItem(), promotion.getSecondDropListItem());

        String actual = catalogSteps.extractTextFromTitle();
        Assert.assertEquals(actual, promotion.getTitle());
    }
}
