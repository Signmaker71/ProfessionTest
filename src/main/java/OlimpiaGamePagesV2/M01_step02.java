package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class M01_step02 {

    public final By LASTNAME = By.xpath("//*[@id=\"player-lastname\"]");
    public final By FIRSTNAME = By.id("player-firstname");
    public final By STEP_02_SUBMIT_BUTTON = By.id("step-02-submit");

    WebDriver driver;

    public M01_step02(WebDriver driver) {
        this.driver = driver;
    }

    public String getName(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FIRSTNAME));
        String fullName = "";
        String lastName = "";
        String firstName = "";
        lastName = driver.findElement(LASTNAME).getAttribute("value");
        firstName = driver.findElement(FIRSTNAME).getAttribute("value");
        fullName =  lastName + " " + firstName;
        return fullName;
    }

    public String getUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }


}
