package base;

import OlimpiaGamePagesV2.Q010ChoosePrice;
import ProfessionPages.HomePageHU;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FileUtils;
import utils.Popups;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseProfessionTests {

    protected WebDriver driver;
    protected HomePageHU homePage;

    final String URL = "https://www.professionjatekok.hu/v2/main#";


    public WebDriverWait wait;
    FileUtils utils = new FileUtils();
    protected HashMap<String, String> userData;
    protected Popups popups = new Popups(driver);
    protected final String URL_GAME = "https://www.professionjatekok.hu/v2/main";
    protected Q010ChoosePrice starterPage;


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

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,3);
        homePage = new HomePageHU(driver);
        //driver.manage().window().maximize();

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
