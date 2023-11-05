package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LogInPage extends BasePage {

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Login / Sign up Form\" AND type == \"XCUIElementTypeStaticText\"")
    @AndroidFindBy(xpath = "//*[@text = 'Login / Sign up Form']")
    public WebElement loginHeader;

    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Login'")
    @AndroidFindBy (accessibility = "button-login-container")
    public WebElement loginTab;

    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Sign up'")
    @AndroidFindBy(accessibility = "button-sign-up-container")
    public WebElement signupTab;

    @iOSXCUITFindBy(accessibility = "input-email")
    @AndroidFindBy(accessibility = "input-email")
    public WebElement emailTextField;

    @iOSXCUITFindBy(accessibility = "input-password")
    @AndroidFindBy(accessibility = "input-password")
    public WebElement passwordTextField;

    @iOSXCUITFindBy(accessibility = "input-repeat-password")
    @AndroidFindBy(accessibility = "input-repeat-password")
    public WebElement confirmPasswordTextField;

    @iOSXCUITFindBy(accessibility = "When the device has Touch/FaceID (iOS) or FingerPrint enabled a biometrics button will be shown to use and test the login.")
    @AndroidFindBy(xpath = "//*[@text = 'When the device has Touch/FaceID (iOS) or FingerPrint enabled a biometrics button will be shown to use and test the login.']")
    public WebElement loginDescription;

    @iOSXCUITFindBy(accessibility = "button-LOGIN")
    @AndroidFindBy (accessibility = "button-LOGIN")
    public WebElement loginButton;

    @iOSXCUITFindBy(accessibility = "button-SIGN UP")
    @AndroidFindBy(accessibility = "button-SIGN UP")
    public WebElement signupButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Success' AND type == 'XCUIElementTypeStaticText'")
    @AndroidFindBy(id = "android:id/alertTitle")
    public WebElement successAlertHeader;

    @iOSXCUITFindBy(accessibility = "You are logged in!")
    @AndroidFindBy(id = "android:id/message")
    public WebElement successAlertSubHeader;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Signed Up!' AND type == 'XCUIElementTypeStaticText'")
    @AndroidFindBy(id = "android:id/alertTitle")
    public WebElement successSignUpModalHeader;

    @iOSXCUITFindBy(accessibility = "You successfully signed up!")
    @AndroidFindBy(id = "android:id/message")
    public WebElement successSignUpModalSubheader;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "android:id/button1")
    public WebElement successAlertOkButton;

    public LogInPage(AppiumDriver remoteDriver) {
        super(remoteDriver);
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Verify the Log In Screen loads correctly")
    public void verifyLogInScreen() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        Assert.assertTrue(loginHeader.isDisplayed());
        Assert.assertTrue(loginTab.isDisplayed());
        Assert.assertTrue(signupTab.isDisplayed());
        Assert.assertTrue(emailTextField.isDisplayed());
        Assert.assertTrue(passwordTextField.isDisplayed());
        Assert.assertTrue(loginDescription.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @Step("Fill In Login Text fields")
    public void fillInLoginTextFields(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
    }

    @Step("Click the Login Button")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Verify the Success Login Modal")
    public void verifySuccessfulLogInModal() {
        wait.until(ExpectedConditions.visibilityOf(successAlertOkButton));
        Assert.assertTrue(successAlertHeader.isDisplayed());
        Assert.assertTrue(successAlertSubHeader.isDisplayed());
        Assert.assertTrue(successAlertOkButton.isDisplayed());
    }

    @Step("Click the Sign Up Tab in the Login screen")
    public void clickSignUpTab() {
        wait.until(ExpectedConditions.visibilityOf(signupTab));
        signupTab.click();
    }

    @Step("Fill In SignUp Text fields")
    public void fillInSignUpFields(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(signupButton));
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        confirmPasswordTextField.sendKeys(password);
    }

    @Step("Click Sign Up Button")
    public void clickSignUpButton() {
        signupButton.click();
    }

    @Step("Verify the success sign up Modal")
    public void verifySuccessfulSignUpModal() {
        wait.until(ExpectedConditions.visibilityOf(successAlertOkButton));
        Assert.assertTrue(successAlertOkButton.isDisplayed());
        Assert.assertTrue(successSignUpModalSubheader.isDisplayed());
        Assert.assertTrue(successSignUpModalHeader.isDisplayed());
    }
}
