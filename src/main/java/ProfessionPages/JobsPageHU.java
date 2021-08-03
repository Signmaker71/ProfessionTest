package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobsPageHU extends PageHeaderMenuHU {
    private WebDriver webDriver;
    private By NextButton = By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/span[5]/a");
    private By JobsTitle = By.xpath("//*[@id=\"content\"]/div/a");
    private By JobsCount = By.xpath("//*[@id=\"content\"]/div/div[1]/div[1]/div/text()");

    public JobsPageHU(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getJobsTitle(){
        String jobsTitle;
        String jobsCount;
        jobsTitle = webDriver.findElement(JobsTitle).getText();
        jobsCount = webDriver.findElement(JobsCount).getText();
        return jobsTitle;
    }
    public String getJobsCount(){
        String jobsCount;
        jobsCount = webDriver.findElement(JobsCount).getText();
        return jobsCount;
    }

    public JobsPageHU clickNextButton(){
        webDriver.findElement(NextButton).click();
        return  new JobsPageHU(webDriver);
    }

}
