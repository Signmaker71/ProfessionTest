package ProfessionPages;


import org.openqa.selenium.By;
import utils.Const;
import org.openqa.selenium.WebDriver;
import utils.Methods;

public class PageHeaderMenuHU {
    protected static final By HM_MV_LOGIN_BUTTON = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[4]/a");
    protected static final  By HM_MV_REGISTRATION_LINK = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[3]/a");
    protected static final  By CV_LINK = By.id("oneletrajz_feltoltese");
    protected static final By USER_NAME = By.xpath("//*[@id=\"employeeMenuDropdownTrigger\"]/span");

    protected WebDriver driver;

    public EmployeeLoginHU clickEmpLoginButton(WebDriver driver){
        Methods.waitForElement(driver,HM_MV_LOGIN_BUTTON).click();
        return  new EmployeeLoginHU(driver);
    }

protected EmployeeLoginHU clickMVCVLink(){
        Methods.waitForElement(driver,HM_MV_LOGIN_BUTTON).click();
        return  new EmployeeLoginHU(driver);
    }

    public EmployeeSigninHU clickEmpRegistration(){
        Methods.waitForElement(driver,HM_MV_REGISTRATION_LINK).click();
        return  new EmployeeSigninHU(driver);
    }
    protected String getUserName(){
        String userName = Methods.waitForElement(driver, USER_NAME).getText();
        return userName;
    }

    protected EmployeeSigninHU valami(){
        driver.findElement(Const.HM_MV_REGISTRATION_LINK).click();
        return  new EmployeeSigninHU(driver);
    }



}
