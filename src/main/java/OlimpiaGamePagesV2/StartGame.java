package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class StartGame {
    private WebDriver driver;

    // CONSTRUCTOR
    public StartGame(WebDriver driver) {
        this.driver = driver;
    }

    // CONSTANSES

    // Page Header Menu
    public final By PHM_LOGIN_LINK = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[4]/a");
    public final By PHM_REGISTRATION_LINK = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[3]/a");
    public final By PHM_CV_LINK = By.id("oneletrajz_feltoltese");

    // Page Footer Menu
    public final By PFM_FOOTER_MENU = By.xpath("/html/body/footer/div/div/div[1]/a");

    // Choose Price
    public final By TESCO_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[1]/div[1]/div[1]/div");
    public final By DECATHLON_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[1]/div[1]/div[2]/div");
    public final By CHOOSE_PRICE_NEXT_BUTTON = By.id("check-voucher");

    // Do You Have Job?
    public final By HAVE_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[1]");
    public final By HAVE_NO_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[2]/a[2]");

    // Do You Interest For a New Job?
    public final By ABSOLOTELY_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[1]");
    public final By IF_BETTER_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[2]");
    public final By NOT_OPEN_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[3]/a[3]");

    // Why Don't You Have Job?
    public final By LOST_MY_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[1]");
    public final By LOST_MY_WORKPLACE_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[2]");
    public final By LEFT_MY_JOB_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[3]");
    public final By JOB_STARTER_BUTTON = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[4]/a[4]");
    public final By SKIP_BUTTON = By.xpath("//*[@id=\"skip-main-question\"]");

    // Do You Have Registration?
    private final By REGISTRED_BUTTON = By.xpath("//*[contains(text(),'megyek')]");
    private final By NOT_REMEMBER_BUTTON = By.xpath("//*[contains(text(),'emlékszem')]");
    private final By NOT_REGISTRED_BUTTON = By.xpath("//*[contains(text(),'Nincs')]");

    // Login Page
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


    // METHODS

    public void clickButtonBy(String button){
        Methods.clickButton(driver, getButtonBy(button));
    }

    public void clickCheckbox(String checkbox){
        Methods.clickCheckbox(checkbox);
    }
    public By getButtonBy(String selection){
        selection = selection.toUpperCase();
        By buttonBy;
        switch(selection) {
            case "TESCO":
                buttonBy = TESCO_BUTTON;
                break;
            case "DECATHLON":
                buttonBy = DECATHLON_BUTTON;
                break;
            case "HAVE JOB":
                buttonBy = HAVE_JOB_BUTTON;
                break;
            case "HAVE NO JOB":
                buttonBy = HAVE_NO_JOB_BUTTON;
                break;
            case "ABSOLUTELY":
                buttonBy = ABSOLOTELY_BUTTON;
                break;
            case "IF BETTER":
                buttonBy = IF_BETTER_BUTTON;
                break;
            case "NOT OPEN":
                buttonBy = NOT_OPEN_BUTTON;
                break;
            case "LOST MY JOB":
                buttonBy = LOST_MY_JOB_BUTTON;
                break;
            case "LOST MY WORKPLACE":
                buttonBy = LOST_MY_WORKPLACE_BUTTON;
                break;
            case "LEFT MY JOB":
                buttonBy = LEFT_MY_JOB_BUTTON;
                break;
            case "JOB STARTER":
                buttonBy = JOB_STARTER_BUTTON;
                break;
            case "HAVE REGISTRATION":
                buttonBy = REGISTRED_BUTTON;
                break;
            case "NOT REMEMBER":
                buttonBy = NOT_REMEMBER_BUTTON;
                break;
            case "NOT REGISTRED":
                buttonBy = NOT_REGISTRED_BUTTON;
                break;
            case "LOGIN NEXT":
                buttonBy = NEXT_BUTTON;
                break;
            case "REGISTRATION NEXT":
                buttonBy = REGISTRED_BUTTON;
                break;
            case "FF":
                buttonBy = REGISTRATION_STATEMENT_CHECHBOX;
                break;
            case "NYJSZ":
                buttonBy = SWEEPSTAKES_STATEMENT_CHECHBOX;
                break;

            default:
                buttonBy = NEXT_BUTTON;
        }
        return buttonBy;
    }


    // Choose Price
    public void choosePrice(String selection) {
        if (selection.toLowerCase().contains("tes")) {
            Methods.clickButton(driver, TESCO_BUTTON);
        } else if (selection.toLowerCase().contains("dec")) {
            Methods.clickButton(driver, DECATHLON_BUTTON);
        }
    }
    public void clickChoosePriceNextButton() {
        Methods.clickButton(driver, CHOOSE_PRICE_NEXT_BUTTON);

    }

    // Do You Have Job?
    public void clickHaveJobButton() {
        Methods.clickButton(driver, HAVE_JOB_BUTTON);
    }
    public void clickHaveNoJobButton() {
        Methods.clickButton(driver, HAVE_NO_JOB_BUTTON);
    }

    // Do You Interest For a New Job?
    public void clickAbsolutelyButton() {
        Methods.clickButton(driver,ABSOLOTELY_BUTTON);
    }
    public void clickOpenForJobButton() {
        Methods.clickButton(driver,IF_BETTER_BUTTON);
    }
    public void clickNotOpenButton() {
        Methods.clickButton(driver,NOT_OPEN_BUTTON);
    }


    // Why Don't You Have Job?
    public void clickLostMyJobButton() {
        driver.findElement(LOST_MY_JOB_BUTTON).click();
    }
    public void clickLostMyWorkplaceButton() {
        driver.findElement(LOST_MY_WORKPLACE_BUTTON).click();
    }
    public void clickLeftMyJobButton() {
        driver.findElement(LEFT_MY_JOB_BUTTON).click();
    }
    public void clickJobStarterButton() {
        Methods.clickButton(driver,JOB_STARTER_BUTTON);
    }
    public void clickSkipButton() {
        Methods.clickButton(driver,SKIP_BUTTON);
    }

    // Do You Have Registration?
    public void clickHaveRegistrationButton() {
        Methods.clickButton(driver,REGISTRED_BUTTON);
    }
    public void clickNotRememberButton() {
        Methods.clickButton(driver,NOT_REMEMBER_BUTTON);
    }
    public void clickNotRegistredButton() {
        Methods.clickButton(driver,NOT_REGISTRED_BUTTON);
    }

    // Login Page
    public void fillEmailField(String email) {
        driver.findElement(PLAYER_EMAIL).sendKeys(email);
    }

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








    // Footer Menu
    public boolean clickFooterMenu(String selection) {
        List<WebElement> menu = driver.findElements(PFM_FOOTER_MENU);
        boolean result = false;
        for (WebElement link : menu) {
            if (link.getText().contains(selection)) {
                link.click();
                ;
                result = true;
            }
        }
        return result;
    }


}
