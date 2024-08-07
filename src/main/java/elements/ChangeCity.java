package elements;

import asserts.Asserts;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ChangeCity {
private static final String XPATH_FOR_INPUT_CITY = "//input [@autocomplete = 'off'][@placeholder = 'Введите адрес']";
private static final String XPATH_FOR_GET_FIRST_ADDRESS = "//div[@id='pooList']/div[1]//span[@class = 'address-item__name-text']";
private static final String XPATH_FOR_ADDRESS = "//span[@class = 'details-self__name-text']";
private static final String XPATH_FOR_FIRST_ADDRESS = "//div[@id='pooList']/div[1]";
private static final String XPATH_FOR_APPLY_ADDRESS = "//button[text() = 'Выбрать']";

    public void open() {
        $(By.xpath("//li[@class = 'simple-menu__item j-geocity-wrap']")).shouldBe(visible).click();
    }

    public void inputCity(String city) {
        $(By.xpath(XPATH_FOR_INPUT_CITY)).shouldBe(visible)
                .setValue(city).pressEnter();
    }

    public String getFirstAddress() {
        return $(By.xpath(XPATH_FOR_GET_FIRST_ADDRESS)).getText();
    }

    public void openFirstAddressPage() {
        $(By.xpath(XPATH_FOR_FIRST_ADDRESS)).click();
    }

    public void selectAddress() {
        $(By.xpath(XPATH_FOR_APPLY_ADDRESS)).click();
    }

    public void checkAddress(String expected) {
        $(By.xpath(XPATH_FOR_ADDRESS)).shouldBe(visible);
        Asserts.checkTextByXpath(XPATH_FOR_ADDRESS, expected);
    }
}
