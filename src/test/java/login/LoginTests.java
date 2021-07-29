package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MVBelepes;
import pages.LoggedInHomePage;

import java.util.HashMap;


public class LoginTests extends BaseTests{

    private MVBelepes mvBelepes;
    private LoggedInHomePage loggedInHomePage;
    private By cookieAccept = By.id("elfogad");
    private By allasErtesitoDenied = By.xpath("//*[@id=\"jqi_state_state0\"]/div[1]/div[2]/span[2]/a");

    @Test
    public void testSuccessfulLogin() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAccept));
            wait.until(ExpectedConditions.elementToBeClickable(cookieAccept)).click();
            //homePage.popupClose();
        } catch (Exception e){};

        //wait.until(ExpectedConditions.elementToBeClickable(homePage.MVBelepesLink));
        mvBelepes = homePage.clickMVBelepesLink();
        mvBelepes.setEmail(userData.get("email"));
        mvBelepes.setPassword(userData.get("password"));
        loggedInHomePage = mvBelepes.clickLogInButton();
        //Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(allasErtesitoDenied));
        wait.until(ExpectedConditions.elementToBeClickable(allasErtesitoDenied)).click();

        //Assertions.assertEquals("Teszter Retesz", loggedInHomePage.getEmployeeMenuDropdownTrigger(), "Error 01");
        Assertions.assertTrue( webDriver.getPageSource().contains("Teszter Retesz"),"Error 02");
    }
}
