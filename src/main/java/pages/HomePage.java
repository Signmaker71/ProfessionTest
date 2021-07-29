package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver webDriver;
    public  By MVBelepesLink = By.xpath("//*[@id=\"header\"]/div/div[3]/nav/div/div/ul/li[4]/a");

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public MVBelepes clickMVBelepesLink(){
        webDriver.findElement(MVBelepesLink).click();
        return  new MVBelepes(webDriver);
    }

    public void popupClose(){
        //webDriver.switchTo().alert().accept();
    }

}
