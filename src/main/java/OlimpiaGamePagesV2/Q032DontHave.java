package OlimpiaGamePagesV2;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

public class Q032DontHave {

    private WebDriver webDriver;
    public final By LOST_MY_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[1]");
    public final By LOST_MY_WORKPLACE_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[2]");
    public final By LEFT_MY_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[3]");
    public final By JOB_STARTER_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[4]");
    public final By SKIP_BUTTON = By.xpath("//*[@id=\"skip-main-question\"]");


    public Q032DontHave(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Q040HasRegistration clickLostMyJobButton() {
        webDriver.findElement(LOST_MY_JOB_BUTTON).click();
        return new Q040HasRegistration(webDriver);
    }
    public Q040HasRegistration clickLostMyWorkplaceButton() {
        webDriver.findElement(LOST_MY_WORKPLACE_BUTTON).click();
        return new Q040HasRegistration(webDriver);
    }
    public Q040HasRegistration clickLeftMyJobButton() {
        webDriver.findElement(LEFT_MY_JOB_BUTTON).click();
        return new Q040HasRegistration(webDriver);
    }
    public Q040HasRegistration clickJobStarterButton() {
        webDriver.findElement(JOB_STARTER_BUTTON).click();
        return new Q040HasRegistration(webDriver);
    }
    public Q040HasRegistration clickSkipButton() {
        webDriver.findElement(SKIP_BUTTON).click();
        return new Q040HasRegistration(webDriver);
    }

}

