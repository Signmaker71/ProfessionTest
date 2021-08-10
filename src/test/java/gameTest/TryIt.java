package gameTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TryIt extends FileUtils {

    public final By PRIVACY_POLICY_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[1]/div/label/a[2]");
    public final By PRIVACY_POLICY_HEADERS = By.xpath("//*[@id=\"sidemenu-prof\"]/div/p");
    final String URL_GDPR = "https://www.profession.hu/gdpr/";

    WebDriver driver = new ChromeDriver(/*options*/);

    WebDriverWait wait;
    FileUtils utils = new FileUtils();


    public static void main(String[] args)  {

        //simple alert
        //driver.findElement(By.id("alertBox")).click();
        //Alert simpleAlert = driver.switchTo().alert();
        //System.out.println(simpleAlert.getText());
        //Thread.sleep(2000);
        //simpleAlert.accept();
        //Thread.sleep(2000);
        //driver.close();
    }


    @BeforeEach
    private void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(/*options*/);
        driver.manage().window().maximize();
        driver.get(URL_GDPR);

        wait = new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @Test
    @DisplayName("TCG04 Testing to read terms and conditions")

    // Beolvassa az adatkezelési szabályzatot (GDPR)
    private void testLoginDocument01Exists() throws InterruptedException {

        List<String> expectedPrivacyPolicy = new ArrayList<>();
        expectedPrivacyPolicy.add("I. Preambulum");
        expectedPrivacyPolicy.add("II. Társaság adatai");
        expectedPrivacyPolicy.add("III. A társaság általi egyes adatkezelések");
        expectedPrivacyPolicy.add("IV. A felhasználók adatkezeléssel kapcsolatos információs önrendelkezési jogai és jogorvoslati lehetőségei");
        expectedPrivacyPolicy.add("V. Adatvédelmi incidensek kezelése és bejelentése");
        expectedPrivacyPolicy.add("VI. Adatbiztonság");
        expectedPrivacyPolicy.add("VII. Adatfeldolgozók");

        List<String> actualPrivacyPolicy;

        driver.navigate().to(URL_GDPR);

        actualPrivacyPolicy = getPrivacyPolicyText();

        for (int i = 0; i < actualPrivacyPolicy.size(); i++) {
            System.out.println(expectedPrivacyPolicy.get(i) + "  ->  " + actualPrivacyPolicy.get(i));
            Assertions.assertEquals(expectedPrivacyPolicy.get(i), actualPrivacyPolicy.get(i));
        }
        Thread.sleep(5000);

    }

    private List<String> getPrivacyPolicyText() throws InterruptedException {
        List<String> result = new ArrayList<String>();
        List<WebElement> gdprElements;

        driver.findElement(PRIVACY_POLICY_LINK).click();
        gdprElements = driver.findElements(PRIVACY_POLICY_HEADERS);
        for (WebElement element : gdprElements) {
            String header = element.getText();
            if (header.contains("\n+")) {
                header = header.replace("\n+", "");
            }
            result.add(header + "\n");
        }

        Thread.sleep(5000);

        return result;

    }

}
