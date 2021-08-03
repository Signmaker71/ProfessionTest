package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Popups {
    public WebDriverWait wait;
    private WebDriver webDriver;

    public Popups(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By MODAL_DIALOG = By.id("modal-completed_cv");
    private final By MODAL_CLOSE = By.xpath("//*[@id=\"modal-completed_cv\"]/div");
    private final By COOKIE_ACCEPT = By.id("elfogad");

    public void popupClose() {
            wait = new WebDriverWait(webDriver, 10);

        /*if (webDriver.findElement(MODAL_DIALOG).isDisplayed()) {

            wait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_CLOSE));
            wait.until(ExpectedConditions.elementToBeClickable(MODAL_CLOSE)).click();
        }
            if (webDriver.findElement(COOKIE_ACCEPT).isDisplayed()) {*/
            wait.until(ExpectedConditions.visibilityOfElementLocated(COOKIE_ACCEPT));
            wait.until(ExpectedConditions.elementToBeClickable(COOKIE_ACCEPT)).click();
        //}

    }

    public String getUrl() {
        wait = new WebDriverWait(webDriver, 10);
        return webDriver.getCurrentUrl();
    }

}
