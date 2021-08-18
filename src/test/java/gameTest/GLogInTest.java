package gameTest;

import OlimpiaGamePagesV2.*;
import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FileUtils;
import utils.Hash;
import utils.Popups;

import java.util.HashMap;


public class GLogInTest extends BaseTests {
    final String URL_GAME = "https://www.professionjatekok.hu/v2/main";
    final String URL_TEST_DEV = "https://test.dev.profession.hu/";
    final String URL_PROF = "https://profession.hu/";
    //private final By COOKIE_ACCEPT = By.id("elfogad");
    private Q010ChoosePrice choosePrice;
    FileUtils utils = new FileUtils();
    HashMap<String, String> user = new HashMap<String, String>();


    /*
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
        Assertions.assertEquals(expectedURL, actualURL);
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

        Assertions.assertEquals(expectedMessage, actualMessage);
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

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @Test // MINTA
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

        Assertions.assertTrue(actualURL.contains(expectedURL));
    }

    @Test
    @DisplayName("TCG08 Sikeres belépés regisztrált felhasználóként")
    // HappyPath

    public void testSuccessfullLogin() {
        choosePrice = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);
        user = utils.userData("user1.txt");
        //Methods.takeScreenshot(driver);
        choosePrice.choosePrice(user.get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("workingStatus"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Popups.popupClose(driver);
        Q050LoginAndRegistration login = hasRegistration.clickHaveRegistrationButton(user.get("registred"));
        login.clickCheckbox("rsCheckbox");
        login.clickCheckbox("ssCheckbox");
        login.fill("email", Hash.revert(user.get("email")));
        login.clickButton("next");
        login.fill("password", Hash.revert(user.get("password")));

        M01_step02 portrait = login.clickButton(driver, "submit");
        String actualName = portrait.getName();
        String expectedName = user.get("name");

        Assertions.assertEquals(expectedName, actualName);
    }

   /* @Test
    @DisplayName("TCG02 Testing try to login without accept terms and conditions")
    // checkbox nélküli belépési kísérlet

    public void testLoginWithoutCheckboxClicked() throws InterruptedException {
        String expectedAlertMessage = "Kérjük minden kötelező mezőt adjon meg!";

        //Popups popups = new Popups(driver);
        //M01_step02 lastPage = new M01_step02(driver);

        choosePrice.choosePrice(utils.userData("user1.txt").get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("haveJob"));
        Popups.popupClose();
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Q051Login login = hasRegistration.clickHaveRegistrationButton();
        login.clickRegistrationStatementCheckbox();
        //login.clickSweepstakesStatementCheckbox(); // This Checkbox will missing

        login.fillEmailField(Hash.revert(utils.userData("user1.txt").get("email")));
        //Thread.sleep(2000);

        login.ClickNextButton();
        String actualAlertMessage = login.getAlertMessage();

        Assertions.assertEquals(expectedAlertMessage, actualAlertMessage);
    }

    @Test // helyesen Fail
    @DisplayName("TCG03 Testing try to login with invalid e-mail format")

    // checkbox nélküli belépési kísérlet -Helyesen fail a teszt
    public void testLoginWithInvalidEmailFormat() throws InterruptedException {
        String expectedAlertMessage = "Érvénytelen email cím lett megadva.";

        choosePrice.choosePrice("Decathlon");
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("haveJob"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Q051Login login = hasRegistration.clickHaveRegistrationButton();
        Popups.popupClose();
        login.clickRegistrationStatementCheckbox();
        login.clickSweepstakesStatementCheckbox();
        login.fillEmailField("email");
        login.clickNextButton();

        String actualAlertMessage = login.getAlertMessage();

        Assertions.assertEquals(expectedAlertMessage, actualAlertMessage);
    }
*/
   /* @Test
    @DisplayName("TCG04 Testing to read terms and conditions")

    // Beolvassa és ellenőrzi az adatkezelési szabályzatot (GDPR)
    public void testLoginDocument01Exists() throws InterruptedException {
        List<String> expectedPrivacyPolicy = new ArrayList<>();
        expectedPrivacyPolicy.add("I. Preambulum");
        expectedPrivacyPolicy.add("II. Társaság adatai");
        expectedPrivacyPolicy.add("III. A társaság általi egyes adatkezelések");
        expectedPrivacyPolicy.add("IV. A felhasználók adatkezeléssel kapcsolatos információs önrendelkezési jogai és jogorvoslati lehetőségei");
        expectedPrivacyPolicy.add("V. Adatvédelmi incidensek kezelése és bejelentése");
        expectedPrivacyPolicy.add("VI. Adatbiztonság");
        expectedPrivacyPolicy.add("VII. Adatfeldolgozók");

        List<String> actualPrivacyPolicy;


        choosePrice.choosePrice("Decathlon");
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q031HaveAJob haveAJob = hasJob.clickHaveJobButton();
        Q040HasRegistration hasRegistration = haveAJob.clickAbsolutelyButton();

        Q051Login login = hasRegistration.clickHaveRegistrationButton();

        login.getPrivacyPolicyLink();
        Popups.popupClose();



        driver.navigate().to("https://www.profession.hu/gdpr/");
        actualPrivacyPolicy = login.getPrivacyPolicyText();

        for (int i = 0; i < actualPrivacyPolicy.size(); i++) {
            System.out.println(expectedPrivacyPolicy.get(i) + "  ->  " + actualPrivacyPolicy.get(i));
            Assertions.assertEquals(expectedPrivacyPolicy.get(i), actualPrivacyPolicy.get(i));
        }
        //Thread.sleep(5000);

    }
*/
}
