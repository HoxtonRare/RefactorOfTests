package pages;

import asserts.Asserts;
import elements.FilterSelection;
import elements.SearchField;
import io.qameta.allure.Step;

public class SearchResult {
    private static final String TEXT_AFTER_SEARCH = "По запросу Iphone 13 найдено";
    private static final String SORTING_SEARCH = "По популярности";
    private static final String FIRST_FILTER = "Iphone 13";
    private static final String FILTER_MANUFACTURER = "Apple";
    private static final String PAGE_AFTER_SEARCH = "https://www.wildberries.ru/catalog/elektronika/noutbuki-pereferiya/noutbuki-ultrabuki";
    private static final String PAGE_WITH_FILTERS = "https://www.wildberries.ru/catalog/elektronika/noutbuki-pereferiya/noutbuki-ultrabuki?sort=popular&page=1&fdlvr=72&fbrand=6049&priceU=10000000%3B14900000&f4474=8071618";
    private static final String XPATH_FOR_COUNT_OF_PRODUCT_ON_PAGE = "//span[@class = 'goods-count']";
    private static final String XPATH_FOR_FIRST_FILTER_ON_PAGE = "(//span[@class = 'your-choice__btn'])[1]";
    private static final String XPATH_FOR_SECOND_FILTER_ON_PAGE = "(//span[@class = 'your-choice__btn'])[2]";
    private static final String XPATH_FOR_THIRD_FILTER_ON_PAGE = "(//span[@class = 'your-choice__btn'])[3]";
    private static final String XPATH_FOR_FOURTH_FILTER_ON_PAGE = "(//span[@class = 'your-choice__btn'])[4]";
    private static final String XPATH_FOR_RESET_FILTERS = "//button[@class = 'your-choice__btn']";
    private static final String XPATH_FOR_TEXT_AFTER_SEARCH = "//h1";
    private static final String XPATH_FOR_FIRST_FILTER = "//*[@class = 'dropdown-filter__btn'][1]";
    private static final String XPATH_FOR_SORTING = "//div[@class='dropdown-filter'][1]/button";
    private static final String XPATH_FOR_MANUFACTURER = "//div[@class='product-card-list']/descendant::article[1]//span[@class = 'product-card__brand']";

    FilterSelection filterSelection = new FilterSelection();

    SearchField searchField = new SearchField();

    @Step("Проверка результатов поиска")
    public SearchResult checkResultOfSearch() {
        Asserts.checkTextByXpath(XPATH_FOR_TEXT_AFTER_SEARCH, TEXT_AFTER_SEARCH);
        Asserts.checkTextByXpath(XPATH_FOR_FIRST_FILTER, FIRST_FILTER);
        Asserts.checkTextByXpath(XPATH_FOR_SORTING, SORTING_SEARCH);
        Asserts.checkTextByXpath(XPATH_FOR_MANUFACTURER, FILTER_MANUFACTURER);
        return this;
    }

    @Step("Очистка поисковой строки")
    public SearchResult clearSearchField() {
        searchField.clear();
        return this;
    }

    @Step("Проверка очистки поисковой строки")
    public SearchResult checkForClearSearchField() {
        Asserts.checkEmptyInputById(searchField.getID());
        return this;
    }

    @Step("Проверка, открылась ли страница из каталога")
    public SearchResult isOpenFromCatalog() {
        Asserts.checkForPage(PAGE_AFTER_SEARCH);
        return this;
    }

    @Step("Проверка, применились ли фильтры")
    public SearchResult isApplyFilters() {
        Asserts.checkForPage(PAGE_WITH_FILTERS);
        return this;
    }

    @Step("Проверка, соответствует ли количество товара на странице, количеству в фильтрах")
    public SearchResult checkCountOfProduct(String expected) {
        Asserts.checkTextByXpath(XPATH_FOR_COUNT_OF_PRODUCT_ON_PAGE, expected);
        return this;
    }

    @Step("Проверка, отображаются ли применённые фильтры на странице")
    public void checkForApplyFilters(String firstFilter, String secondFilter, String thirdFilter, String fourthFilter) {
        Asserts.checkTextByXpath(XPATH_FOR_FIRST_FILTER_ON_PAGE, firstFilter);
        Asserts.checkTextByXpath(XPATH_FOR_SECOND_FILTER_ON_PAGE, secondFilter);
        Asserts.checkTextByXpath(XPATH_FOR_THIRD_FILTER_ON_PAGE, thirdFilter);
        Asserts.checkTextByXpath(XPATH_FOR_FOURTH_FILTER_ON_PAGE, fourthFilter);
        Asserts.checkForVisibleByXpath(XPATH_FOR_RESET_FILTERS);
    }

    @Step("Открытие элеметна с вводом фильтров")
    public SearchResult openFilters() {
        filterSelection.open();
        return this;
    }

    @Step("Установка начальной цены")
    public SearchResult setFilterStartPrice(String price) {
        filterSelection.setStartPrice(price);
        return this;
    }

    @Step("Установка конечной цены")
    public SearchResult setFilterEndPrice(String price) {
        filterSelection.setEndPrice(price);
        return this;
    }

    @Step("Установка срока доставки")
    public SearchResult setFilterDelivery() {
        filterSelection.setDelivery();
        return this;
    }

    @Step("Установка диагонали")
    public SearchResult setFilterDiagonal() {
        filterSelection.setDiagonal();
        return this;
    }

    @Step("Установка производителя")
    public SearchResult setFilterManufacturer() {
        filterSelection.setManufacturer();
        return this;
    }

    @Step("Применение фильтров")
    public SearchResult applyFilters() {
        filterSelection.applyFilters();
        return this;
    }

    @Step("Возвращение количества товаров, указанных в элементе с фильтрами")
    public String getCountOfProduct(String expected) {
        return filterSelection.getCountProduct(expected);
    }
}
