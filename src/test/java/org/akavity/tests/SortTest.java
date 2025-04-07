package org.akavity.tests;

import io.qameta.allure.Description;
import org.akavity.annotations.TestData;
import org.akavity.models.sortTest.*;
import org.akavity.steps.CatalogSteps;
import org.akavity.steps.FiltersBlockSteps;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.NavigationSteps;
import org.akavity.utils.JsonReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;


public class SortTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    FiltersBlockSteps filtersBlockSteps = new FiltersBlockSteps();
    CatalogSteps catalogSteps = new CatalogSteps();

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(folder = "sortTest", jsonFile = "priceData", model = "PriceData")
    @Description("Check that product prices are within the limit")
    public void sortProductsByPrice(PriceData price) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(price.getMainListItem());
        navigationSteps.clickDropListItem(price.getMainListItem(), price.getFirstDropListItem(), price.getSecondDropListItem());
        filtersBlockSteps.clickFilterButton(price.getButton());
        filtersBlockSteps.enterMinMaxAmount(price.getMinPrice(), price.getMaxPrice());

        Assertions.assertTrue(catalogSteps.areProductPricesWithinLimit(price.getMinPrice(), price.getMaxPrice()));
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(jsonFile = "ascendingPriceData", model = "AscendingPriceData", folder = "sortTest")
    @Description("Sort products by ascending price")
    public void sortByAscendingPrice(AscendingPriceData ascendingPrice) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(ascendingPrice.getMainListItem());
        navigationSteps.clickDropListItem(ascendingPrice.getMainListItem(), ascendingPrice.getFirstDropListItem(), ascendingPrice.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(ascendingPrice.getSortType());

        Assertions.assertTrue(catalogSteps.checkSortByAscendingPrice(ascendingPrice.getElements()));
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(jsonFile = "decreasingPriceData", model = "DecreasingPriceData", folder = "sortTest")
    @Description("Sort products by decreasing price")
    public void sortByDecreasingPrice(DecreasingPriceData decreasingPrice) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(decreasingPrice.getMainListItem());
        navigationSteps.clickDropListItem(decreasingPrice.getMainListItem(), decreasingPrice.getFirstDropListItem(), decreasingPrice.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(decreasingPrice.getSortType());

        Assertions.assertTrue(catalogSteps.checkSortByDecreasingPrice(decreasingPrice.getElements()));
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(jsonFile = "noveltyData", model = "NoveltyData", folder = "sortTest")
    @Description("Sort products by newness")
    public void sortByNewness(NoveltyData noveltyData) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(noveltyData.getMainListItem());
        navigationSteps.clickDropListItem(noveltyData.getMainListItem(), noveltyData.getFirstDropListItem(), noveltyData.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(noveltyData.getSortType());

        Assertions.assertTrue(catalogSteps.checkNewTips(noveltyData.getElements()));
    }

    @ParameterizedTest
    @ArgumentsSource(JsonReader.class)
    @TestData(jsonFile = "ratingData", model = "RatingData", folder = "sortTest")
    @Description("Sort products by rating")
    public void sortByRating(RatingData ratingData) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(ratingData.getMainListItem());
        navigationSteps.clickDropListItem(ratingData.getMainListItem(), ratingData.getFirstDropListItem(), ratingData.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(ratingData.getSortType());

        Assertions.assertTrue(catalogSteps.checkRatingTips(ratingData.getElements(), ratingData.getMinRating()));
    }
}
