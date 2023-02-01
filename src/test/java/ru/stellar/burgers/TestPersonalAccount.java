package ru.stellar.burgers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.stellar.burgers.pageobjects.LoginPage;
import ru.stellar.burgers.pageobjects.PersonalPage;

import static org.junit.Assert.assertEquals;

public class TestPersonalAccount extends ChooseDriver {
    private WebDriver driver;
    private String email;
    private String password;

    @Before
    public void startUp() {
        this.driver = getDriver(BrowserName.Google);
        email = "test-data@yandex.ru";
        password = "password";
        driver.get("https://stellarburgers.nomoreparties.site");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButtonOnMainPage();
        loginPage.setFieldEmail(email);
        loginPage.setFieldPassword(password);
        loginPage.clickLoginButtonOnLoginPage();
    }

    @Test
    public void clickGoPersonalAccountFromMainPage() {
        String expected = "https://stellarburgers.nomoreparties.site/account/profile";

        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.clickOnButtonPersonalAccount();
        assertEquals(expected, personalPage.waitPersonalAccountPage());
    }

    @Test
    public void transitionFromPersonalAccountToConstructor() {
        String expected = "https://stellarburgers.nomoreparties.site";
        driver.get("https://stellarburgers.nomoreparties.site/account/profile");
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.clickOnButtonConstructor();
        assertEquals(expected, personalPage.waitMainPage());
    }

    @Test
    public void transitionFromPersonalOnStellarBurgersLogo() {
        String expected = "https://stellarburgers.nomoreparties.site";
        driver.get("https://stellarburgers.nomoreparties.site/account/profile");

        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.clickOnButtonBurgerLogo();
        assertEquals(expected, personalPage.waitMainPage());
    }

    @Test
    public void clickLogoutInPersonalAccount() {
        driver.get("https://stellarburgers.nomoreparties.site/account/profile");
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.clickOnButtonBurgerLogo();
    }

    @After
    public void teardown() {
        driver.close();
    }
}
