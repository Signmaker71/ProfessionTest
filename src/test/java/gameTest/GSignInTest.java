package gameTest;

import OlimpiaGamePagesV2.*;
import base.BaseTests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import utils.FileUtils;
import utils.Methods;
import utils.Popups;
import utils.Hash;

import java.util.HashMap;


public class GSignInTest extends BaseTests {
    final String URL_GAME = "https://www.professionjatekok.hu/v2/main";
    final String URL_TEST_DEV = "https://test.dev.profession.hu/";
    final String URL_PROF = "https://profession.hu/";

    private Q010ChoosePrice choosePrice;
    FileUtils utils = new FileUtils();
    HashMap<String, String> user = new HashMap<String, String>();


    //
    @Test // OK
    @DisplayName("TCG01	Regisztrációnál az Felhasználási Feltételek dokumentum elérhető")
    public void testEnsureToPrivacyPolicyIsEnable() {
        choosePrice = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);
        user = utils.userData("user2.txt");

        choosePrice.choosePrice(user.get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("workingStatus"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Popups.popupClose(driver);
        Q050LoginAndRegistration login = hasRegistration.clickHaveRegistrationButton("not registred");
        login.clickButton("termOfUse");

        String actualURL = login.getPrivacyPolicyLink();
        String expectedURL = "https://www.profession.hu/docs/upload/felhasznalasifeltetelek_20201008.pdf";
        Assertions.assertEquals(actualURL, expectedURL);
    }

    @Test // OK
    @DisplayName("TCG02	Sikertelen regisztráció Felhasználási Feltételek elfogadás hiánya miatt")
    public void testUnableToRegistringByMissingRSExpectation() {
        choosePrice = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);
        user = utils.userData("user1.txt");

        choosePrice.choosePrice(user.get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("workingStatus"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Popups.popupClose(driver);
        Q050LoginAndRegistration login = hasRegistration.clickHaveRegistrationButton("not registred");
        //login.clickCheckbox("RrsCheckbox");
        login.clickCheckbox("RssCheckbox");
        login.fill("Remail", user.get("email"));
        login.clickButton("Rnext");

        String actualMessage = login.getAlertBoxText();
        String expectedMessage = "Kérjük minden kötelező mezőt adjon meg!";
        login.acceptAlertBox();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test // OK
    @DisplayName("TCG03	Sikertelen regisztráció Játékstabályzat elfogadás hiánya miatt")
    public void testUnableToRegistringByMissingSSxpectation() {
        choosePrice = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);
        user = utils.userData("user1.txt");

        choosePrice.choosePrice(user.get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("workingStatus"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Popups.popupClose(driver);
        Q050LoginAndRegistration login = hasRegistration.clickHaveRegistrationButton("not registred");
        login.clickCheckbox("RrsCheckbox");
        //login.clickCheckbox("RssCheckbox");
        login.fill("Remail", user.get("email"));
        login.clickButton("Rnext");

        String actualMessage = login.getAlertBoxText();
        String expectedMessage = "Kérjük minden kötelező mezőt adjon meg!";

        Assertions.assertEquals(actualMessage, expectedMessage);
    }


    @Test // OK - Helyesen FAIL a teszt, angol nyelvű alert szöveg miatt
    @DisplayName("TCG04	Sikertelen regisztráció hibás e-mail cím miatt")
    public void testUnableToRegistringByWrongEmail() {
        choosePrice = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);
        user = utils.userData("user1.txt");

        choosePrice.choosePrice(user.get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("workingStatus"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Popups.popupClose(driver);
        Q050LoginAndRegistration login = hasRegistration.clickHaveRegistrationButton("not registred");
        login.clickCheckbox("RrsCheckbox");
        login.clickCheckbox("RssCheckbox");
        login.fill("Remail", "email");
        login.clickButton("Rnext");

        String actualMessage = login.getAlertBoxText();
        login.acceptAlertBox();
        String expectedMessage = "Hibás formátumú e-mail cím lett megadva. Helyes formátum: nev@pelda.com.";

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @Test // OK
    @DisplayName("TCG05	Sikertelen regisztráció hibás jelszó páros miatt")
    public void testUnableToRegistringByWrongPassword() {
        choosePrice = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);
        user = utils.userData("user1.txt");

        choosePrice.choosePrice(user.get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("workingStatus"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Popups.popupClose(driver);
        Q050LoginAndRegistration login = hasRegistration.clickHaveRegistrationButton("not registred");
        login.clickCheckbox("RrsCheckbox");
        login.clickCheckbox("RssCheckbox");
        login.fill("Remail", user.get("email"));
        login.clickButton("Rnext");
        login.fill("Rpassword1", Hash.revert(user.get("password")));
        login.fill("Rpassword2", (user.get("password")));

        login.clickButton(driver, "Rsubmit");
        String actualMessage = login.getAlertText();
        String expectedMessage = "A két jelszó nem egyezik meg, vagy rövidebbek, mint 6 karakter, esetleg nem tartalmaz számot!";

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test // OK
    @DisplayName("TCG06	Sikeres AKTÍV álláskereső regisztráció")
    public void testRegisterActiveEmployee() {
        choosePrice = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);
        user = utils.userData("user1.txt");
        //Methods.takeScreenshot(driver);
        choosePrice.choosePrice(user.get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("workingStatus"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Popups.popupClose(driver);
        Q050LoginAndRegistration login = hasRegistration.clickHaveRegistrationButton("not registred");
        login.clickCheckbox("RrsCheckbox");
        login.clickCheckbox("RssCheckbox");
        login.fill("Remail", user.get("email"));
        login.clickButton("Rnext");
        login.fill("Rpassword1", Hash.revert(user.get("password")));
        login.fill("Rpassword2", Hash.revert(user.get("password")));

        M01_step02 portrait = login.clickButton(driver, "Rsubmit");
        String actualURL = portrait.getUrl();
        System.out.println(actualURL);
        String expectedURL = "/munkavallalo/m01_step02_nevezesi-lap";

        Assertions.assertTrue(actualURL.contains(expectedURL));
    }

    @Test // OK
    @DisplayName("TCG07	Sikeres PASSZÍV álláskereső regisztráció")
    public void testRegisterPassiveEmployee() {
        choosePrice = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);
        user = utils.userData("user2.txt");
        //Methods.takeScreenshot(driver);
        choosePrice.choosePrice(user.get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("workingStatus"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Popups.popupClose(driver);
        Q050LoginAndRegistration login = hasRegistration.clickHaveRegistrationButton("not registred");
        login.clickCheckbox("RrsCheckbox");
        login.clickCheckbox("RssCheckbox");
        login.fill("Remail", user.get("email"));
        login.clickButton("Rnext");
        login.fill("Rpassword1", Hash.revert(user.get("password")));
        login.fill("Rpassword2", Hash.revert(user.get("password")));

        M01_step02 portrait = login.clickButton(driver, "Rsubmit");

        String actualURL = portrait.getUrl();
        System.out.println(actualURL);
        String expectedURL = "m01_step02_nevezesi-lap";
        //portrait.

        Assertions.assertTrue(actualURL.contains(expectedURL));
    }
}
