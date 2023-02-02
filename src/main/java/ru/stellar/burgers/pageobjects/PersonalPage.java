package ru.stellar.burgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalPage {
    private final By buttonPersonalAccount = By.xpath(".//nav/a/p");
    private final By buttonConstructor = By.xpath(".//li[1]/a/p");
    private final By buttonBurgerLogo = By.xpath(".//nav/div/a");
    private final By buttonLogout = By.xpath(".//li[3]/button");
    private final WebDriver driver;

    public PersonalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    public void clickOnButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    public void clickOnButtonBurgerLogo() {
        driver.findElement(buttonBurgerLogo).click();
    }

    public void clickOnButtonLogout() {
        driver.findElement(buttonLogout).click();
    }

    public String waitPersonalAccountPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/account/profile"));
        return driver.getCurrentUrl();
    }

    public String waitMainPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site"));
        return driver.getCurrentUrl();
    }
}
