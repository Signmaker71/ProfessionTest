package ProfessionPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.interactions.Actions;
import utils.Methods;
import utils.FileUtils;
import utils.Popups;

public class JobsPageHU extends HomePageHU {
    private final By NEXT_PAGE_OF_JOBS_BUTTON = By.xpath("//*[contains(@class,'next btn')]");
    private final By JobsTitle = By.xpath("//*[@id=\"content\"]/div/a");
    private final By JOBS_COUNT = By.xpath("//*[@id=\"content\"]/div/div[1]/div[1]/div");
    private final By JOBS_ELEMENTS = By.xpath("//*[@class=\"job-cards\"]/li");
    private final By JOB_CARD_TITLE = By.xpath("./div[1]/div[1]/div[2]/div/h2/a");
    private final By JOB_CARD_COMPANY = By.xpath("./div[1]/div[1]/div[2]/div/div[1]/a");
    private final By JOB_CARD_ADDRESS = By.xpath("./div[1]/div[1]/div[2]/div/div[2]");
    private final By JOB_CARD_TEXT = By.xpath("./div[1]/div[2]/div[1]");
//*[@id="content"]/div/div/div[1]/ul/li[1]/div[1]/div[2]/div[1]

    FileUtils utils = new FileUtils();

    public JobsPageHU(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    Methods methods = new Methods(driver);
    Actions actions;

    public int getJobsCount() {
        String[] jobsCountString = driver.findElement(JOBS_COUNT).getText().split(" ");
        int jobsCount;
        try {
            jobsCount = Integer.parseInt(jobsCountString[0]);
        } catch (NumberFormatException e) {
            jobsCount = 0;
        }

        return jobsCount;
    }

    public JobsPageHU clickNextButton() {
        driver.findElement(NEXT_PAGE_OF_JOBS_BUTTON).click();
        return new JobsPageHU(driver);
    }

    public List<WebElement> getJobsCardsOnPage() {
        List<WebElement> JobsCardElements = driver.findElements(JOBS_ELEMENTS);
        List<String> jobs = new ArrayList<>();
        return JobsCardElements;
    }

    public int getNumberOfJobCards() throws InterruptedException {
        int result = 0;
        int cardsOnPage = 0;
        WebElement nextButton;
        actions = new Actions(driver);
        boolean thereIsNextPage = false;
        //Popups popUps = new Popups(driver);

        do {
            //Thread.sleep(1000);
            Popups.popupClose(driver);
            List<WebElement> JobsCardElements = driver.findElements(JOBS_ELEMENTS);
            cardsOnPage = JobsCardElements.size();
            result += cardsOnPage;

            try {
                nextButton = driver.findElement(NEXT_PAGE_OF_JOBS_BUTTON);
                actions.moveToElement(nextButton);
                if (nextButton.isDisplayed()) {
                    thereIsNextPage = true;

                    Methods.clickButton(driver, NEXT_PAGE_OF_JOBS_BUTTON);
                    //Thread.sleep(3000);

                } else thereIsNextPage = false;
            } catch (Exception e) {
                //System.out.println(e.getMessage());
                thereIsNextPage = false;
            }
            ;
        } while (thereIsNextPage);

        return result;
    }

    public int getNumberOfValidJobCards(String job) throws InterruptedException {
        int result = 0;
        int validCardsOnPage = 0;
        WebElement nextButton;
        actions = new Actions(driver);
        boolean thereIsNextPage = false;
        //Popups popUps = new Popups(driver);
        String cardTitle = "";
        String cardCompany = "";
        String cardText = "";
        String reportText = "";
        job = job.toLowerCase();
        do {
            Thread.sleep(1000);
            Popups.popupClose(driver);
            List<WebElement> JobsCardElements = driver.findElements(JOBS_ELEMENTS);

            for (WebElement card : JobsCardElements) {
                cardTitle = card.findElement(JOB_CARD_TITLE).getText().toLowerCase();
                cardCompany = card.findElement(JOB_CARD_COMPANY).getText().toLowerCase();
                cardText = card.findElement(JOB_CARD_TEXT).getText().toLowerCase(Locale.ROOT);
                if (cardTitle.contains(job) || cardText.contains(job) || cardCompany.contains(job)) {
                    result++;
                } else {
                    reportText += job + " is missing from this card:\n";
                    reportText += "Adverise ID: " + card.getAttribute("data-prof-id") + "\n";
                    reportText += "Title: " + cardTitle + "\n";
                    reportText += "Address: " + cardCompany + "\n";
                    reportText += "Text: " + cardText + "\n";
                    utils.generateReport("TC02", reportText);
                }
            }

            try {
                nextButton = driver.findElement(NEXT_PAGE_OF_JOBS_BUTTON);
                actions.moveToElement(nextButton);
                if (nextButton.isDisplayed()) {
                    thereIsNextPage = true;

                    Methods.clickButton(driver, NEXT_PAGE_OF_JOBS_BUTTON);

                } else thereIsNextPage = false;
            } catch (Exception e) {
                thereIsNextPage = false;
            }

        } while (thereIsNextPage);

        return result;
    }


}
