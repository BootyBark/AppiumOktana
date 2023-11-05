package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static AppiumDriver driver;
    protected static WebDriverWait wait;

    public BasePage (AppiumDriver remoteDriver){
        PageFactory.initElements(new AppiumFieldDecorator(remoteDriver), this);
        driver = remoteDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
    }
}
