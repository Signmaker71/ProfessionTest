package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Q050LoginAndRegistration {
    private WebDriver driver;
    public final By LOGIN_EMAIL = By.id("player-mail-1");
    public final By REGISTER_EMAIL = By.id("player-mail-2");
    public final By LOGIN_PASSWORD = By.id("player-password");
    public final By REGISTER_PASSWORD_1 = By.id("player-password1");
    public final By REGISTER_PASSWORD_2 = By.id("player-password2");
    public final By REGISTER_RS_CHECHBOX = By.xpath("//*[@id=\"register-form-v4\"]/div[2]/div/div[1]/div/label");
    public final By REGISTER_SS_CHECHBOX = By.xpath("//*[@id=\"register-form-v4\"]/div[2]/div/div[2]/label");
    public final By LOGIN_RS_CHECHBOX = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[1]/div/label");
    public final By LOGIN_SS_CHECHBOX = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[2]/label");
    public final By REGISTER_NEXT_BUTTON = By.xpath("//*[@id=\"register-form-v4\"]/a");
    public final By LOGIN_NEXT_BUTTON = By.xpath("//*[@id=\"login-form-v4\"]/a");
    public final By LOGIN_SUBMIT_BUTTON = By.xpath("//*[@id=\"login-form-v4\"]/div[5]/div[3]/button");
    public final By REGISTER_SUBMIT_BUTTON = By.xpath("//*[@id=\"register-form-v4\"]/div[3]/div[3]/button");
    public final By REGISTER_TEXT_DANGER = By.cssSelector("#register-form-v4 > p > strong");

    public final By TERM_OF_USE_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[1]/div/label/a[1]");
    public final By PRIVACY_POLICY_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[1]/div/label/a[2]");
    public final By PRIVACY_POLICY_TEXT = By.xpath("//*[@id=\"preambulum\"]/div");
    public final By PRIVACY_POLICY_HEADERS = By.xpath("//*[@id=\"sidemenu-prof\"]/div/p");
    public final By GAME_RULES_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[2]/label/a[1]");
    public final By SWEEPSTAKES_STATEMENT_LINK = By.xpath("//*[@id=\"login-form-v4\"]/div[4]/div/div[2]/label/a[2]");


    public Q050LoginAndRegistration(WebDriver driver) {
        this.driver = driver;
    }

    public void fill(String locatorName, String name) {
        By locator = getLocator(locatorName);

        //Methods.waitForElementFillable(driver, locator);
        Methods.fillTextToField(driver,locator, name);
    }

    public void clickCheckbox(String name) {
        Methods.clickCheckbox(driver, getLocator(name));
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


    public void clickButton(String name)  { // Overrided method -
        Methods.waitForElementClickable(driver, getLocator(name)).click();
    }

    public M01_step02 clickButton(WebDriver driver, String name) {
        Methods.waitForElementClickable(driver, getLocator(name)).click();
        return new M01_step02(driver);
    }


    public String getAlertText() {
        return Methods.waitForElement(driver, REGISTER_TEXT_DANGER).getText();
    }


    private By getLocator(String name){
        By locator;
        switch (name){
            case "Lemail":
                locator = LOGIN_EMAIL;
                break;
            case "Remail":
                locator = REGISTER_EMAIL;
                break;
            case "Lpassword":
                locator = LOGIN_PASSWORD;
                break;
            case "Rpassword1":
                locator = REGISTER_PASSWORD_1;
                break;
            case "Rpassword2":
                locator = REGISTER_PASSWORD_2;
                break;
            case "RrsCheckbox":
                locator = REGISTER_RS_CHECHBOX;
                break;
            case "RssCheckbox":
                locator = REGISTER_SS_CHECHBOX;
                break;
            case "LrsCheckbox":
                locator = LOGIN_RS_CHECHBOX;
                break;
            case "LssCheckbox":
                locator = LOGIN_SS_CHECHBOX;
                break;
            case "Lsubmit":
                locator = LOGIN_SUBMIT_BUTTON;
                break;
            case "Rsubmit":
                locator = REGISTER_SUBMIT_BUTTON;
                break;
            case "termOfUse":
                locator = TERM_OF_USE_LINK;
                break;
            case "ppLink":
                locator = PRIVACY_POLICY_LINK;
                break;
            case "ppText":
                locator = PRIVACY_POLICY_TEXT;
                break;
            case "ppHeader":
                locator = PRIVACY_POLICY_HEADERS;
                break;
            case "grLink":
                locator = GAME_RULES_LINK;
                break;
            case "ssLink":
                locator = SWEEPSTAKES_STATEMENT_LINK;
                break;
            case "Rnext":
                locator = REGISTER_NEXT_BUTTON;
                break;
            case "Lnext":
                locator = LOGIN_NEXT_BUTTON;
                break;
            case "textDanger":
                locator = REGISTER_TEXT_DANGER;
                break;


            default:
                locator = LOGIN_NEXT_BUTTON;

        }
        return locator;
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


