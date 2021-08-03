package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Q031HaveAJob {

    private WebDriver webDriver;
    public final By ABSOLOTELY_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[1]");
    public final By IF_BETTER_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[2]");
    public final By NOT_OPEN_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[3]");

    public Q031HaveAJob(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public Q040HasRegistration clickAbsolutelyButton() {
        webDriver.findElement(ABSOLOTELY_BUTTON).click();
        return new Q040HasRegistration(webDriver);
    }
    public Q040HasRegistration clickOpenForJobButton() {
        webDriver.findElement(IF_BETTER_BUTTON).click();
        return new Q040HasRegistration(webDriver);
    }
    public Q040HasRegistration clickNotOpenButton() {
        webDriver.findElement(NOT_OPEN_BUTTON).click();
        return new Q040HasRegistration(webDriver);
    }


}
