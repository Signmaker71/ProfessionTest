package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ProfessionPages.EmployeeLoginHU;
import ProfessionPages.LoggedInHomePageHU;
import utils.Hash;


public class PLoginTests extends BaseTests{

    private EmployeeLoginHU employeeLoginHU;
    private LoggedInHomePageHU loggedInHomePageHU;
    private By cookieAccept = By.id("elfogad");
    private By allasErtesitoDenied = By.xpath("//*[@id=\"jqi_state_state0\"]/div[1]/div[2]/span[2]/a");
    private By emailFailMessage = By.xpath("//*[@id=\"content\"]/div/form/div[1]/div[2]/ul/li/text()[1]");

    @Test
    public void testSuccessfulLogin() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAccept));
            wait.until(ExpectedConditions.elementToBeClickable(cookieAccept)).click();
            //homePage.popupClose();
        } catch (Exception e){};

        //wait.until(ExpectedConditions.elementToBeClickable(homePage.MVBelepesLink));
        employeeLoginHU = homePage.clickMVBelepesLink();
        employeeLoginHU.setEmail(Hash.revert(userData.get("email")));
        employeeLoginHU.setPassword(Hash.revert(userData.get("password")));
        loggedInHomePageHU = employeeLoginHU.clickLogInButton();
        //Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(allasErtesitoDenied));
        wait.until(ExpectedConditions.elementToBeClickable(allasErtesitoDenied)).click();

        //Assertions.assertEquals("Teszter Retesz", loggedInHomePage.getEmployeeMenuDropdownTrigger(), "Error 01");
        Assertions.assertTrue( webDriver.getPageSource().contains("Teszter Retesz"),"Error 02");
    }

    @Test
    public void testLoginWithInvalidEmailaddress() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAccept));
            wait.until(ExpectedConditions.elementToBeClickable(cookieAccept)).click();
            //homePage.popupClose();
        } catch (Exception e){};

        //wait.until(ExpectedConditions.elementToBeClickable(homePage.MVBelepesLink));
        employeeLoginHU = homePage.clickMVBelepesLink();
        employeeLoginHU.setEmail("ezegynemletezo@emailcim.com");
        employeeLoginHU.setPassword(Hash.revert(userData.get("password")));
        loggedInHomePageHU = employeeLoginHU.clickLogInButton();
        //Thread.sleep(5000);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAccept));
            wait.until(ExpectedConditions.elementToBeClickable(cookieAccept)).click();
            //homePage.popupClose();
        } catch (Exception e){};
        //Assertions.assertEquals("Teszter Retesz", loggedInHomePage.getEmployeeMenuDropdownTrigger(), "Error 01");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFailMessage));
        Assertions.assertTrue( webDriver.getPageSource().contains("Sajnos a megadott email és jelszó kombinációval"),"Error 02");
    }
}
