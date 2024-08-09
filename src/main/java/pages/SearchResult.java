package pages;

import Data.DataForTests;
import asserts.Asserts;
import elements.FilterSelection;
import elements.SearchField;

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

    public void checkResultOfSearch() {
        Asserts.checkTextByXpath(XPATH_FOR_TEXT_AFTER_SEARCH, TEXT_AFTER_SEARCH);
        Asserts.checkTextByXpath(XPATH_FOR_FIRST_FILTER, FIRST_FILTER);
        Asserts.checkTextByXpath(XPATH_FOR_SORTING, SORTING_SEARCH);
        Asserts.checkTextByXpath(XPATH_FOR_MANUFACTURER, FILTER_MANUFACTURER);
    }

    public void clearSearchField() {
        searchField.clear();
    }

    public void checkForClearSearchField() {
        Asserts.checkEmptyInputById(searchField.getID());
    }

    public void isOpenFromCatalog() {
        Asserts.checkForPage(PAGE_AFTER_SEARCH);
    }

    public void isApplyFilters() {
        Asserts.checkForPage(PAGE_WITH_FILTERS);
    }

    public FilterSelection openFilterSelection() {
        filterSelection.open();
        return filterSelection;
    }

    public void checkCountOfProduct(String expected) {
        Asserts.checkTextByXpath(XPATH_FOR_COUNT_OF_PRODUCT_ON_PAGE, expected);
    }

    public void checkForApplyFilters(String firstFilter, String secondFilter, String thirdFilter, String fourthFilter) {
        Asserts.checkTextByXpath(XPATH_FOR_FIRST_FILTER_ON_PAGE, firstFilter);
        Asserts.checkTextByXpath(XPATH_FOR_SECOND_FILTER_ON_PAGE, secondFilter);
        Asserts.checkTextByXpath(XPATH_FOR_THIRD_FILTER_ON_PAGE, thirdFilter);
        Asserts.checkTextByXpath(XPATH_FOR_FOURTH_FILTER_ON_PAGE, fourthFilter);
        Asserts.checkForVisibleByXpath(XPATH_FOR_RESET_FILTERS);
    }

    public SearchResult openFilters() {
        filterSelection.open();
        return this;
    }

    public SearchResult setFilterStartPrice(String price) {
        filterSelection.setStartPrice(price);
        return this;
    }

    public SearchResult setFilterEndPrice(String price) {
        filterSelection.setEndPrice(price);
        return this;
    }

    public SearchResult setFilterDelivery() {
        filterSelection.setDelivery();
        return this;
    }

    public SearchResult setFilterDiagonal() {
        filterSelection.setDiagonal();
        return this;
    }

    public SearchResult setFilterManufacturer() {
        filterSelection.setManufacturer();
        return this;
    }

    public SearchResult applyFilters() {
        filterSelection.applyFilters();
        return this;
    }

    public String getCountOfProduct(String expected) {
        return filterSelection.getCountProduct(expected);
    }
}
