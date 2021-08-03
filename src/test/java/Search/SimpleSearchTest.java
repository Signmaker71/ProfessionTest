package Search;

import ProfessionPages.JobsPageHU;
import ProfessionPages.HomePageHU;
import base.BaseTests;
import org.junit.jupiter.api.Test;


public class SimpleSearchTest extends BaseTests {

    private HomePageHU homePage;
    private JobsPageHU jobsPageHU;

    @Test
    public void testSsimpleSearch() throws InterruptedException {
        homePage.fillSearchByKeywordField(userData.get("position"));
        jobsPageHU = homePage.clickSearchButton();
        //while ()
    }
}
