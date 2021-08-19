package Search;

import ProfessionPages.HomePageHU;
import ProfessionPages.JobsPageHU;
import base.BaseTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FileUtils;
import utils.Methods;
import utils.Popups;

import java.io.ByteArrayInputStream;


public class SearchTest extends BaseTests {

    private JobsPageHU jobsPageHU;

    FileUtils utils = new FileUtils();
    String fileName = "User1RegistrableActive.txt";
    String position = utils.userData(fileName).get("position");


    // count and check elements and their contents
    @Test
    @DisplayName("TCJ01 Testing to count Job cards")

    public void testSimpleSearch() {
        driver.get("https://profession.hu/allasok/");

        jobsPageHU = new JobsPageHU(driver);
        Popups.popupClose(driver);
        jobsPageHU.fillSearchByKeywordField(position);
        jobsPageHU.clickSearchButton();

        int expextedJobsCount = jobsPageHU.getJobsCount();
        int actualJobsCount = 0;
        try {
            actualJobsCount = jobsPageHU.getNumberOfJobCards();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Methods.TakeScreenshot(driver);
        Assertions.assertEquals(expextedJobsCount, actualJobsCount);
    }

    @Test //
    @DisplayName("TCJ02 Testing to count Valid Job cards")
    // tested job card's title or text must contain the job's name
    // the location is not acceptable to contain the job's name

    public void testCardsContent() throws InterruptedException {
        driver.get("https://profession.hu/allasok/");
        //popups = new Popups(driver);
        String job = utils.userData("User1RegistrableActive.txt").get("position");

        System.out.println(driver.getCurrentUrl());
        jobsPageHU = new JobsPageHU(driver);
        Popups.popupClose(driver);
        jobsPageHU.fillSearchByKeywordField(job);
        jobsPageHU.clickSearchButton();

        int jobsCount = jobsPageHU.getJobsCount();
        int validJobsCount = jobsPageHU.getNumberOfValidJobCards(job);
        System.out.println("\nFounded " + jobsCount + " jobs in category: " + job);
        System.out.println("Valid jobs are " + validJobsCount + ". \n");
        Assertions.assertEquals(jobsCount, validJobsCount);
    }

}
