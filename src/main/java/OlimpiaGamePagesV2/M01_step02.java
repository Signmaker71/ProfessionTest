package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Methods;

public class M01_step02 {

    // CONSTANSES
    public final By LASTNAME = By.xpath("//*[@id=\"player-lastname\"]");
    public final By FIRSTNAME = By.id("player-firstname");
    public final By STEP_02_SUBMIT_BUTTON = By.id("step-02-submit");

    // PROPERTIES
    WebDriver driver;

    // CONSTRUCTOR
    public M01_step02(WebDriver driver) {
        this.driver = driver;
    }

    // METHODS
    public void setName(String name){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FIRSTNAME));

        String[] fullName = name.split(" ");
        String lastName = fullName[0] + " " + fullName[1];
        String firstName = fullName[2];
        driver.findElement(LASTNAME).sendKeys(lastName);
        driver.findElement(FIRSTNAME).sendKeys(firstName);
    }

    public String getName(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FIRSTNAME));
        String lastName = driver.findElement(LASTNAME).getAttribute("value");
        String firstName = driver.findElement(FIRSTNAME).getAttribute("value");
        String fullName = lastName + " " + firstName;
        return fullName;
    }

    public M01_step03 clickNext() {
        Methods.clickButton(driver, STEP_02_SUBMIT_BUTTON);
        return new M01_step03(driver);
    }

    public String getUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }
}
