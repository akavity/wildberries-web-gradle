package org.akavity.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.sortTest.PriceData;
import org.akavity.steps.CatalogSteps;
import org.akavity.steps.FilterDropDownSteps;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.NavigationSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    FilterDropDownSteps filterDDSteps = new FilterDropDownSteps();
    CatalogSteps catalogSteps = new CatalogSteps();

    @TestData(jsonFile = "priceData", model = "PriceData", folder = "sortTest")
    @Test(description = "Check that product prices are within the limit", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortProductsByPrice(PriceData price) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(price.getMainListItem());
        navigationSteps.clickDropListItem(price.getMainListItem(), price.getFirstDropListItem(), price.getSecondDropListItem());
        filterDDSteps.clickButtonDDF(price.getButton());
        filterDDSteps.enterMinMaxAmount(price.getMinPrice(), price.getMaxPrice());

        Assert.assertTrue(catalogSteps.areProductPricesWithinLimit(price.getMinPrice(), price.getMaxPrice()));
    }
}
