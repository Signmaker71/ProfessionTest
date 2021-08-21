package ProfessionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Methods;
import utils.Popups;


public class CV_Page {
    // CONSTANSES
    private final String URL_HOME = "https://www.profession.hu/";
    private final By PHONE_ON_PI_CARD = By.xpath("//*[@id=\"cvdb-summary-personalInformation\"]/div/div[2]/div[2]/div/div[2]/div[3]/span");
    private final By EDIT_PI_CARD_BUTTON = By.xpath("//*[@id=\"edit_personal_information\"]/i");
    private final By PHONENUMBER_FIELD = By.id("phone_div");
    private final By SAVE_BUTTON = By.xpath("//*[@id=\"cvdb_personal_information_form\"]/div/div[8]/div[1]/input");

    // PROPERTIES
    WebDriver driver;

    // CONSTRUCTOR
    public CV_Page(WebDriver driver) {
        this.driver = driver;
    }


    // METHODS

    // get the phone number from the personal data's card
    public String getCardsPhoneNumber() {
        return Methods.waitForElement(driver, PHONE_ON_PI_CARD).getText();
    }

    // cear the phone number data
    public String clearCardsPhoneNumber() {
        if (!getCardsPhoneNumber().equals("nem megadott")) {
            Popups.popupClose(driver);

            String originalPhoneNumberOnPiCard = getCardsPhoneNumber();
            Methods.waitForElement(driver, EDIT_PI_CARD_BUTTON).click();
            Methods.fillTextToField(driver, PHONENUMBER_FIELD, "");
            Methods.waitForElementClickable(driver, SAVE_BUTTON).click();
            System.out.println("Phone field was not empty, it contained:\n"
                    + originalPhoneNumberOnPiCard + ", but it has been cleared.");
        }
        Popups.popupClose(driver);

        return getCardsPhoneNumber();
    }

    // modify the phone number
    public String setCardsPhoneNumber(String phoneNumber) {
        Methods.waitForElement(driver, EDIT_PI_CARD_BUTTON).click();
        Popups.popupClose(driver);
        Methods.fillTextToField(driver, PHONENUMBER_FIELD, phoneNumber);
        Methods.waitForElementClickable(driver, SAVE_BUTTON).click();
        String phoneNumberOnPiCard = getCardsPhoneNumber();
        System.out.println("Phone field has been changed to: " + phoneNumberOnPiCard);
        Popups.popupClose(driver);

        return phoneNumberOnPiCard;
    }
    // phone number formatting
    public static String formattedPhoneNumber(String phoneNumber) {
        String formattedPhoneNumber =phoneNumber.substring(0,3)+" ("
                + phoneNumber.substring(3,5) + ") "
                + phoneNumber.substring(5,8) + " "
                + phoneNumber.substring(8,12);
        return formattedPhoneNumber;
    }

    // printing the details of the data modifying
    public void printActionDetails(String x, String phoneNumberOnPI_Card) {
        System.out.println("The Phonenumber has changed to:   " + phoneNumberOnPI_Card + "\n");
        System.out.println(x);
        System.out.println("Phone field now contains:" + phoneNumberOnPI_Card);
    }
}
