package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInHomePage {
    private WebDriver webDriver;
    private By employeeMenuDropdownTrigger = By.xpath("//*[@id=\"employeeMenuDropdownTrigger\"]/span/text()");

    public LoggedInHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getEmployeeMenuDropdownTrigger(){
        return webDriver.findElement(employeeMenuDropdownTrigger).getText();
    }
}
