package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;

public class Q031HaveAJob {

    private WebDriver driver;
    public final By ABSOLOTELY_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[1]");
    public final By IF_BETTER_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[2]");
    public final By NOT_OPEN_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[3]");


    public Q031HaveAJob(WebDriver driver) {
        this.driver = driver;
    }

    public Q040HasRegistration clickAbsolutelyButton() {
        Methods.clickButton(driver,ABSOLOTELY_BUTTON);
        return new Q040HasRegistration(driver);
    }
    public Q040HasRegistration clickOpenForJobButton() {

        Methods.clickButton(driver,IF_BETTER_BUTTON);
        return new Q040HasRegistration(driver);
    }
    public Q040HasRegistration clickNotOpenButton() {
        Methods.clickButton(driver,NOT_OPEN_BUTTON);
        return new Q040HasRegistration(driver);
    }


}
