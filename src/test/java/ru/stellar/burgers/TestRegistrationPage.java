package ru.stellar.burgers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.stellar.burgers.pageobjects.RegistrationPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.github.javafaker.Faker;

public class TestRegistrationPage extends ChooseDriver {
    private WebDriver driver;

    @Before
    public void startUp() {
        this.driver = getDriver(BrowserName.Google);
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    public void testSuccessfulRegistration() {
        Faker faker = new Faker();
        String expected = "https://stellarburgers.nomoreparties.site/login";

        RegistrationPage registration = new RegistrationPage(driver);

        registration.setFieldName(faker.name().toString());
        registration.setFieldEmail(faker.internet().emailAddress());
        registration.setFieldPassword(faker.internet().password());
        registration.clickOnButtonRegistration();
        String actual = registration.waitPageLogin();

        assertEquals(expected, actual);
    }

    @Test
    public void passwordErrorWithSmallNumber() {
        Faker faker = new Faker();
        RegistrationPage registration = new RegistrationPage(driver);

        registration.setFieldName(faker.name().toString());
        registration.setFieldEmail(faker.internet().emailAddress());
        registration.setFieldPassword(faker.internet().password(1, 5));
        registration.clickOnButtonRegistration();

        assertTrue(registration.displayedPasswordError());
    }

    @After
    public void teardown() {
        driver.close();
    }
}
