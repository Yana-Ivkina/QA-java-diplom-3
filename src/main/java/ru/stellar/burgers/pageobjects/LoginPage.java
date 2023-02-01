package ru.stellar.burgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By loginButtonPersonalAccountOnMainPage = By.xpath(".//nav/a");
    private final By loginButtonOnMainPage = By.xpath(".//section[2]/div/button");
    private final By loginButtonInRegistrationForm = By.className("Auth_link__1fOlj");
    private final By buttonInPasswordRecoveryForm = By.xpath(".//p[2]/a");
    private final By fieldEmail = By.xpath(".//fieldset[1]/div/div/input");
    private final By fieldPassword = By.xpath(".//fieldset[2]/div/div/input");
    private final By loginButtonOnLoginPage = By.xpath(".//form/button");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButtonPersonalAccountOnMainPage() {
        driver.findElement(loginButtonPersonalAccountOnMainPage).click();

    }

    public void clickLoginButtonOnMainPage() {
        driver.findElement(loginButtonOnMainPage).click();
    }

    public void clickLoginButtonInRegistrationForm() {
        driver.findElement(loginButtonInRegistrationForm).click();
    }

    public void clickButtonInPasswordRecoveryForm() {
        driver.findElement(buttonInPasswordRecoveryForm).click();
    }

    public void setFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void setFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void clickLoginButtonOnLoginPage() {
        driver.findElement(loginButtonOnLoginPage).click();
    }

}
