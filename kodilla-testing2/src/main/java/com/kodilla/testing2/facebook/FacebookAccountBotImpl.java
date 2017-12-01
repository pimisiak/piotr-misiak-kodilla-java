package com.kodilla.testing2.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookAccountBotImpl implements FacebookAccountBot {
    private static final String FACEBOOK_URL = "https://www.facebook.com";
    private static final String XPATH_FIRSTNAME = "//input[@id=\"u_0_9\"]";
    private static final String XPATH_LASTNAME = "//input[@id=\"u_0_b\"]";
    private static final String XPATH_MOBILE = "//input[@id=\"u_0_e\"]";
    private static final String XPATH_PASSWORD =  "//input[@id=\"u_0_l\"]";
    private static final String XPATH_MONTH = "//select[@id=\"month\"]";
    private static final String XPATH_DAY = "//select[@id=\"day\"]";
    private static final String XPATH_YEAR = "//select[@id=\"year\"]";
    private static final String XPATH_GENDER_FEMALE = "//span[contains(@data-name, \"gender_wrapper\")]/span[1]/input";
    private static final String XPATH_GENDER_MALE = "//span[contains(@data-name, \"gender_wrapper\")]/span[2]/input";
    private static final String XPATH_CREATE_ACCOUNT = "//button[@id=\"u_0_r\"]";
    private WebDriver webDriver;

    public FacebookAccountBotImpl(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void createAccount(final FacebookUser facebookUser) {
        startBot();
        setAccountCredentials(facebookUser);
       // confirmCredentials();
       // stopBot();
    }

    private void setAccountCredentials(final FacebookUser facebookUser) {
        setFullName(facebookUser);
        setMobile(facebookUser);
        setPassword(facebookUser);
        setGender(facebookUser);
        setBirthDay(facebookUser);
    }

    private void setFullName(final FacebookUser facebookUser) {
        final WebElement firstNameElement = webDriver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstNameElement.sendKeys(facebookUser.getFirstName());
        final WebElement lastNameElement = webDriver.findElement(By.xpath(XPATH_LASTNAME));
        lastNameElement.sendKeys(facebookUser.getLastName());
    }

    private void setMobile(final FacebookUser facebookUser) {
        final WebElement mobileElement = webDriver.findElement(By.xpath(XPATH_MOBILE));
        mobileElement.sendKeys(facebookUser.getMobile());
    }

    private void setPassword(final FacebookUser facebookUser) {
        final WebElement passwordElement = webDriver.findElement(By.xpath(XPATH_PASSWORD));
        passwordElement.sendKeys(facebookUser.getPassword());
    }

    private void setGender(final FacebookUser facebookUser) {
        if (facebookUser.getGender().equals(Gender.FEMALE)) {
            webDriver.findElement(By.xpath(XPATH_GENDER_FEMALE)).click();
        } else {
            webDriver.findElement(By.xpath(XPATH_GENDER_MALE)).click();
        }
    }

    private void setBirthDay(final FacebookUser facebookUser) {
        setDatePart(XPATH_MONTH, facebookUser.getBirthday().getMonthValue());
        setDatePart(XPATH_DAY, facebookUser.getBirthday().getDayOfMonth());
        setDatePart(XPATH_YEAR, facebookUser.getBirthday().getYear());
    }

    private void setDatePart(final String xpathOfDatepart, final int datepart) {
        final WebElement webElement = webDriver.findElement(By.xpath(xpathOfDatepart));
        final Select webSelect = new Select(webElement);
        webSelect.selectByValue(String.valueOf(datepart));
    }

    private void confirmCredentials() {
        webDriver.findElement(By.xpath(XPATH_CREATE_ACCOUNT)).click();
    }

    private void startBot() {
        webDriver.get(FACEBOOK_URL);
    }

    private void stopBot() {
        webDriver.close();
    }
}
