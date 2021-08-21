package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Methods;

public class HomePageHU extends PageHeaderMenuHU {

    // CONSTANSES
    public final By KEYWORD_SEARCH_FIELD = By.id("header_keyword");
    public final By LOCATION_SEARCH_FIELD = By.id("header_location");
    public final By SEARCH_BUTTON = By.id("search-bar-search-button");
    public final By SEARCH_BY_DETAILS_BUTTON = By.id("tour_det_search");
    private final By CV_BUTTON = By.id("oneletrajz_feltoltese");

    // PROPERTIES
    public WebDriver driver;

    // CONSTRUCTOR
    public HomePageHU(WebDriver driver) {
        this.driver = driver;
    }

    // METHODS
    public void fillSearchByKeywordField(String position){
        Methods.waitForElement(driver, KEYWORD_SEARCH_FIELD).sendKeys(position);
    }

    public void fillSearchLocationField(String location) {
        Methods.fillTextToField(driver, LOCATION_SEARCH_FIELD, location);
        driver.findElement(LOCATION_SEARCH_FIELD).sendKeys(location);
    }

    public JobsPageHU clickSearchButton(){
        driver.findElement(SEARCH_BUTTON).click();
        return  new JobsPageHU(driver);
    }

    public CV_Page getCV_Page(){
        Methods.clickButton(driver, CV_BUTTON);
        return new CV_Page(driver);
    }

}
