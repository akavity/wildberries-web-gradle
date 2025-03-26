package org.akavity.tests;

import io.qameta.allure.Description;
import org.akavity.annotations.TestData;
import org.akavity.models.sortTest.PriceData;
import org.akavity.steps.CatalogSteps;
import org.akavity.steps.FilterDropDownSteps;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.NavigationSteps;
import org.akavity.utils.JsonReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;


public class SortTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    FilterDropDownSteps filterDDSteps = new FilterDropDownSteps();
    CatalogSteps catalogSteps = new CatalogSteps();

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "sortTest", jsonFile = "priceData", model = "PriceData")
    @Description("Check that product prices are within the limit")
    public void sortProductsByPrice(PriceData price) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(price.getMainListItem());
        navigationSteps.clickDropListItem(price.getMainListItem(), price.getFirstDropListItem(), price.getSecondDropListItem());
        filterDDSteps.clickButtonDDF(price.getButton());
        filterDDSteps.enterMinMaxAmount(price.getMinPrice(), price.getMaxPrice());

        Assertions.assertTrue(catalogSteps.areProductPricesWithinLimit(price.getMinPrice(), price.getMaxPrice()));
    }
}
