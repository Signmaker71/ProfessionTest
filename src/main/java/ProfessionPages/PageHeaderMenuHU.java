package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHeaderMenuHU {
    private WebDriver webDriver;
    public By MVBelepesLink = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[4]/a");
    public  By MVRegisztracioLink = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[3]/a");
    public  By OneletrajomzLink = By.id("oneletrajz_feltoltese");


    public EmployeeLoginHU clickMVBelepesLink(){
        webDriver.findElement(MVBelepesLink).click();
        return  new EmployeeLoginHU(webDriver);
    }

    public EmployeeSigninHU clickMVRegisztracioLink(){
        webDriver.findElement(MVRegisztracioLink).click();
        return  new EmployeeSigninHU(webDriver);
    }


}
