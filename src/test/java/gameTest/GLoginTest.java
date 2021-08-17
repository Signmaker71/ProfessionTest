package gameTest;

import OlimpiaGamePagesV2.*;
import base.BaseTests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import utils.FileUtils;
import utils.Popups;
import utils.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GLoginTest extends BaseTests {
    final String URL_GAME = "https://www.professionjatekok.hu/v2/main#";
    final String URL_TEST_DEV = "https://test.dev.profession.hu/";
    final String URL_PROF = "https://profession.hu/";
    private final By COOKIE_ACCEPT = By.id("elfogad");
    private Q010ChoosePrice choosePrice;
    //public WebDriver driver;
    //protected WebDriverWait wait;
    FileUtils utils = new FileUtils();
    HashMap<String, String> user = new HashMap<String, String>();

    @Test
    @DisplayName("TCG01 Testing to successful login")
    // HappyPath

    public void testSuccessfullLogin() throws InterruptedException {
        choosePrice = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);
        user = utils.userData("user1.txt");

        choosePrice.choosePrice(user.get("choosenPrice"));
        Q020HasJob hasJob = choosePrice.clickNextButton();
        Q030WorkingStatus workingStatus = hasJob.selectHaveJobButton(user.get("haveJob"));
        Q040HasRegistration hasRegistration = workingStatus.selectJobStatus(user.get("workingStatus"));
        Popups.popupClose();
        Q051Login login = hasRegistration.clickHaveRegistrationButton();
        login.clickRegistrationStatementCheckbox();
        login.clickSweepstakesStatementCheckbox();
        login.fillEmailField(Hash.revert(user.get("email")));
        login.clickNextButton();
        login.fillPasswordField(Hash.revert(user.get("password")));

        M01_step02 portrait = login.clickSubmitButton();
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
    @Test
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

}
