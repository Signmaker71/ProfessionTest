package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;

public class Q030WorkingStatus {

    // CONSTANSES
    // Have a job
    public final By ABSOLOTELY_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[1]");
    public final By IF_BETTER_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[2]");
    public final By NOT_OPEN_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[3]");
    // Have no job
    public final By LOST_MY_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[1]");
    public final By LOST_MY_WORKPLACE_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[2]");
    public final By LEFT_MY_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[3]");
    public final By JOB_STARTER_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[4]");
    public final By SKIP_BUTTON = By.xpath("//*[@id=\"skip-main-question\"]");


    // PROPERTIES
    private WebDriver driver;


    // CONSTRUCTOR
    public Q030WorkingStatus(WebDriver driver) {
        this.driver = driver;
    }


    // METHODS

    private By getButtonBy(String answer) {
        answer = answer.toLowerCase();
        By buttonBy;
        switch (answer) {
            case "interested":
                buttonBy = ABSOLOTELY_BUTTON;
                break;
            case "if better":
                buttonBy = IF_BETTER_BUTTON;
                break;
            // not open is default
            case "lost my job":
                buttonBy = LOST_MY_JOB_BUTTON;
                break;
            case "lost my workplace":
                buttonBy = LOST_MY_WORKPLACE_BUTTON;
                break;
            case "left my job":
                buttonBy = LEFT_MY_JOB_BUTTON;
                break;
            case "job starter":
                buttonBy = JOB_STARTER_BUTTON;
                break;
            default:
                buttonBy = NOT_OPEN_BUTTON;
                break;
        }
        return buttonBy;
    }

    public Q040HasRegistration selectJobStatus(String answer) {
        Methods.clickButton(driver, getButtonBy(answer));
        return new Q040HasRegistration(driver);
    }
}
