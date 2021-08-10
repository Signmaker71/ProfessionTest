package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EmployeeLoginHU {
    private WebDriver driver;
    private final By userEmailField = By.id("login_e_mail");
    private final By passwordField = By.id("login_passwd");
    private final By loginButton = By.xpath("//*[@id=\"content\"]/div/form/div[2]/div[1]/input");

    public EmployeeLoginHU(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String userName) {
        driver.findElement(userEmailField).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public LoggedInHomePageHU clickLogInButton() {
        driver.findElement(loginButton).click();
        return new LoggedInHomePageHU(driver);
    }

}
