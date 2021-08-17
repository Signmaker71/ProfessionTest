package OlimpiaGamePagesV2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Q051Login {
    private WebDriver driver;
    public final By PLAYER_EMAIL = By.id("player-mail-1");
    public final By PLAYER_PASSWORD = By.id("player-password");
    public final By REGISTRATION_STATEMENT_CHECHBOX = By.xpath("//*[contains(text(),'Regisztrálok. Elfogadom a')]");
    public final By SWEEPSTAKES_STATEMENT_CHECHBOX = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[2]/label");
    public final By NEXT_BUTTON = By.xpath("//*[@id=\"login-form-v4\"]/a");
    public final By SUBMIT_BUTTON = By.xpath("//*[contains(@type,'submit')]");

    public final By TERM_OF_USE_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[1]/div/label/a[1]");
    public final By PRIVACY_POLICY_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[1]/div/label/a[2]");
    public final By PRIVACY_POLICY_TEXT = By.xpath("//*[@id=\"preambulum\"]/div");
    public final By PRIVACY_POLICY_HEADERS = By.xpath("//*[@id=\"sidemenu-prof\"]/div/p");
    public final By GAME_RULES_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[2]/label/a[1]");
    public final By SWEEPSTAKES_STATEMENT_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[2]/label/a[2]");


    public Q051Login(WebDriver driver) {
        this.driver = driver;
    }

    public void fillEmailField(String text) {
        Methods.waitForElementFillable(driver, PLAYER_EMAIL);
        Methods.fillTextToField(driver,PLAYER_EMAIL, text);
        //driver.findElement(PLAYER_EMAIL).sendKeys(email);
    }


    /*public void fillEmailField(String email) {
        driver.findElement(PLAYER_EMAIL).sendKeys(email);
    }*/

    public void fillPasswordField(String password) {
        Methods.fillTextToField(driver, PLAYER_PASSWORD, password);
    }

    public void clickRegistrationStatementCheckbox() {
        Methods.clickCheckbox(driver, REGISTRATION_STATEMENT_CHECHBOX);
    }

    public void clickSweepstakesStatementCheckbox() {
        Methods.clickCheckbox(driver, SWEEPSTAKES_STATEMENT_CHECHBOX);
    }

    public String alertHandle() {
        String alertMessage = Methods.getAlertText(driver);
        Methods.acceptAlert(driver);
        return alertMessage;
    }

    public String getAlertMessage(){
        String alertText;
        alertText = Methods.getAlertText(driver);
        return alertText;
    }


    public void ClickNextButton()  { // Overrided method -
        driver.findElement(NEXT_BUTTON).click();
    }

    public M01_step02 clickNextButton() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(NEXT_BUTTON).click();
        Thread.sleep(500);
        //Methods.clickButton(driver, NEXT_BUTTON);
        return new M01_step02(driver);
    }



    public M01_step02 clickSubmitButton() {
        Methods.clickButton(driver, SUBMIT_BUTTON);
        return new M01_step02(driver);
    }

    public String getTermOfUseLink() {
        String result;
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);

        driver.findElement(TERM_OF_USE_LINK).click();

        driver.switchTo().window(handlesList.get(1));
        result = driver.getCurrentUrl();

        driver.close();
        driver.switchTo().window(handlesList.get(0));
        return result;
    }

    public String getPrivacyPolicyLink() {
        String result;
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);

        driver.findElement(PRIVACY_POLICY_LINK).click();

        driver.switchTo().window(handlesList.get(1));
        result = driver.getCurrentUrl();

        driver.close();
        driver.switchTo().window(handlesList.get(0));
        return result;
    }


    //GDPR text getter
    // átnézni
    public List<String> getPrivacyPolicyText() throws InterruptedException {
        List<String> result = new ArrayList<String>();
        List<WebElement> gdprElements;


        driver.findElement(PRIVACY_POLICY_LINK).click();
        gdprElements = driver.findElements(PRIVACY_POLICY_HEADERS);
        for (WebElement element : gdprElements) {
            String header = element.getText();
            if (header.contains("\n+")) {
                header = header.replace("\n+", "");

            }
            result.add(header + "\n");
        }
        Thread.sleep(5000);

        return result;

    }

    public void clickPreambulum() {
        driver.findElement(By.xpath("//*[@id=\"sidemenu-prof\"]/div/p[3]/a")).click();
    }

}


