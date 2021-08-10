package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ProfessionPages.LoggedInHomePageHU;
import ProfessionPages.EmployeeSigninHU;
import utils.Hash;

public class SignInTest extends BaseTests {

    private EmployeeSigninHU employeeSigninHU;
    private LoggedInHomePageHU loggedInHomePageHU;
    private By cookieAccept = By.id("elfogad");
    private By allasErtesitoDenied = By.xpath("//*[@id=\"jqi_state_state0\"]/div[1]/div[2]/span[2]/a");
    private By emailFailMessage = By.xpath("//*[@id=\"content\"]/div/form/div[1]/div[2]/ul/li/text()[1]");

    @Test
    public void testSuccessfulSignin() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAccept));
            wait.until(ExpectedConditions.elementToBeClickable(cookieAccept)).click();
            //homePage.popupClose();
        } catch (Exception e){};

        //wait.until(ExpectedConditions.elementToBeClickable(homePage.MVBelepesLink));
        employeeSigninHU = homePage.clickMVRegisztracioLink();
        Thread.sleep(400);
        employeeSigninHU.setEmail(Hash.revert(userData.get("email")));
        Thread.sleep(340);
        employeeSigninHU.setPassword(Hash.revert(userData.get("password")));
        Thread.sleep(430);
        employeeSigninHU.setName(userData.get("name"));
        Thread.sleep(230);
        employeeSigninHU.setCity(userData.get("city"));
        Thread.sleep(256);
        employeeSigninHU.selectWorkingStatus(userData.get("workingStatus"));
        Thread.sleep(760);

        loggedInHomePageHU = employeeSigninHU.clickLogInButton();
        //Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(allasErtesitoDenied));
        wait.until(ExpectedConditions.elementToBeClickable(allasErtesitoDenied)).click();

        //Assertions.assertEquals("Teszter Retesz", loggedInHomePage.getEmployeeMenuDropdownTrigger(), "Error 01");
        Assertions.assertTrue( driver.getPageSource().contains("Teszter Retesz"),"Error 02");
    }

    @Test
    public void testSigninWithIncorrectEmail() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAccept));
            wait.until(ExpectedConditions.elementToBeClickable(cookieAccept)).click();
            //homePage.popupClose();
        } catch (Exception e){};

        //wait.until(ExpectedConditions.elementToBeClickable(homePage.MVBelepesLink));
        employeeSigninHU = homePage.clickMVRegisztracioLink();
        Thread.sleep(400);
        employeeSigninHU.setEmail(("sddfrz@fff.ccc"));
        Thread.sleep(340);
        employeeSigninHU.setPassword(Hash.revert(userData.get("password")));
        Thread.sleep(430);
        employeeSigninHU.setName(userData.get("name"));
        Thread.sleep(230);
        employeeSigninHU.setCity(userData.get("city"));
        Thread.sleep(256);
        employeeSigninHU.selectWorkingStatus(userData.get("workingStatus"));
        Thread.sleep(760);

        loggedInHomePageHU = employeeSigninHU.clickLogInButton();
        //Thread.sleep(5000);
        //if (ExpectedConditions.presenceOfElementLocated(allasErtesitoDenied)){
            wait.until(ExpectedConditions.visibilityOfElementLocated(allasErtesitoDenied));
            wait.until(ExpectedConditions.elementToBeClickable(allasErtesitoDenied)).click();
        //}

        //Assertions.assertEquals("Teszter Retesz", loggedInHomePage.getEmployeeMenuDropdownTrigger(), "Error 01");
        Assertions.assertTrue( driver.getPageSource().contains("Teszter Retesz"),"Error 02");
    }


}
