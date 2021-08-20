package base;

import OlimpiaGamePagesV2.Q010ChoosePrice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import ProfessionPages.HomePageHU;
import utils.FileUtils;
import utils.Popups;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseGameTests {

    protected WebDriver driver;
    protected HomePageHU homePage;

    final String URL = "https://www.professionjatekok.hu/v2/main#";


    public WebDriverWait wait;
    FileUtils utils = new FileUtils();
    protected HashMap<String, String> userData;
    protected Popups popups = new Popups(driver);
    protected final String URL_GAME = "https://www.professionjatekok.hu/v2/main";
    protected Q010ChoosePrice starterPage;
    protected HashMap<String, String> user = new HashMap<String, String>();


    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        //options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,3);

        starterPage = new Q010ChoosePrice(driver);
        driver.navigate().to(URL_GAME);

        //homePage = new HomePageHU(driver);
        //driver.manage().window().maximize();

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
