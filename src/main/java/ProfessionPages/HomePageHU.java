package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHU extends PageHeaderMenuHU {

    private WebDriver webDriver;

    public HomePageHU(WebDriver webDriver) {
        super();
    }
    public  By SearchByKeywordField = By.id("header_keyword");
    public  By SearchLocationField = By.id("header_location");
    public  By SearchButton = By.id("search-bar-search-button");
    public  By SearchDetailedButton = By.id("tour_det_search");


    public void fillSearchByKeywordField(String position){
        webDriver.findElement(SearchByKeywordField).sendKeys(position);
    }

    public void fillSearchLocationField(String location){
        webDriver.findElement(SearchLocationField).sendKeys(location);
    }

    public JobsPageHU clickSearchButton(){
        webDriver.findElement(SearchButton).click();
        return  new JobsPageHU(webDriver);
    }

    public DetailedSearchHU clickSearchDetailedButton(){
        webDriver.findElement(SearchDetailedButton).click();
        return  new DetailedSearchHU(webDriver);
    }

}
