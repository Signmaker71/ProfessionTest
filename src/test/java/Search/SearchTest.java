package Search;

import ProfessionPages.HomePageHU;
import ProfessionPages.JobsPageHU;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FileUtils;
import utils.Popups;


public class SearchTest extends FileUtils{

    private HomePageHU homePage;
    private JobsPageHU jobsPageHU;
    public WebDriver siteDriver;
    private WebDriverWait wait;
    FileUtils utils = new FileUtils();
    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        siteDriver = new ChromeDriver(/*options*/);

        siteDriver.manage().window().maximize();

        siteDriver.get("https://profession.hu/allasok/");

    }

    // count and check elements and their contents

    @Test
    @DisplayName("TCJ01 Testing to count Job cards")

    public void testSimpleSearch() {
        Popups popups = new Popups(siteDriver);

        System.out.println(siteDriver.getCurrentUrl());
        JobsPageHU jobsPageHU = new JobsPageHU(siteDriver);
        popups.popupClose();
        jobsPageHU.fillSearchByKeywordField(utils.userData("user1.txt").get("position"));
        jobsPageHU.clickSearchButton();

        int expextedJobsCount = jobsPageHU.getJobsCount();
        int actualJobsCount = 0;
        try {
            actualJobsCount = jobsPageHU.getNumberOfJobCards();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(expextedJobsCount,actualJobsCount);

    }

    @Test
    @DisplayName("TCJ02 Testing to count Valid Job cards")
    // tested job card's title or text must contain the job's name
    // the location is not acceptable to contain the job's name

    public void testCardsContent() throws InterruptedException {
        Popups popups = new Popups(siteDriver);
        String job = utils.userData("user1.txt").get("position");

        System.out.println(siteDriver.getCurrentUrl());
        JobsPageHU jobsPageHU = new JobsPageHU(siteDriver);
        popups.popupClose();
        jobsPageHU.fillSearchByKeywordField(job);
        jobsPageHU.clickSearchButton();

        int jobsCount = jobsPageHU.getJobsCount();
        int validJobsCount = jobsPageHU.getNumberOfValidJobCards(job);
        System.out.println("\nFounded " + jobsCount + " jobs in category: " + job);
        System.out.println("Valid jobs are " + validJobsCount + ". \n");
        Assertions.assertEquals(jobsCount, validJobsCount);
    }

    @AfterEach
    public void tearDown() {
         siteDriver.quit();
    }
}
