package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Q040HasRegistration {
    private WebDriver webDriver;
    public final By REGISTRED_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[1]");
    public final By NOT_REMEMBER_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[2]");
    public final By NOT_REGISTRED_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[2]");

    public Q040HasRegistration(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Q051Login clickHaveRegistrationButton() {
        webDriver.findElement(REGISTRED_BUTTON).click();
        return new Q051Login(webDriver);
    }
    public Q052DontRemember clickNotRememberButton() {
        webDriver.findElement(NOT_REMEMBER_BUTTON).click();
        return new Q052DontRemember(webDriver);
    }
    /*public Q053Registration clickNotRegistredButton() {
        webDriver.findElement(NOT_REGISTRED_BUTTON).click();
        return new Q053Registration(webDriver);
    }*/



}
