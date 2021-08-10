package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import utils.Methods;

import java.util.List;

public class Q010ChoosePrice {
    private WebDriver driver;

    public Q010ChoosePrice(WebDriver driver) {
        this.driver = driver;
    }
    // footer divs one by one

    //  footer menu
    public final By FOOTER_MENU = By.xpath("/html/body/footer/div/div/div[1]/a");

    // choose-prize
    public By TESCO = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[1]/div[1]/div[1]/div");
    public final By DECATHLON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[1]/div[1]/div[2]/div");
    public final By CHOOSE_PRICE_NEXT_BUTTON = By.id("check-voucher");
    Methods methods;

    public void choosePrice(String selection) {
        boolean result = false;
        if (selection.toLowerCase().contains("tes")) {
            driver.findElement(TESCO).click();
            result = true;
        } else if (selection.toLowerCase().contains("dec")) {
            driver.findElement(DECATHLON).click();
            result = true;
        }
    }

    public Q020HasJob clickNextButton() {
        //wait = new WebDriverWait(driver, 0);
        methods = new Methods(driver);
        methods.clickButton(driver, CHOOSE_PRICE_NEXT_BUTTON);
        return new Q020HasJob(driver);
    }

    public boolean clickFooterMenu(String selection) {
        List<WebElement> menu = driver.findElements(FOOTER_MENU);
        boolean result = false;
        for (WebElement link : menu) {
            if (link.getText().contains(selection)) {
                link.click();
                ;
                result = true;
            }
        }
        return result;
    }


}
