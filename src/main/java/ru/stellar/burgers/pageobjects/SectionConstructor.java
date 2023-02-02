package ru.stellar.burgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SectionConstructor {
    private final WebDriver driver;

    private final By buttonBunsSection = By.xpath(".//section[1]/div[1]/div[1]");
    private final By buttonSaucesSection = By.xpath(".//section[1]/div[1]/div[2]");
    private final By buttonToppingsSection = By.xpath(".//section[1]/div[1]/div[3]");
    private final By sectionBun = By.xpath(".//section[1]/div[2]/ul[1]");
    private final By sectionSauces = By.xpath(".//section[1]/div[2]/ul[2]");
    private final By sectionToppings = By.xpath(".//section[1]/div[2]/ul[3]");

    public SectionConstructor(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnButtonBunsSection() {
        driver.findElement(buttonBunsSection).click();
    }

    public void clickOnButtonSaucesSection() {
        driver.findElement(buttonSaucesSection).click();
    }

    public void clickOnButtonToppingsSection() {
        driver.findElement(buttonToppingsSection).click();
    }

    public boolean openBunsSection() {
        return driver.findElement(sectionBun).isDisplayed();
    }

    public boolean openSaucesSection() {
        return driver.findElement(sectionSauces).isDisplayed();
    }

    public boolean openToppingsSection() {
        return driver.findElement(sectionToppings).isDisplayed();
    }
}
