package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

public class Methods {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public Methods(WebDriver driver) {

        this.driver = driver;
    }

    public static void clickCheckbox(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public static void clickCheckbox(WebDriver driver, By link) {
        waitForElementClickable(driver, link).click();
    }

    public static void clickLink(WebDriver driver, By link) {
        waitForElementClickable(driver, link).click();
    }

    public static void clickButton(WebDriver driver, By button) {
        waitForElementClickable(driver, button).click();
        try {
            waitForElementDisappear(driver, button);
        } catch (Exception ignored) {
        }
    }

    public static void fillTextToField(WebDriver driver, By field, String text) {
        waitForElementFillable(driver, field).sendKeys(text);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(field));
        } catch (Exception ignored) {
        }
    }

    public static WebElement waitForElementFillable(WebDriver driver, By value) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        return driver.findElement(value);
    }
public static WebElement waitForElement(WebDriver driver, By value) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        return driver.findElement(value);
    }

    public static WebElement waitForElementClickable(WebDriver driver, By value) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        wait.until(ExpectedConditions.elementToBeClickable(value));
        return driver.findElement(value);
    }

    public static WebElement waitForElementDisappear(WebDriver driver, By value) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(value));
        return driver.findElement(value);
    }

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

    public static void acceptAlert(WebDriver driver) {
        try {
            wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();

        } catch (Exception ignore) {
        }
    }

    public static void dismissAlert(WebDriver driver) {
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Step("TakeScreenshot")
    public static void takeScreenshot(WebDriver driver) {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }
}
