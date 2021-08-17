package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;

public class Q040HasRegistration {

    private WebDriver driver;

    private final By REGISTRED_BUTTON = By.xpath("//*[contains(text(),'megyek')]");
    private final By NOT_REMEMBER_BUTTON = By.xpath("//*[contains(text(),'emlékszem')]");
    private final By NOT_REGISTRED_BUTTON = By.xpath("//*[contains(text(),'Nincs')]");

    public Q040HasRegistration(WebDriver driver) {
        this.driver = driver;
    }



    public Q051Login clickHaveRegistrationButton() {
        Methods.clickButton(driver,REGISTRED_BUTTON);
        return new Q051Login(driver);
    }
    public Q052DontRemember clickNotRememberButton() {
        Methods.clickButton(driver,NOT_REMEMBER_BUTTON);
        return new Q052DontRemember(driver);
    }

    /*public Q053Registration clickNotRegistredButton() {
        webDriver.findElement(NOT_REGISTRED_BUTTON).click();
        return new Q053Registration(webDriver);
    }*/

}
