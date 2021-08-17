package ProfessionPages;


import utils.Const;
import org.openqa.selenium.WebDriver;

public class PageHeaderMenuHU {
    protected WebDriver driver;

    public EmployeeLoginHU clickMVBelepesLink(){
        driver.findElement(Const.HM_MV_LOGIN_LINK).click();
        return  new EmployeeLoginHU(driver);
    }

    public EmployeeSigninHU clickMVRegisztracioLink(){
        driver.findElement(Const.HM_MV_REGISTRATION_LINK).click();
        return  new EmployeeSigninHU(driver);
    }

}
