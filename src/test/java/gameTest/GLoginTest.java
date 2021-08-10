package gameTest;

import OlimpiaGamePagesV2.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FileUtils;
import utils.Popups;
import utils.Hash;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.TimeUnit;


public class GLoginTest extends FileUtils {
    final String URL_GAME = "https://www.professionjatekok.hu/v2/main#";
    final String URL_TEST_DEV = "https://test.dev.profession.hu/";
    final String URL_PROF = "https://profession.hu/";
    private final By COOKIE_ACCEPT = By.id("elfogad");
    private Q010ChoosePrice startGame;
    public WebDriver driver;
    //public WebDriver siteDriver;
    private WebDriverWait wait;
    FileUtils utils = new FileUtils();

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        //options.addArguments("--start-maximized");
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(/*options*/);

        driver.manage().window().maximize();
        //webDriver.manage().window().fullscreen();  Emiatt ugrott vissza kis méretre a folyamat közben

        driver.get(URL_GAME);

        wait = new WebDriverWait(driver, 3);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        startGame = new Q010ChoosePrice(driver);

    }

    @Test
    @DisplayName("TCG01 Testing to successful login")
    // HappyPath

    public void testSuccessfullLogin() throws InterruptedException {
        Popups popups = new Popups(driver);
        M01_step02 lastPage = new M01_step02(driver);
        //Thread.sleep(3000);
        startGame.choosePrice(utils.userData("user1.txt").get("choosenPrice"));
        Q020HasJob hasJob = startGame.clickNextButton();
        Q031HaveAJob haveAJob = hasJob.clickHaveJobButton();
        Q040HasRegistration hasRegistration = haveAJob.clickAbsolutelyButton();
        popups.popupClose();
        Q051Login login = hasRegistration.clickHaveRegistrationButton();
        login.clickRegistrationStatementCheckbox();
        login.clickSweepstakesStatementCheckbox();
        login.fillEmailField(Hash.revert(utils.userData("user1.txt").get("email")));
        //Thread.sleep(2000);
        login.clickNextButton();
        login.fillPasswordField(Hash.revert(utils.userData("user1.txt").get("password")));

        M01_step02 portrait = login.clickSubmitButton();
        String actualName = portrait.getName();
        String expectedName = utils.userData("user1.txt").get("name");

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    @DisplayName("TCG02 Testing try to login without accept terms and conditions")
    // checkbox nélküli belépési kísérlet

    public void testLoginWithoutCheckboxClicked() throws InterruptedException {
        String expectedAlertMessage = "Kérjük minden kötelező mezőt adjon meg!";

        Popups popups = new Popups(driver);
        //M01_step02 lastPage = new M01_step02(driver);

        startGame.choosePrice(utils.userData("user1.txt").get("choosenPrice"));
        Q020HasJob hasJob = startGame.clickNextButton();
        Q031HaveAJob haveAJob = hasJob.clickHaveJobButton();
        popups.popupClose();
        Q040HasRegistration hasRegistration = haveAJob.clickAbsolutelyButton();
        Q051Login login = hasRegistration.clickHaveRegistrationButton();
        login.clickRegistrationStatementCheckbox();
        //login.clickSweepstakesStatementCheckbox(); // This Checkbox will missing

        login.fillEmailField(Hash.revert(utils.userData("user1.txt").get("email")));
        //Thread.sleep(2000);

        login.ClickNextButton();
        String actualAlertMessage = login.getAlertMessage();

        Assertions.assertEquals(expectedAlertMessage, actualAlertMessage);
    }

    @Test
    @DisplayName("TCG03 Testing try to login with invalid e-mail format")

    // checkbox nélküli belépési kísérlet -Helyesen fail a teszt
    public void testLoginWithInvalidEmailFormat() throws InterruptedException {
        Popups popups = new Popups(driver);
        String expectedAlertMessage = "Érvénytelen email cím lett megadva.";

        startGame.choosePrice("Decathlon");
        Q020HasJob hasJob = startGame.clickNextButton();
        Q031HaveAJob haveAJob = hasJob.clickHaveJobButton();
        Q040HasRegistration hasRegistration = haveAJob.clickAbsolutelyButton();
        Q051Login login = hasRegistration.clickHaveRegistrationButton();
        popups.popupClose();
        login.clickRegistrationStatementCheckbox();
        login.clickSweepstakesStatementCheckbox();
        login.fillEmailField("email");
        login.clickNextButton();

        String actualAlertMessage = login.getAlertMessage();

        Assertions.assertEquals(expectedAlertMessage, actualAlertMessage);
    }

    @Test
    @DisplayName("TCG04 Testing to read terms and conditions")

    // Beolvassa és ellenőrzi az adatkezelési szabályzatot (GDPR)
    public void testLoginDocument01Exists() throws InterruptedException {
        Popups popups = new Popups(driver);
        List<String> expectedPrivacyPolicy = new ArrayList<>();
        expectedPrivacyPolicy.add("I. Preambulum");
        expectedPrivacyPolicy.add("II. Társaság adatai");
        expectedPrivacyPolicy.add("III. A társaság általi egyes adatkezelések");
        expectedPrivacyPolicy.add("IV. A felhasználók adatkezeléssel kapcsolatos információs önrendelkezési jogai és jogorvoslati lehetőségei");
        expectedPrivacyPolicy.add("V. Adatvédelmi incidensek kezelése és bejelentése");
        expectedPrivacyPolicy.add("VI. Adatbiztonság");
        expectedPrivacyPolicy.add("VII. Adatfeldolgozók");

        List<String> actualPrivacyPolicy;


        startGame.choosePrice("Decathlon");
        Q020HasJob hasJob = startGame.clickNextButton();
        Q031HaveAJob haveAJob = hasJob.clickHaveJobButton();
        Q040HasRegistration hasRegistration = haveAJob.clickAbsolutelyButton();

        Q051Login login = hasRegistration.clickHaveRegistrationButton();

        login.getPrivacyPolicyLink();
        popups.popupClose();



        driver.navigate().to("https://www.profession.hu/gdpr/");
        actualPrivacyPolicy = login.getPrivacyPolicyText();

        for (int i = 0; i < actualPrivacyPolicy.size(); i++) {
            System.out.println(expectedPrivacyPolicy.get(i) + "  ->  " + actualPrivacyPolicy.get(i));
            Assertions.assertEquals(expectedPrivacyPolicy.get(i), actualPrivacyPolicy.get(i));
        }
        Thread.sleep(5000);

    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
