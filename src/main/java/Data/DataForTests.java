package Data;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DataForTests {
    // Данные для тестов
    public static final String SEARCH_VALUE = "Iphone 13";
    public static final String CITY_VALUE = "Санкт-Петербург";
    public static final String FILTER_DELIVERY = "до 3 дней";
    public static final String FILTER_MANUFACTURER = "Apple";
    public static final String FILTER_PRICE = "от 100 000 до 149 000";
    public static final String FILTER_DIAGONAL = "13.3\"";
    public static final String START_PRICE = "100000";
    public static final String END_PRICE = "149000";
    public static final String XPATH_FOR_COUNT_PRODUCT_AFTER_FILTERS = "//p[@class = 'filters-desktop__count-goods']";


    //Методы для работы с данными
    public static String getExpetedCountOfProductAfterFilters(String expected) {
        expected = $(By.xpath(DataForTests.XPATH_FOR_COUNT_PRODUCT_AFTER_FILTERS)).getText();
        return expected.replace("Нашли ", "");
    }
}
