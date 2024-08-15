import Data.DataForTests;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import listener.Listener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;
import pages.SearchResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(Listener.class)
public class TestWb {

    @BeforeEach
    void setUp() {
        Configuration.timeout = 7000;
    }


    @Test
    @Feature("Поисковая строка, страница с результатами")
    @Story("Поиск с помощью поисковой строки")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Поиск с помощью поисковой строки, отображение страницы результатов, очистка строки")
    void testSearchInput() {
        MainPage mainPage = new MainPage();
        SearchResult searchResult = mainPage.search(DataForTests.SEARCH_VALUE);

        searchResult.checkResultOfSearch()
                .clearSearchField()
                .checkForClearSearchField();
    }

    @Test
    @Feature("Элемент для смены города")
    @Story("Смена адреса пвз")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Открытие элемента для смены города, смена адреса и сохранение нового адреса")
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
    @Feature("Категории и фильтры")
    @Story("Поиск по категориям, фильтрация результатов")
    @Severity(SeverityLevel.NORMAL)
    @Description("Поиск по категориям, проверка результата, ввод фильтров, проверка результата с фильтрами")
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

    @Test
    @Description("Должен упасть")
    void testToFailed() {
        assertEquals(1,2);
    }

    @Test
    @Description("Должен быть пропущеным")
    @Disabled
    void testToSkip(){
    }
}
