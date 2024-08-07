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

        searchResult.checkResultOfSearch();
        searchResult.clearSearchField();
        searchResult.checkForClearSearchField();
    }

        @Test
        void testChangeCity() {
            MainPage mainPage = new MainPage();
            ChangeCity changeCity = mainPage.openChangeCityElement();
            changeCity.inputCity(DataForTests.CITY_VALUE);
            String result = changeCity.getFirstAddress();
            changeCity.openFirstAddressPage();

            changeCity.checkAddress(result);
            changeCity.selectAddress();

            mainPage.isOpen();
            mainPage.checkForAddress(result);
        }

        @Test
        void testFilters() {
            String result = "";
            MainPage mainPage = new MainPage();
            Catalog catalog = mainPage.openCatalog();
            SearchResult searchResult = catalog.openLaptops();

            searchResult.isOpenFromCatalog();

            FilterSelection filterSelection = searchResult.openFilterSelection();
            filterSelection.setStartPrice(DataForTests.START_PRICE);
            filterSelection.setEndPrice(DataForTests.END_PRICE);
            filterSelection.setDelivery();
            filterSelection.setDiagonal();
            filterSelection.setManufacturer();
            result = filterSelection.getCountProduct(result);
            searchResult = filterSelection.applyFilters();

            searchResult.isApplyFilters();
            searchResult.checkCountOfProduct(result);
            searchResult.checkForApplyFilters(DataForTests.FILTER_DELIVERY, DataForTests.FILTER_MANUFACTURER, DataForTests.FILTER_PRICE, DataForTests.FILTER_DIAGONAL);
        }
}
