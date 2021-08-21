package professionPageTest;

import ProfessionPages.CV_Page;
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

public class CV_PageTest extends BaseProfessionTests {
    // CONSTANSES
    private final String URL_HOME = "https://www.profession.hu/";
    private final String EMPTY_PHONE_FIELD_PLACEHOLDER = "nem megadott";
    // PROPERTIES
    HashMap<String, String> user = new HashMap<String, String>();
    FileUtils utils = new FileUtils();
    CV_Page cv_page;

    // TESTS
    // add new phone number from txt data file
    // Requirements 02, 06, 07, 08, 09,
    @Test // OK
    @DisplayName("TCP07	Telefonszám módosítása az önéletrajzi adatokban")

    public void testSuccessfulLogin() {
        String userFile = "User2RegistredPassive.txt";
        user = utils.userData(userFile);
        String email = user.get("email");
        String password = Hash.revert(user.get("password"));
        String phoneNumber = user.get("phone");
        String phoneNumberOnPI_Card = "";
        cv_page = new CV_Page(driver);
        HomePageHU homePage = new HomePageHU(driver);

        driver.navigate().to(URL_HOME);
        EmployeeLoginHU employeeLoginHU = homePage.clickEmpLoginButton(driver);

        Popups.popupClose(driver);

        // user login
        employeeLoginHU.loginUser(email, password);
        Popups.popupClose(driver);

        CV_Page cv_page = homePage.getCV_Page();

        // clear phone number if exists
        Popups.popupClose(driver);
        cv_page.clearCardsPhoneNumber();

        // testing input field
        cv_page.setCardsPhoneNumber(phoneNumber);
        phoneNumberOnPI_Card = cv_page.getCardsPhoneNumber();
        System.out.println("The Phonenumber has changed to:   " + phoneNumberOnPI_Card);

        String expectedPhoneNumber = cv_page.formattedPhoneNumber(phoneNumber);
        System.out.println("Expected: " + expectedPhoneNumber + "  (originally: " + phoneNumber + " )");

        System.out.println("Phone field now contains:" + phoneNumberOnPI_Card);
        Assertions.assertEquals(expectedPhoneNumber, phoneNumberOnPI_Card);

        // clear phone number again
        Popups.popupClose(driver);
        cv_page.clearCardsPhoneNumber();
        // User logout
        employeeLoginHU.logoutUser();
    }


    // add several new phone numbers
    // Requirements 02, 07
    @Test // OK
    @DisplayName("TCP08	Telefonszám formátumok elfogadásának ellenőrzése sorozatos adatmódosítással")

    public void testPhoneNumberFormats(){
        String userFile = "User1RegistredActive.txt";
        user = utils.userData(userFile);
        String email = user.get("email");
        String password = Hash.revert(user.get("password"));
        String[] phoneNumber = utils.getFileToStringArray("phoneNumbers.txt");
        String[] expectedPhoneNumber = utils.getFileToStringArray("expectedPhoneNumbers.txt");

        String phoneNumberOnPI_Card = "";
        cv_page = new CV_Page(driver);

        HomePageHU homePage = new HomePageHU(driver);

        driver.navigate().to(URL_HOME);
        EmployeeLoginHU employeeLoginHU = homePage.clickEmpLoginButton(driver);

        Popups.popupClose(driver);

        // user login
        employeeLoginHU.loginUser(email, password);
        Popups.popupClose(driver);

        CV_Page cv_page = homePage.getCV_Page();

        // clear phone number if exists
        Popups.popupClose(driver);
        cv_page.clearCardsPhoneNumber();

        // testing input field by several data from file
        for (int i = 0; i < phoneNumber.length; i++) {
            cv_page.setCardsPhoneNumber(phoneNumber[i]);
            phoneNumberOnPI_Card = cv_page.getCardsPhoneNumber();
            cv_page.printActionDetails("Expected: " + expectedPhoneNumber[i] + "  (originally: " + phoneNumber[i] + " )", phoneNumberOnPI_Card);

            Assertions.assertEquals(expectedPhoneNumber[i], phoneNumberOnPI_Card);
        }
        // clear phone number again
        Popups.popupClose(driver);
        cv_page.clearCardsPhoneNumber();
        // User logout
        employeeLoginHU.logoutUser();
    }


}
