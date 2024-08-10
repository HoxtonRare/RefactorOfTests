import Data.DataForTests;
import com.codeborne.selenide.Configuration;
import elements.Catalog;
import elements.ChangeCity;
import elements.FilterSelection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchResult;

public class testWb {


    @BeforeEach
    void setUp() {
        Configuration.timeout = 7000;
    }


    @Test
    void testSearchInput() {
        MainPage mainPage = new MainPage();
        SearchResult searchResult = mainPage.search(DataForTests.SEARCH_VALUE);

        searchResult.checkResultOfSearch()
                .clearSearchField()
                .checkForClearSearchField();
    }

        @Test
        void testChangeCity() {
            MainPage mainPage = new MainPage();
            String result = mainPage.openChangeCityElement()
                            .inputCity(DataForTests.CITY_VALUE)
                            .getFirstAddress();
            mainPage.openFirstAddressPage()
                    .checkAddress(result)
                    .selectAddress()
                    .isOpen()
                    .checkForAddress(result);
        }

        @Test
        void testFilters() {
            String result = "";
            MainPage mainPage = new MainPage();
            SearchResult searchResult = mainPage.openCatalog().openLaptops();

            searchResult.isOpenFromCatalog();

            result = searchResult.openFilters().setFilterStartPrice(DataForTests.START_PRICE)
                    .setFilterEndPrice(DataForTests.END_PRICE)
                    .setFilterDelivery()
                    .setFilterDiagonal()
                    .setFilterManufacturer()
                    .getCountOfProduct(result);
            searchResult.applyFilters();

            searchResult.isApplyFilters()
                    .checkCountOfProduct(result)
                    .checkForApplyFilters(DataForTests.FILTER_DELIVERY, DataForTests.FILTER_MANUFACTURER, DataForTests.FILTER_PRICE, DataForTests.FILTER_DIAGONAL);
        }
}
