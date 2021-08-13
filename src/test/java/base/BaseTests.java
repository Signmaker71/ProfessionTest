package base;

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

public class BaseTests {

    protected WebDriver driver;
    protected HomePageHU homePage;
    /*WebDriverManager.firefoxdriver().setup();
    WebDriverManager.edgedriver().setup();
    WebDriverManager.operadriver().setup();
    WebDriverManager.phantomjs().setup();
    WebDriverManager.iedriver().setup();
    WebDriverManager.chromiumdriver().setup();*/
    String URL = "https://www.professionjatekok.hu/v2/main#";
    //String URL = "https://test.dev.profession.hu/";
    //String URL = "https://profession.hu/";
    public static WebDriverWait wait;
    FileUtils utils = new FileUtils();
    public HashMap<String, String> userData = utils.userData("user1.txt");
    protected Popups popups = new Popups(driver);



    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        driver.get(URL);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);

        homePage = new HomePageHU(driver);
        driver.manage().window().fullscreen();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
