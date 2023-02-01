package ru.stellar.burgers;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.stellar.burgers.pageobjects.LoginPage;

public class TestLoginPage extends ChooseDriver {
    private WebDriver driver;
    private String email;
    private String password;

    @Before
    public void startUp() {
        this.driver = getDriver(BrowserName.Yandex);
        email = "test-data@yandex.ru";
        password = "password";
    }

    @Test
    public void loginViaLoginButton() {
        driver.get("https://stellarburgers.nomoreparties.site");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButtonOnMainPage();
        setFieldsAndClickButton(loginPage);
    }

    @Test
    public void loginThroughButtonPersonalAccount() {
        driver.get("https://stellarburgers.nomoreparties.site");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButtonPersonalAccountOnMainPage();
        setFieldsAndClickButton(loginPage);
    }

    @Test
    public void loginThroughButtonInRegistrationForm() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButtonInRegistrationForm();
        setFieldsAndClickButton(loginPage);
    }

    @Test
    public void loginViaButtonInPasswordRecoveryForm() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonInPasswordRecoveryForm();
        loginPage.setFieldEmail(email);
        loginPage.clickLoginButtonOnLoginPage();
    }

    @Step
    public void setFieldsAndClickButton(LoginPage loginPage) {
        loginPage.setFieldEmail(email);
        loginPage.setFieldPassword(password);
        loginPage.clickLoginButtonOnLoginPage();
    }

    @After
    public void teardown() {
        driver.close();
    }

}
