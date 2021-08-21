package professionPageTest;

import ProfessionPages.HomePageHU;
import base.BaseProfessionTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ProfessionPages.EmployeeLoginHU;
import utils.FileUtils;
import utils.Hash;
import utils.Popups;
import java.util.HashMap;

public class PLoginTests extends BaseProfessionTests {
    // CONSTANSES
    private final String URL_HOME = "https://www.profession.hu/";
    private final String EMAIL_FAIL_MESSAGE = "Sajnos a megadott email és jelszó kombinációval nem találtunk felhasználói fiókot.\n" +
            "Kérjük próbálja meg ismét vagy módosítsa a jelszavát.";

    // PROPERTIES
    HashMap<String, String> user = new HashMap<String, String>();
    FileUtils utils = new FileUtils();

    // TESTS

    // Testing successfull login
    // Requirements 02, 07
    @Test // OK
    @DisplayName("TCP01	Sikeres belépés regisztrált felhasználóként")
    public void testSuccessfulLogin() throws InterruptedException{
        String userFile = "User2RegistredPassive.txt";
        user = utils.userData(userFile);
        String email = user.get("email");
        String password = Hash.revert(user.get("password"));
        String username = user.get("username");

        HomePageHU homePage = new HomePageHU(driver);
        driver.navigate().to(URL_HOME);

        EmployeeLoginHU employeeLoginHU = homePage.clickEmpLoginButton(driver);
        Popups.popupClose(driver);

        employeeLoginHU.loginUser(email,password);

        Popups.popupClose(driver);
        Assertions.assertEquals(username, employeeLoginHU.getUserName());
        employeeLoginHU.logoutUser();
    }

    // Testing unsuccessfull login
    // Requirements 02, 07
    @Test //OK
    @DisplayName("TCP02	Sikertelen belépés hibás jelszóval")
    public void testLoginFailedDueToIncorrectPassword() {
        String userFile = "User2RegistredPassive.txt";
        user = utils.userData(userFile);
        String email = user.get("email");
        String password = "password";

        HomePageHU homePage = new HomePageHU(driver);
        driver.navigate().to(URL_HOME);

        EmployeeLoginHU employeeLoginHU = homePage.clickEmpLoginButton(driver);
        Popups.popupClose(driver);

        employeeLoginHU.setEmail(email);
        employeeLoginHU.setPassword(password);

        Popups.popupClose(driver);
        employeeLoginHU.clickLogin();

        String actualMessage = employeeLoginHU.getPasswordMessage();
        Assertions.assertEquals(EMAIL_FAIL_MESSAGE, actualMessage);
    }

}
