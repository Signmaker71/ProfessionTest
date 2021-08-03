package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Q051Login {
    private WebDriver webDriver;
    public final By PLAYER_EMAIL = By.id("player-mail-1");
    public final By REGISTRATION_STATEMENT_CHECHBOX = By.id("check-04-1");
    public final By SWEEPSTAKES_STATEMENT_CHECHBOX = By.id("check-01-1");
    public final By NEXT_BUTTON = By.xpath("//*[@id=\"login-form-v4\"]/a");

    public final By TERM_OF_USE_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[1]/div/label/a[1]");
    public final By PRIVACY_POLICY_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[1]/div/label/a[2]");
    public final By PRIVACY_POLICY_TEXT = By.xpath("//*[@id=\"preambulum\"]/div");
    public final By GAME_RULES_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[2]/label/a[1]");
    public final By SWEEPSTAKES_STATEMENT_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[2]/label/a[2]");

    public Q051Login(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void fillEmailField(String email) {
        webDriver.findElement(PLAYER_EMAIL).sendKeys(email);
    }

    public void clickRegistrationStatementCheckbox() {
        webDriver.findElement(REGISTRATION_STATEMENT_CHECHBOX).click();
    }

    public void clickSweepstakesStatementCheckbox() {
        webDriver.findElement(SWEEPSTAKES_STATEMENT_CHECHBOX).click();
    }
    public M01_step02 clickNextButton() {
        webDriver.findElement(NEXT_BUTTON).click();
        return new M01_step02(webDriver);
    }



    public String getTermOfUseLink() {
        String result;
        Set<String> handlesSet = webDriver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);

        webDriver.findElement(TERM_OF_USE_LINK).click();

        webDriver.switchTo().window(handlesList.get(1));
        result = webDriver.getCurrentUrl();

        webDriver.close();
        webDriver.switchTo().window(handlesList.get(0));
        return result;

    }

    public String getPrivacyPolicyLink() {
        String result;
        Set<String> handlesSet = webDriver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);

        webDriver.findElement(PRIVACY_POLICY_LINK).click();

        webDriver.switchTo().window(handlesList.get(1));
        result = webDriver.getCurrentUrl();

        webDriver.close();
        webDriver.switchTo().window(handlesList.get(0));
        return result;

    }


    //GDPR text getter
    // átnézni
    public List<String> getPrivacyPolicyText() {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<WebElement> gdprElements = new ArrayList<WebElement>();
        Set<String> handlesSet = webDriver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);

        webDriver.findElement(PRIVACY_POLICY_LINK).click();

        webDriver.switchTo().window(handlesList.get(1));
        for (WebElement element:gdprElements) {
            result.add(element.getText() + "\n");
        }

        webDriver.close();
        webDriver.switchTo().window(handlesList.get(0));
        return result;

    }

}


