package ru.stellar.burgers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.stellar.burgers.pageobjects.SectionConstructor;

import static org.junit.Assert.assertTrue;

public class TestSectionConstructor extends ChooseDriver {
    private WebDriver driver;

    @Before
    public void startUp() {
        this.driver = getDriver(BrowserName.Yandex);
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    public void navigationThroughSections() {
        SectionConstructor sectionConstructor = new SectionConstructor(driver);

        sectionConstructor.clickOnButtonSaucesSection();
        assertTrue(sectionConstructor.openSaucesSection());

        sectionConstructor.clickOnButtonToppingsSection();
        assertTrue(sectionConstructor.openToppingsSection());

        sectionConstructor.clickOnButtonBunsSection();
        assertTrue(sectionConstructor.openBunsSection());
    }

    @After
    public void teardown() {
        driver.close();
    }
}
