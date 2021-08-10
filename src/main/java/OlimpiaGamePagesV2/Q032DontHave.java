package OlimpiaGamePagesV2;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import utils.Methods;

public class Q032DontHave {

    private WebDriver driver;
    public final By LOST_MY_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[1]");
    public final By LOST_MY_WORKPLACE_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[2]");
    public final By LEFT_MY_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[3]");
    public final By JOB_STARTER_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[4]");
    public final By SKIP_BUTTON = By.xpath("//*[@id=\"skip-main-question\"]");
    Methods methods;


    public Q032DontHave(WebDriver driver) {
        this.driver = driver;
    }

    public Q040HasRegistration clickLostMyJobButton() {
        driver.findElement(LOST_MY_JOB_BUTTON).click();
        return new Q040HasRegistration(driver);
    }
    public Q040HasRegistration clickLostMyWorkplaceButton() {
        driver.findElement(LOST_MY_WORKPLACE_BUTTON).click();
        return new Q040HasRegistration(driver);
    }
    public Q040HasRegistration clickLeftMyJobButton() {
        driver.findElement(LEFT_MY_JOB_BUTTON).click();
        return new Q040HasRegistration(driver);
    }
    public Q040HasRegistration clickJobStarterButton() {
        methods = new Methods(driver);
        methods.clickButton(driver,JOB_STARTER_BUTTON);
        return new Q040HasRegistration(driver);
    }
    public Q040HasRegistration clickSkipButton() {
        methods = new Methods(driver);
        methods.clickButton(driver,SKIP_BUTTON);
        return new Q040HasRegistration(driver);
    }

}

