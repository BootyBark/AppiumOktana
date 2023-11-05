package tests;

import browserstack.BrowserstackExecution;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.driver.MobileDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.LandingPage;
import pages.LogInPage;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
        protected AppiumDriver driver;
        protected WebDriverWait wait;
        protected String platform;
        protected LandingPage landingPage;
        protected LogInPage loginPage;

    @BeforeMethod
    public void setUp(Method method){
        driver = MobileDriver.getInstance();
        platform = MobileDriver.properties.getProperty("platform").toLowerCase();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        landingPage = new LandingPage(driver);
        loginPage = new LogInPage(driver);

        String testName = method.getName();
        BrowserstackExecution.setTestCaseName(driver, testName);
    }

    @AfterMethod
    public void tearDown(ITestResult result){

        BrowserstackExecution.setTestCaseStatus(driver, result);
        driver.quit();

    }
}
