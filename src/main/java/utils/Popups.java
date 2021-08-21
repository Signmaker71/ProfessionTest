package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Popups {

    // CONSTANSES
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

    // PROPERTIES
    public static WebDriverWait wait;
    private static WebDriver driver;

    // CONSTRUCTOR
    public Popups(WebDriver driver) {
        this.driver = driver;
    }

    // METHODS

    public static void popupClose(WebDriver driver) {
        boolean isPopupPresence;

        for (String popupSelector : popupCollection) {
            try {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
                isPopupPresence = driver.findElement(By.cssSelector(popupSelector)).isDisplayed();
                if (isPopupPresence) {
                    Methods.waitForElementClickable(driver, By.cssSelector(popupSelector)).click();
                    Methods.waitForElementDisappear(driver, By.cssSelector(popupSelector));
                }
            } catch (Exception ignored) {
            }
        }
    }
}
