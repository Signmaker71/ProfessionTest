package professionPageTest;

import ProfessionPages.JobsPageHU;
import base.BaseProfessionTests;
import org.junit.jupiter.api.*;
import utils.FileUtils;
import utils.Methods;
import utils.Popups;

public class SearchTest extends BaseProfessionTests {

    // PROPERTIES
    private JobsPageHU jobsPageHU;
    FileUtils utils = new FileUtils();
    // CONSTANSES
    private String fileName = "User1RegistrableActive.txt";
    private String position = utils.userData(fileName).get("position");
    private  final String URL = "https://profession.hu/allasok/";

    // TESTS

    // count and check elements and their contents
    // Requirements 04, 05
    @Test
    @DisplayName("TCP04 Keresési eredmények számának ellenőrzése")
    public void testSimpleSearch() {
        driver.get(URL);

        jobsPageHU = new JobsPageHU(driver);
        //Popups.popupClose(driver);
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


    // Testing details of search results
    // tested job card's title or text must contain the job's name
    // the location is not acceptable to contain the job's name
    // Requirements 04, 05, 10
    @Test //
    @DisplayName("TCP05 Keresési eredmények tartalmának ellenőrzése1")
    public void testCardsContent01() {
        driver.get(URL);
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
    // Testing details of search results
    // Requirements 04, 10
    @Test //
    @DisplayName("TCP06 Keresési eredmények tartalmának ellenőrzése2")
    public void testCardsContent02() {
        driver.get(URL);
        System.out.println(driver.getCurrentUrl());
        jobsPageHU = new JobsPageHU(driver);
        Popups.popupClose(driver);
        position = "Nagykovácsi";
        jobsPageHU.fillSearchByKeywordField(position);
        jobsPageHU.clickSearchButton();

        int jobsCount = jobsPageHU.getJobsCount();
        int validJobsCount = jobsPageHU.getNumberOfValidJobCards(position);
        System.out.println("\nFounded " + jobsCount + " jobs in category: " + position);
        System.out.println("Valid jobs are " + validJobsCount + ". \n");
        Assertions.assertEquals(jobsCount, validJobsCount);
    }


}
