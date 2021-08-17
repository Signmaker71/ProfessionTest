package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Methods;

public class HomePageHU extends PageHeaderMenuHU {

    public WebDriver driver;

    public  By SearchByKeywordField = By.id("header_keyword");
    public  By SearchLocationField = By.id("header_location");
    public  By SearchButton = By.id("search-bar-search-button");
    public  By SearchDetailedButton = By.id("tour_det_search");

    public HomePageHU(WebDriver driver) {
        this.driver = driver;
    }

    public void fillSearchByKeywordField(String position){
        Methods.waitForElementFillable(driver, SearchByKeywordField);
        driver.findElement(SearchByKeywordField).sendKeys(position);
    }

    public void fillSearchLocationField(String location){
        driver.findElement(SearchLocationField).sendKeys(location);
    }

    public JobsPageHU clickSearchButton(){
        driver.findElement(SearchButton).click();
        return  new JobsPageHU(driver);
    }

    public DetailedSearchHU clickSearchDetailedButton(){
        driver.findElement(SearchDetailedButton).click();
        return  new DetailedSearchHU(driver);
    }

}
