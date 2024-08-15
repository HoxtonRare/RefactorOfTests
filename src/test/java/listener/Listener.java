package listener;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Listener implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (context.getExecutionException().isPresent()) {
            Allure.getLifecycle().addAttachment(
                    "Скриншот при падении", "image/png", "png",
                    Selenide.screenshot(OutputType.BYTES));
        }
        Allure.addAttachment("Браузер: ", Selenide.webdriver().driver().browser().name);
        Allure.addAttachment("Дата и время: ", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
