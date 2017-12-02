package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://pimisiak.github.io";
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Random generator;
    private Properties testProperties;

    @Before
    public void initTests() throws IOException {
        webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(BASE_URL);
        webDriverWait = new WebDriverWait(webDriver, 30);
        generator = new Random();
        testProperties = new Properties();
        testProperties.load(this.getClass().getClassLoader().getResourceAsStream("testconfig.properties"));
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        //Given
        final String taskName = createCrudAppTestTask();
        //When
        sendTestTaskToTrello(taskName);
        //Then
        assertTrue(checkTaskExistsInTrello(taskName));
        //Clean up
        removeCrudAppTestTask(taskName);
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@class, \"datatable__row--add\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@class, \"datatable__row--add\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@class, \"datatable__row--add\")]/fieldset[3]/button";
        final String taskName = "Task number " + generator.nextInt(100000);
        final String taskContent = taskName + " content";
        final WebElement name = webDriver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);
        final WebElement content = webDriver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);
        final WebElement addButton = webDriver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);
        return taskName;
    }

    private void sendTestTaskToTrello(final String taskName) throws InterruptedException {
        webDriver.navigate().refresh();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[1]")));
        webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(form -> form.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(form -> {
                    final WebElement selectElement = form.findElement(By.xpath(".//select[1]"));
                    final Select select = new Select(selectElement);
                    select.selectByIndex(1);
                    final WebElement buttonCreateCard = form.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        final Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }

    private boolean checkTaskExistsInTrello(final String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        final WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);
        driverTrello.findElement(By.id("user")).sendKeys(testProperties.getProperty("trello.user"));
        driverTrello.findElement(By.id("password")).sendKeys(testProperties.getProperty("trello.pass"));
        driverTrello.findElement(By.id("login")).submit();
        Thread.sleep(2000);
        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);
        Thread.sleep(2000);
        final boolean result = driverTrello.findElements(By.xpath("//span[contains(@class, \"list-card-title\")]")).stream()
                .filter(span -> span.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;
        driverTrello.close();
        return result;
    }

    private void removeCrudAppTestTask(final String taskName) throws InterruptedException {
        webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(form -> form.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(form -> form.findElement(By.xpath(".//fieldset[contains(@class, \"button-section\")]/button[4]")).click());
        Thread.sleep(2000);
    }

    @After
    public void cleanUpAfterTests() {
        webDriver.close();
    }
}