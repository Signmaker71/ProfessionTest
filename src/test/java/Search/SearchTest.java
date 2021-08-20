package Search;

import ProfessionPages.JobsPageHU;
import base.BaseProfessionTests;
import org.junit.jupiter.api.*;
import utils.FileUtils;
import utils.Methods;
import utils.Popups;


public class SearchTest extends BaseProfessionTests {

    private JobsPageHU jobsPageHU;
    FileUtils utils = new FileUtils();
    private String fileName = "User1RegistrableActive.txt";
    private String position = utils.userData(fileName).get("position");
    private  final String URL = "https://profession.hu/allasok/";

    // count and check elements and their contents
    @Test
    @DisplayName("TCJ01 Testing to count Job cards")
    public void testSimpleSearch() {
        driver.get(URL);

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


    // tested job card's title or text must contain the job's name
    // the location is not acceptable to contain the job's name
    @Test //
    @DisplayName("TCJ02 Testing to count Valid Job cards")


    public void testCardsContent() {
        driver.get(URL);
        //popups = new Popups(driver);
        System.out.println(driver.getCurrentUrl());
        jobsPageHU = new JobsPageHU(driver);
        Popups.popupClose(driver);
        jobsPageHU.fillSearchByKeywordField(position);
        jobsPageHU.clickSearchButton();

        int jobsCount = jobsPageHU.getJobsCount();
        int validJobsCount = jobsPageHU.getNumberOfValidJobCards(position);
        System.out.println("\nFounded " + jobsCount + " jobs in category: " + position);
        System.out.println("Valid jobs are " + validJobsCount + ". \n");
        Assertions.assertEquals(jobsCount, validJobsCount);
    }

}
