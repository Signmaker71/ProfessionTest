package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInHomePageHU {

    // CONSTANSES
    private By EMPLOYEE_MENU_DROPDOWN_TRIGGER = By.xpath("//*[@id=\"employeeMenuDropdownTrigger\"]/span/text()");

    // PROPERTIES
    private WebDriver webDriver;

    // CONSTRUCTOR
    public LoggedInHomePageHU(WebDriver driver) {
        this.webDriver = driver;
    }

    // METHODS - did not use in this exam
    public String getEmployeeMenuDropdownTrigger(){
        return webDriver.findElement(EMPLOYEE_MENU_DROPDOWN_TRIGGER).getText();
    }
}
