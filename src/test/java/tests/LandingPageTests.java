package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


public class LandingPageTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void tappingLogInButton() {
        landingPage.verifyLandingPage();
        landingPage.clickOnLoginButton();
        loginPage.verifySuccessfulLogInModal();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void signUpNewUser() {
        landingPage.clickOnLoginButton();
        loginPage.clickSignUpTab();
        loginPage.fillInSignUpFields("rodrigo@email.com", "VeryDifficultPassword123.");
        loginPage.clickSignUpButton();
        loginPage.verifySuccessfulSignUpModal();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void loginExistingUser() {
        landingPage.clickOnLoginButton();
        loginPage.verifyLogInScreen();
        loginPage.fillInLoginTextFields("rodrigo@lala.com", "12345678");
        loginPage.clickLoginButton();
        loginPage.verifySuccessfulLogInModal();
    }
}
