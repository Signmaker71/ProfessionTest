package OlimpiaGamePagesV2;

import org.openqa.selenium.WebDriver;

public class M01_step02 {
    WebDriver webDriver;
    public M01_step02(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkName(String name){
        System.out.println(name);
    }
}
