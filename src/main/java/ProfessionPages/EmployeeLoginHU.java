package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;
import utils.Popups;


public class EmployeeLoginHU extends PageHeaderMenuHU {
    private WebDriver driver;
    private final By LOGIN_EMAIL_FIELD = By.id("login_e_mail");
    private final By LOGIN_PASSWORD_FIELD = By.id("login_passwd");
    private final By HEADER_LOGIN_BUTTON = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[4]/a ");
    private final By LOGIN_BUTTON = By.xpath("//*[@id=\"content\"]/div/form/div[2]/div[1]/input");
    private final By USER_NAME = By.xpath("//*[@id=\"employeeMenuDropdownTrigger\"]/span");
    private final By LOGOUT_BUTTON = By.id("employee_menu_dropdown_12");
    private final By PASSWORD_ERROR_MESSAGE = By.xpath("//*[@id=\"content\"]/div/form/div[1]/div[2]/ul/li");


    public EmployeeLoginHU(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        Methods.waitForElement(driver, LOGIN_EMAIL_FIELD).sendKeys(email);
    }

    public void setPassword(String password) {
        Methods.waitForElement(driver, LOGIN_PASSWORD_FIELD).sendKeys(password);
    }

    public LoggedInHomePageHU clickHeaderLogInButton() {
        Methods.waitForElementClickable(driver, HEADER_LOGIN_BUTTON).click();
        return new LoggedInHomePageHU(driver);
    }

    public LoggedInHomePageHU loginUser(String email, String password) {
        boolean loginIsEnable;
        try {
            clickHeaderLogInButton();
            loginIsEnable = true;
        } catch (Exception e) {
            loginIsEnable = false;
        }
        if (loginIsEnable) {
            Popups.popupClose(driver);
            setEmail(email);
            setPassword(password);
            clickLogin();
        }
        return new LoggedInHomePageHU(driver);
    }

    public void clickLogin() {
        Methods.waitForElementClickable(driver, LOGIN_BUTTON).click();
    }


    private void clickLogoutButton() {
        try {
            Methods.waitForElementClickable(driver, USER_NAME).click();
            Methods.waitForElementClickable(driver, LOGOUT_BUTTON).click();
            Methods.waitForElementDisappear(driver, USER_NAME);
            Methods.waitForElementClickable(driver, HEADER_LOGIN_BUTTON);
        } catch (Exception ignore) {
        }

    }

    public String logoutUser() {
        driver.navigate().to("https://www.profession.hu");
        Popups.popupClose(driver);
        String name = getUserName();
        clickLogoutButton();
        return name;
    }

    public String getUserName() {
        return Methods.waitForElement(driver, USER_NAME).getText();
    }
public String getPasswordMessage() {
        return Methods.waitForElement(driver, PASSWORD_ERROR_MESSAGE).getText();
    }

}
