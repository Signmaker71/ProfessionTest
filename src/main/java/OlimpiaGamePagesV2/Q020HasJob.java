package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q020HasJob {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public Q020HasJob(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public final By HAVE_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[1]");
    public final By HAVE_NO_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[2]");




    public Q031HaveAJob clickHaveJobButton(){
        wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HAVE_JOB_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(HAVE_JOB_BUTTON));
        webDriver.findElement(HAVE_JOB_BUTTON).click();
        return new Q031HaveAJob(webDriver);
    }

    public Q032DontHave clickHaveNoJobButton(){
        wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HAVE_NO_JOB_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(HAVE_NO_JOB_BUTTON));
        webDriver.findElement(HAVE_NO_JOB_BUTTON).click();
        return new Q032DontHave(webDriver);
    }

}
