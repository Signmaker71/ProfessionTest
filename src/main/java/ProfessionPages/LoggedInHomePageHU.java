package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInHomePageHU {
    private WebDriver webDriver;
    private By employeeMenuDropdownTrigger = By.xpath("//*[@id=\"employeeMenuDropdownTrigger\"]/span/text()");

    public LoggedInHomePageHU(WebDriver driver) {
        this.webDriver = driver;
    }

    public String getEmployeeMenuDropdownTrigger(){
        return webDriver.findElement(employeeMenuDropdownTrigger).getText();
    }
}
