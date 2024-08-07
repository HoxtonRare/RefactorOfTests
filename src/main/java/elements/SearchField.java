package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchField {

    private final String ID = "searchInput";
    private final String XPATH_FOR_CLEAR = "//button[@aria-label = 'Очистить поиск']";


    public void search(String searchRequest) {
        $(By.id(ID)).setValue(searchRequest).pressEnter();
    }

    public void clear() {
        $(By.xpath(XPATH_FOR_CLEAR)).click();
    }

    public String getID() {
        return ID;
    }
}
