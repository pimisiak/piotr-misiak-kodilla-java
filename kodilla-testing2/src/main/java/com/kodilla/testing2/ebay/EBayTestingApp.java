package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static final String SEARCHINPUT = "gh-ac";

    public static void main(final String[] args) {
        final WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.ebay.com");
        final WebElement searchElement = webDriver.findElement(By.id(SEARCHINPUT));
        searchElement.sendKeys("laptop");
        searchElement.submit();
    }
}
