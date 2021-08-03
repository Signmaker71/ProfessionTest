package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSigninHU extends PageHeaderMenuHU {

    private WebDriver webDriver;
    private final By userEmailField = By.id("email");
    private final By passwordField = By.id("password_id");
    private final By nameField = By.id("name");
    private final By cityField = By.id("city");
    private final By workingStatusField = By.id("working_status");
    private final By positionField = By.id("choose_position");
    private final By dataAcceptCheckbox = By.id("data_accept_label");
    private final By dataManagementRegulations = By.xpath("//*[@id=\"data_accept_label\"]/a[2]");
    private final By eDMCheckbox = By.id("marketing_label");

    private final By registrationButton = By.xpath("//*[@id=\"registration_form\"]/div[12]/input");

    public EmployeeSigninHU(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void setEmail(String userName) {
        webDriver.findElement(userEmailField).sendKeys(userName);
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void setName(String name) { webDriver.findElement(nameField).sendKeys(name); }

    public void setCity(String city) { webDriver.findElement(cityField).sendKeys(city); }

    public void setPosition(String position) { webDriver.findElement(positionField).sendKeys(position); }

    public void selectWorkingStatus(String workingStatus) {
        findWorkingStatusDropdown().selectByValue(workingStatus);
    }


    // visszaadja egy dropdown kiválasztott elemeit egy listában
    public List<String> getSelectedWorkingStatus(){
        List<WebElement> selectedElements = findWorkingStatusDropdown().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findWorkingStatusDropdown(){
        return new Select(webDriver.findElement(workingStatusField));
    }

    public void setDataAcceptCheckbox() { webDriver.findElement(dataAcceptCheckbox).click(); }

    public void getDataManagementRegulations() { webDriver.findElement(dataManagementRegulations).click(); }

    public void setEDMCheckbox() { webDriver.findElement(eDMCheckbox).click(); }

    public LoggedInHomePageHU clickLogInButton() {
        webDriver.findElement(registrationButton).click();
        return new LoggedInHomePageHU(webDriver);
    }

}
