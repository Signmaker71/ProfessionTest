package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ProfessionPages.HomePageHU;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.FileUtils;
import utils.Popups;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected WebDriver webDriver;
    protected HomePageHU homePage;

    String URL = "https://www.professionjatekok.hu/v2/main#";
    //String URL = "https://test.dev.profession.hu/";
    //String URL = "https://profession.hu/";
    public static WebDriverWait wait;
    FileUtils utils = new FileUtils();
    public HashMap<String, String> userData = utils.userData();
    protected Popups popups = new Popups(webDriver);


    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        webDriver = new ChromeDriver(options);

        webDriver.get(URL);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver,10);

        homePage = new HomePageHU(webDriver);
        webDriver.manage().window().fullscreen();
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
