package professionPageTest;

import ProfessionPages.EmployeeLoginHU;
import ProfessionPages.HomePageHU;
import base.BaseProfessionTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.FileUtils;
import utils.Hash;
import utils.Methods;
import utils.Popups;
import java.util.HashMap;

public class DropdownTestLogout extends BaseProfessionTests {

    // CONSTANSES
    private final String URL_HOME = "https://www.profession.hu";
    private final By HEADER_LOGIN_BUTTON = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[4]/a ");

    // PROPERTIES
    HashMap<String, String> user = new HashMap<String, String>();
    FileUtils utils = new FileUtils();

    // TESTS

    // Succesfull logout test
    // Requirements 02, 07, 11
    @Test
    @DisplayName("TCP03	Sikeres kijelentkezés - Logout  - @DisplayName")
    public void testLogout() throws InterruptedException{
        String userFile = "User2RegistredPassive.txt";
        user = utils.userData(userFile);
        String email = user.get("email");
        String password = Hash.revert(user.get("password"));

        HomePageHU homePage = new HomePageHU(driver);
        driver.navigate().to(URL_HOME);
        EmployeeLoginHU employeeLoginHU = homePage.clickEmpLoginButton(driver);
        Popups.popupClose(driver);

        employeeLoginHU.loginUser(email,password);
        System.out.println("User " + employeeLoginHU.getUserName() + " is signed in.");
        Popups.popupClose(driver);

        System.out.println(employeeLoginHU.logoutUser() + " has logged out.");

        Assertions.assertTrue(Methods.waitForElement(driver, HEADER_LOGIN_BUTTON).isDisplayed());
    }
}
