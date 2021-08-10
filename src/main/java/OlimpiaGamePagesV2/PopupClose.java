package OlimpiaGamePagesV2;

import org.openqa.selenium.WebDriver;

public class PopupClose {
    WebDriver driver;

    public boolean IsAlertPresent(WebDriver webDriver)
    {
        this.driver = webDriver;
        try
        {
            webDriver.switchTo().alert();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
