package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;

public class StartGame {
    private WebDriver driver;

    public StartGame(WebDriver driver) {
            this.driver = driver;
        }

    //CONSTANSES
    public final By FOOTER_MENU = By.xpath("/html/body/footer/div/div/div[1]/a");

    public By MV_BELEPES_LINK = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[4]/a");
    public  By MVRegisztracioLink = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[3]/a");
    public  By OneletrajomzLink = By.id("oneletrajz_feltoltese");

    public By TESCO = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[1]/div[1]/div[1]/div");
    public final By DECATHLON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[1]/div[1]/div[2]/div");
    public final By NEXT_BUTTON = By.id("check-voucher");

    public final By HAVE_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[1]");
    public final By HAVE_NO_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[2]");

    //methods

    public void clickHaveJobButton(){
        Methods.clickButton(driver, HAVE_JOB_BUTTON);
    }

    public void clickHaveNoJobButton(){
        Methods.clickButton(driver, HAVE_NO_JOB_BUTTON);
    }

}
