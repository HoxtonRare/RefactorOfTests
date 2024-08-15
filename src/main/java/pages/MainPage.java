package pages;

import asserts.Asserts;
import elements.Catalog;
import elements.ChangeCity;
import elements.SearchField;
import io.qameta.allure.Step;
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

    @Step("Поиск с помощью поисковой строки")
    public SearchResult search(String value) {
        searchField.search(value);
        return new SearchResult();
    }

    @Step("Открытие элемента для смены города")
    public MainPage openChangeCityElement() {
        changeCity.open();
        return this;
    }

    @Step("Проверка, совпадает ли адрес из списка с адресом из главной страницы")
    public MainPage checkForAddress(String expected) {
        Asserts.checkTextByXpath(XPATH_FOR_CHANGE_CITY, expected);
        return this;
    }

    @Step("Открытие каталога")
    public MainPage openCatalog() {
        catalog.open();
        return this;
    }

    @Step("Открытие категории 'Ноутбуки'")
    public SearchResult openLaptops () {
        catalog.openLaptops();
        return new SearchResult();
    }

    @Step("Проверка, открыта ли главная страница")
    public MainPage isOpen() {
        Asserts.checkForPage(WB);
        return this;
    }

    @Step("Ввод города в элементе для смены города")
    public MainPage inputCity(String city) {
        changeCity.inputCity(city);
        return this;
    }

    @Step("Получение первого адреса из списка")
    public String getFirstAddress() {
        return changeCity.getFirstAddress();
    }

    @Step("Открытие первого адреса из списка")
    public MainPage openFirstAddressPage() {
        changeCity.openFirstAddressPage();
        return this;
    }

    @Step("Проверка, совпадает ли адрес из списка с адресом из карточки")
    public MainPage checkAddress(String expected) {
        changeCity.checkAddress(expected);
        return this;
    }

    @Step("Подтверждение выбора адреса")
    public MainPage selectAddress() {
        changeCity.selectAddress();
        return this;
    }
}
