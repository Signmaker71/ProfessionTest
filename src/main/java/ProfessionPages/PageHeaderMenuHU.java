package ProfessionPages;


import utils.Const;
import org.openqa.selenium.WebDriver;

public class PageHeaderMenuHU {
    protected WebDriver driver;

    public EmployeeLoginHU clickMVBelepesLink(){
        driver.findElement(Const.MV_BelepesLink).click();
        return  new EmployeeLoginHU(driver);
    }

    public EmployeeSigninHU clickMVRegisztracioLink(){
        driver.findElement(Const.MVRegisztracioLink).click();
        return  new EmployeeSigninHU(driver);
    }

}
