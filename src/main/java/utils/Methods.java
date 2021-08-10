package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public Methods(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickCheckbox(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public static void clickLink(WebDriver driver, By link) {
        wait = new WebDriverWait(Methods.driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        wait.until(ExpectedConditions.elementToBeClickable(link));
        driver.findElement(link).click();
    }

    public static void clickCheckbox(WebDriver driver, By link) {
        wait = new WebDriverWait(Methods.driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        wait.until(ExpectedConditions.elementToBeClickable(link));
        driver.findElement(link).click();
    }

    public static boolean checkCheckbox(WebDriver driver, By link) {
        wait = new WebDriverWait(Methods.driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        wait.until(ExpectedConditions.elementToBeClickable(link));
        return driver.findElement(link).isSelected();
    }


    public static void clickButton(WebDriver driver, By button) {
        wait = new WebDriverWait(Methods.driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(button));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        driver.findElement(button).click();
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(button));
        } catch (Exception ignored) {
        }
    }

    public static void fillTextToField(WebDriver driver, By field, String text) {
        wait = new WebDriverWait(Methods.driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(field));
        driver.findElement(field).sendKeys(text);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(field));
        } catch (Exception ignored) {
        }
    }

    public static boolean waitFor(WebDriver driver, By value) {
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(value));
        wait.until(ExpectedConditions.elementToBeClickable(value));
        return driver.findElement(value).isDisplayed();
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
}
