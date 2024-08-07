package elements;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.SearchResult;

import static Data.DataForTests.getExpetedCountOfProductAfterFilters;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FilterSelection {
    public static final String XPATH_FOR_ALL_FILTERS = "//button[text() = 'Все фильтры']";
    public static final String XPATH_FOR_START_PRICE_FILTER = "//input[@name = 'startN']";
    public static final String XPATH_FOR_END_PRICE_FILTER = "//input[@name = 'endN']";
    public static final String XPATH_FOR_MANUFACTURER_FILTER = "//span[@class = 'checkbox-with-text__text'][text() = 'Apple']";
    public static final String XPATH_FOR_DIAGONAL_FILTER = "//span[@class = 'checkbox-with-text__text'][text() = '13.3\"']";
    public static final String XPATH_FOR_DELIVERY_THREE_DAYS_FILTER = "//span[text() = 'до 3 дней']";
    public static final String XPATH_FOR_APPLY_FILTERS = "//button[text() = 'Показать']";

    public void open() {
        $(By.xpath(XPATH_FOR_ALL_FILTERS)).shouldBe(visible).click();
    }

    public void setStartPrice(String value) {
        $(By.xpath(XPATH_FOR_START_PRICE_FILTER)).shouldBe(visible).setValue(value);
    }

    public void setEndPrice(String value) {
        $(By.xpath(XPATH_FOR_END_PRICE_FILTER)).shouldBe(visible).setValue(value);
    }

    public void setManufacturer() {
        $(By.xpath(XPATH_FOR_MANUFACTURER_FILTER)).shouldBe(clickable).click();
    }

    public void setDiagonal() {
        $(By.xpath(XPATH_FOR_DIAGONAL_FILTER)).shouldBe(clickable).click();
    }

    public void setDelivery() {
        $(By.xpath(XPATH_FOR_DELIVERY_THREE_DAYS_FILTER)).shouldBe(clickable).click();
    }

    public SearchResult applyFilters() {
        $(By.xpath(XPATH_FOR_APPLY_FILTERS)).shouldBe(clickable).click();
        return new SearchResult();
    }

    public String getCountProduct(String expected) {
        Selenide.sleep(1000);
        expected = getExpetedCountOfProductAfterFilters(expected);
        return expected;
    }
}
