package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Popups {
    public static WebDriverWait wait;
    private static WebDriver driver;

    public Popups(WebDriver driver) {
        this.driver = driver;
    }

    private final By MODAL_DIALOG = By.id("modal-completed_cv");
    private final By MODAL_CLOSE = By.xpath("//*[@id=\"modal-completed_cv\"]/div");
    private final By COOKIE_ACCEPT = By.id("elfogad");
    protected static String[] popupCollection = {
            "#elfogad",
            "#accept-cookie-terms",
            "#jqi > div > div.jqiclose",
            "body > div.terms-popup-wrapper.js-terms-popup-wrapper > div.terms-popup > div.terms-popup__header > i",
            ".LPMcloseButton",
            "#systemMessage3:not([style]) > a",
            "#systemMessage5:not([style]) > a",
            "#close_newsletter_footer",
    };

    public void alertClose() {
        //webDriver.manage().window().fullscreen();
        driver.switchTo().alert().accept();
        //webDriver.switchTo().parentFrame();
        /*try {
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }*/
    }

    public static void popupClose(WebDriver driver) {
        //wait = new WebDriverWait(driver, 0);
        boolean isPopupPresence;

        for (String popupSelector : popupCollection) {
            try {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
                isPopupPresence = driver.findElement(By.cssSelector(popupSelector)).isDisplayed();
                if (isPopupPresence) {
                    Methods.waitForElementClickable(driver,By.cssSelector(popupSelector)).click();
                    Methods.waitForElementDisappear(driver,By.cssSelector(popupSelector));
                    /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(popupSelector)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(popupSelector))).click();
                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(popupSelector)));
             */   }
            } catch (Exception ignored) {
            }

        }

    }

    public String getUrl() {
        wait = new WebDriverWait(driver, 10);
        return driver.getCurrentUrl();
    }

}
