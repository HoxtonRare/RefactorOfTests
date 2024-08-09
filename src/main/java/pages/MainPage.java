package pages;

import asserts.Asserts;
import elements.Catalog;
import elements.ChangeCity;
import elements.SearchField;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String WB = "https://www.wildberries.ru/";
    private final String XPATH_FOR_CHANGE_CITY = "//li[@class = 'simple-menu__item j-geocity-wrap']";
    private static final String XPATH_FOR_FIRST_PRODUCT_ON_MAIN_PAGE = "//div[@class='main-page__content']/descendant::article[1]/div/a";

    private SearchField searchField = new SearchField();
    private Catalog catalog = new Catalog();
    private ChangeCity changeCity = new ChangeCity();

    public MainPage() {
        open(WB);
        $(By.xpath(XPATH_FOR_FIRST_PRODUCT_ON_MAIN_PAGE)).shouldBe(enabled);
    }

    public SearchResult search(String value) {
        searchField.search(value);
        return new SearchResult();
    }

    public MainPage openChangeCityElement() {
        changeCity.open();
        return this;
    }

    public void checkForAddress(String expected) {
        Asserts.checkTextByXpath(XPATH_FOR_CHANGE_CITY, expected);
    }

    public MainPage openCatalog() {
        catalog.open();
        return this;
    }

    public SearchResult openLaptops () {
        catalog.openLaptops();
        return new SearchResult();
    }

    public void isOpen() {
        Asserts.checkForPage(WB);
    }

    public MainPage inputCity(String city) {
        changeCity.inputCity(city);
        return this;
    }

    public String getFirstAddress() {
        return changeCity.getFirstAddress();
    }

    public MainPage openFirstAddressPage() {
        changeCity.openFirstAddressPage();
        return this;
    }

    public void checkAddress(String expected) {
        changeCity.checkAddress(expected);
    }

    public MainPage selectAddress() {
        changeCity.selectAddress();
        return this;
    }
}
