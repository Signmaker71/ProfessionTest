package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Actions {
    private static WebDriver webDriver;
    public Actions(WebDriver webDriver){this.webDriver = webDriver;}

    public static void clickLink() {
    }

    public static void clickLink(String linkText){
        webDriver.findElement(By.linkText(linkText)).click();
    }
}
