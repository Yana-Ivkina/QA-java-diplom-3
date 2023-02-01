package ru.stellar.burgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private final By fieldName = By.xpath(".//fieldset[1]/div/div/input");
    private final By fieldEmail = By.xpath(".//fieldset[2]/div/div/input");
    private final By fieldPassword = By.xpath("//fieldset[3]/div/div/input");
    private final By buttonRegistration = By.xpath(".//form/button");
    private final By errorRegistrationPassword = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFieldName(String username) {
        driver.findElement(fieldName).sendKeys(username);
    }

    public void setFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void setFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void clickOnButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    public String waitPageLogin() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        return driver.getCurrentUrl();
    }

    public boolean displayedPasswordError() {
        return driver.findElement(errorRegistrationPassword).isDisplayed();
    }
}
