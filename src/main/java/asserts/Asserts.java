package asserts;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Asserts {
    public static void checkForPage(String url) {
        webdriver().shouldHave(url(url));
    }

    public static void checkTextByXpath(String xpath, String expected) {
        $(By.xpath(xpath)).shouldHave(text(expected));
    }

    public static void checkEmptyInputById(String id) {
        $(By.id(id)).shouldBe(empty);
    }

    public static void checkForVisibleByXpath(String xpath) {
        $(By.xpath(xpath)).shouldBe(visible);
    }
}
