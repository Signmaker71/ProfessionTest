package gameTest;

import OlimpiaGamePagesV2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FileUtils;
import utils.Popups;

import java.util.concurrent.TimeUnit;


public class GLoginTest extends FileUtils {
    final String URL_GAME = "https://www.professionjatekok.hu/v2/main#";
    final String URL_TEST_DEV = "https://test.dev.profession.hu/";
    final String URL_PROF = "https://profession.hu/";
    private final By COOKIE_ACCEPT = By.id("elfogad");
    private Q010ChoosePrice startGame ;
    public WebDriver webDriver;
    //public WebDriverWait wait;


    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-dev-shm-usage");
        webDriver = new ChromeDriver(options);
        webDriver.get(URL_GAME);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        webDriver.manage().window().fullscreen();
        System.out.println("1");
        startGame = new Q010ChoosePrice(webDriver);
        System.out.println("2");
    }

    @Test
    public void testSuccessfullLogin() {
        Popups popups = new Popups(webDriver);
        System.out.println(popups.getUrl());
        popups.popupClose();
        System.out.println("33");

        startGame.clickButton("Decathlon");
        System.out.println("3");
        Q020HasJob hasJob = startGame.clickNextButton();
        System.out.println("4");
        Q031HaveAJob haveAJob = hasJob.clickHaveJobButton();
        System.out.println("5");
        Q040HasRegistration hasRegistration = haveAJob.clickAbsolutelyButton();
        System.out.println("6");
        Q051Login login = hasRegistration.clickHaveRegistrationButton();
        login.clickRegistrationStatementCheckbox();
        login.clickSweepstakesStatementCheckbox();
        login.fillEmailField("ggggg");
        //Thread.sleep(5000);

    }

}
