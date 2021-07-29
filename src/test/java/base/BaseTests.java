package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.FileUtils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected WebDriver webDriver;
    protected HomePage homePage;
    public static WebDriverWait wait;
    FileUtils utils = new FileUtils();
    public HashMap<String, String> userData = utils.userData();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver = new ChromeDriver(options);

        webDriver.get("https://www.profession.hu/");

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver,20);

        homePage = new HomePage(webDriver);
        webDriver.manage().window().fullscreen();
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
