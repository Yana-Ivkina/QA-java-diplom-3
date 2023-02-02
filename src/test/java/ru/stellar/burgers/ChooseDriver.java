package ru.stellar.burgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChooseDriver {
    private String url;

    protected WebDriver getDriver(BrowserName browserName) {
        switch (browserName) {
            case Google:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case Yandex:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                return new ChromeDriver(options);
            default:
                return null;
        }
    }
}
