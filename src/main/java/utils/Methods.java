package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class Methods {

    // PROPERTIES
    private static WebDriver driver;
    private static WebDriverWait wait;

    // CONSTRUCTOR
    public Methods(WebDriver driver) {
        this.driver = driver;
    }


    // METHODS

    // generate a 5 character long random string
    // it can be use to the e-mail address variations
    public static String generateRandomString() {
        UUID uuid = UUID.randomUUID();

        return uuid.toString().substring(19, 23);
    }

    // increments a 4 digit numeric string
    // it can be use to the e-mail address variations
    private static String incrementNumericString(String originalNumber) {
        int num = Integer.parseInt(originalNumber);
        num++;
        return String.format("%04d", num);
    }



    // click checkbox by linktext
    public static void clickCheckbox(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    // click checkbox by object path
    public static void clickCheckbox(WebDriver driver, By link) {
        waitForElementClickable(driver, link).click();
    }

    // click link by object path
    public static void clickLink(WebDriver driver, By link) {
        waitForElementClickable(driver, link).click();
    }

    // click button by object path
    public static void clickButton(WebDriver driver, By button) {
        waitForElementClickable(driver, button).click();
        try {
            waitForElementDisappear(driver, button);
        } catch (Exception ignored) {
        }
    }

    // fill a field
    public static void fillTextToField(WebDriver driver, By field, String text) {
        waitForElement(driver, field).clear();
        waitForElement(driver, field).sendKeys(text);
    }

    // wait and get back an element
    public static WebElement waitForElement(WebDriver driver, By value) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        return driver.findElement(value);
    }

    // wait and get back an element  clickable
    public static WebElement waitForElementClickable(WebDriver driver, By value) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        wait.until(ExpectedConditions.elementToBeClickable(value));
        return driver.findElement(value);
    }

    // wait for an element is disappear
    public static WebElement waitForElementDisappear(WebDriver driver, By value) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(value));
        return driver.findElement(value);
    }


    // scroll down to an exact step
    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 5000)");
    }

    // gives back an alert box's text
    public static String getAlertText(WebDriver driver) {
        String message;
        try {
            wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            message = alert.getText();
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    // accepting an alert box
    public static void acceptAlert(WebDriver driver) {
        try {
            wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception ignore) {
        }
    }

    // dismiss an alert box
    public static void dismissAlert(WebDriver driver) {
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    // take a screenshot in Allure report
    @Step("TakeScreenshot")
    public static void TakeScreenshot(WebDriver driver) {
        try {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            System.out.println(driver.getCurrentUrl());
        } catch (Exception e) {
        }
    }

}
