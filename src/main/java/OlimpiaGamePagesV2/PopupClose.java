package OlimpiaGamePagesV2;

import org.openqa.selenium.WebDriver;

public class PopupClose {
    WebDriver webDriver;

    public boolean IsAlertPresent(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        try
        {
            webDriver.switchTo().alert();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
