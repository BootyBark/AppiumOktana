package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LandingPage extends BasePage {

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"WEBDRIVER\" AND name == \"WEBDRIVER\" AND value == \"WEBDRIVER\"")
    @AndroidFindBy(xpath = "//*[@text='WEBDRIVER']")
    public WebElement webDriverString;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Login\"")
    @AndroidFindBy(accessibility = "Login")
    public WebElement loginTabBarButton;

    public LandingPage(AppiumDriver remoteDriver) {
        super(remoteDriver);
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Step("Verify the Landing Page loads correctly")
    public void verifyLandingPage() {
        wait.until(ExpectedConditions.visibilityOf(webDriverString));
        Assert.assertTrue(webDriverString.isDisplayed());
    }

    @Step("Click on the login button in the bottom tab bar")
    public void clickOnLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginTabBarButton));
        loginTabBarButton.click();
    }
}
