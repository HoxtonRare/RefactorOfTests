package elements;

import org.openqa.selenium.By;
import pages.SearchResult;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Catalog {
    private static final String XPATH_FOR_CATALOG = "//button[@aria-label = 'Навигация по сайту']";
    private static final String XPATH_FOR_ELECTRONIC = "//span[text() = 'Электроника']";
    private static final String XPATH_FOR_COMPUTERS_AND_LAPTOPS = "//span[text() = 'Ноутбуки и компьютеры']";
    private static final String XPATH_FOR_LAPTOPS = "//a[text() = 'Ноутбуки']";

    public void open() {
        $(By.xpath(XPATH_FOR_CATALOG)).shouldBe(clickable).click();
    }

    public SearchResult openLaptops() {
        $(By.xpath(XPATH_FOR_ELECTRONIC)).shouldBe(visible).hover();
        $(By.xpath(XPATH_FOR_COMPUTERS_AND_LAPTOPS)).shouldBe(clickable).click();
        $(By.xpath(XPATH_FOR_LAPTOPS)).shouldBe(clickable).click();
        return new SearchResult();
    }
}
