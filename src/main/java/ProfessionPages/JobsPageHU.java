package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import utils.Methods;
import utils.FileUtils;
import utils.Popups;
import utils.Report;

public class JobsPageHU extends HomePageHU {

    // CONSTANSES
    private final By NEXT_PAGE_OF_JOBS_BUTTON = By.xpath("//*[contains(@class,'next btn')]");
    private final By JOBS_TITLE = By.xpath("//*[@id=\"content\"]/div/a");
    private final By JOBS_COUNT = By.xpath("//*[@id=\"content\"]/div/div[1]/div[1]/div");
    private final By JOBS_ELEMENTS = By.xpath("//*[@class=\"job-cards\"]/li");
    private final By JOB_CARD_TITLE = By.xpath("./div[1]/div[1]/div[2]/div/h2/a");
    private final By JOB_CARD_COMPANY = By.xpath("./div[1]/div[1]/div[2]/div/div[1]/a");
    private final By JOB_CARD_ADDRESS = By.xpath("./div[1]/div[1]/div[2]/div/div[2]");
    private final By JOB_CARD_TEXT = By.xpath("./div[1]/div[2]/div[1]");

    // PROPERTIES
    //FileUtils utils = new FileUtils();
    Actions actions;

    // CONSTRUCTOR
    public JobsPageHU(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // METHODS

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
        Methods.clickButton(driver, NEXT_PAGE_OF_JOBS_BUTTON);
        return new JobsPageHU(driver);
    }


    public int getNumberOfJobCards() {
        int result = 0;
        int cardsOnPage = 0;
        WebElement nextButton;
        actions = new Actions(driver);
        boolean thereIsNextPage = false;

        do {
            Popups.popupClose(driver);
            List<WebElement> JobsCardElements = driver.findElements(JOBS_ELEMENTS);
            cardsOnPage = JobsCardElements.size();
            result += cardsOnPage;

            try {
                nextButton = Methods.waitForElement(driver, NEXT_PAGE_OF_JOBS_BUTTON);
                Popups.popupClose(driver);
                Methods.scrollDown(driver);
                actions.moveToElement(nextButton);
                if (nextButton.isDisplayed()) {
                    thereIsNextPage = true;
                    Methods.waitForElementClickable(driver, NEXT_PAGE_OF_JOBS_BUTTON);
                    Methods.TakeScreenshot(driver);
                    Methods.clickButton(driver, NEXT_PAGE_OF_JOBS_BUTTON);
                    Methods.scrollDown(driver);

                } else thereIsNextPage = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                thereIsNextPage = false;
            }
            ;
        } while (thereIsNextPage);

        return result;
    }

    public int getNumberOfValidJobCards(String job) {
        int result = 0;
        WebElement nextButton;
        actions = new Actions(driver);
        boolean thereIsNextPage = false;
        String cardTitle;
        String advertiseID;
        String cardCompany;
        String cardText;
        String reportText = "";
        job = job.toLowerCase();
        do {
            Popups.popupClose(driver);
            List<WebElement> JobsCardElements = driver.findElements(JOBS_ELEMENTS);

            for (WebElement card : JobsCardElements) {
                cardTitle = card.findElement(JOB_CARD_TITLE).getText();
                advertiseID = card.getAttribute("data-prof-id");
                cardCompany = card.findElement(JOB_CARD_COMPANY).getText();
                cardText = card.findElement(JOB_CARD_TEXT).getText();

                System.out.println(cardTitle + "    Adverise ID: " + advertiseID);
                System.out.println(cardCompany);
                System.out.println(cardText + "\n");
                if (cardTitle.toLowerCase().contains(job) || cardText.toLowerCase().contains(job) || cardCompany.toLowerCase().contains(job)) {
                    result++;
                } else {
                    reportText += job + " is missing from this card:\n";
                    reportText += "Adverise ID: " + card.getAttribute("data-prof-id") + "\n";
                    reportText += "Title: " + cardTitle + "\n";
                    reportText += "Address: " + cardCompany + "\n";
                    reportText += "Text: " + cardText + "\n";
                    System.out.println(reportText);

                    Report.generateReport("TCP04", reportText);
                }
            }

            try {
                nextButton = Methods.waitForElement(driver, NEXT_PAGE_OF_JOBS_BUTTON);
                actions.moveToElement(nextButton);

                if (nextButton.isDisplayed()) {
                    thereIsNextPage = true;
                    Methods.waitForElementClickable(driver, NEXT_PAGE_OF_JOBS_BUTTON).click();
                } else thereIsNextPage = false;
            } catch (Exception e) {
                thereIsNextPage = false;
            }
        } while (thereIsNextPage);

        return result;
    }
}
