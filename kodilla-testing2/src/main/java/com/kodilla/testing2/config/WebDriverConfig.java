package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
    public static final String CHROME = "CHROME_DRIVER";
    public static final String FIREFOX = "FIREFOX_DRIVER";

    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.chrome.driver", "/opt/Selenium-drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/opt/Selenium-drivers/geckodriver");
        if (driver.equals(CHROME)) {
            return new ChromeDriver();
        }
        return new FirefoxDriver();
    }
}
