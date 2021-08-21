package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;

public class Q040HasRegistration {

    // CONSTANSES
    private final By REGISTRED_BUTTON = By.xpath("//*[contains(text(),'megyek')]");
    private final By NOT_REMEMBER_BUTTON = By.xpath("//*[contains(text(),'emlékszem')]");
    private final By NOT_REGISTRED_BUTTON = By.xpath("//*[contains(text(),'Nincs')]");

    // PROPERTIES
    private WebDriver driver;

    // CONSTRUCTOR
    public Q040HasRegistration(WebDriver driver) {
        this.driver = driver;
    }

    // METHODS
    public By getLocator (String haveRegistration) {
        By locator;
        switch (haveRegistration) {
            case "registred":
                locator = REGISTRED_BUTTON;
                break;
            case "not remember":
                locator = NOT_REMEMBER_BUTTON;
                break;
            case "not registred":
                locator = NOT_REGISTRED_BUTTON;
                break;

            default:
                locator = NOT_REGISTRED_BUTTON;
        }
        return locator;

    }

    public Q050LoginAndRegistration clickHaveRegistrationButton(String registred) {
        Methods.clickButton(driver,getLocator(registred));
        return new Q050LoginAndRegistration(driver);
    }


}
