package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;

public class Q020HasJob {

    // CONSTANSES
    public final By HAVE_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[1]");
    public final By HAVE_NO_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[2]");


    // PROPERTIES
    private WebDriver driver;


    // CONSTRUCTOR
    public Q020HasJob(WebDriver driver) {
        this.driver = driver;
    }


    // METHODS
    public Q030WorkingStatus selectHaveJobButton(String selection) {
        switch (selection) {
            case "no":
                Methods.clickButton(driver, HAVE_NO_JOB_BUTTON);
                break;
            default:
                Methods.clickButton(driver, HAVE_JOB_BUTTON);
        }
        return new Q030WorkingStatus(driver);

    }


    public Q031HaveAJob clickHaveJobButton() {
        Methods.clickButton(driver, HAVE_JOB_BUTTON);
        return new Q031HaveAJob(driver);
    }

    public Q032DontHave clickHaveNoJobButton() {
        Methods.clickButton(driver, HAVE_NO_JOB_BUTTON);
        return new Q032DontHave(driver);
    }

}
