package OlimpiaGamePagesV2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q010ChoosePrice {
    private WebDriver webDriver;

    public Q010ChoosePrice(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    // footer divs one by one
/*  public By winnersLisLink = By.xpath("/html/body/footer/div/div/div[1]/a[1]");
    public By gamePolicyLink = By.xpath("/html/body/footer/div/div/div[1]/a[2]");
    public By gameDataManagementLink = By.xpath("/html/body/footer/div/div/div[1]/a[3]");
    public By dataManagementLink = By.xpath("/html/body/footer/div/div/div[1]/a[4]");
    public By cookieManagementLink = By.xpath("/html/body/footer/div/div/div[1]/a[5]");  */

    //  footer menu
    public final By FOOTER_MENU = By.xpath("/html/body/footer/div/div/div[1]/a");

    // choose-prize
    public By prizeTescoLink = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[1]/div[1]/div[1]/div");
    public By prizeDecathlonLink = By.xpath("//*[@id=\"first\"]/div[1]/div/div/div[3]/div[1]/div[1]/div[2]/div");
    public By nextButtonLink = By.id("check-voucher");

    public boolean clickButton(String selection) {
        boolean result = false;

        if (selection.toLowerCase().contains("tes")) {
            webDriver.findElement(prizeTescoLink).click();
            result = true;
        } else if (selection.toLowerCase().contains("dec")) {
            webDriver.findElement(prizeDecathlonLink).click();
            result = true;
        }
        return result;
    }

    public Q020HasJob clickNextButton() {
        webDriver.findElement(nextButtonLink).click();
        return new Q020HasJob(webDriver);
    }

    public boolean clickFooterMenu(String selection) {
        List<WebElement> menu = webDriver.findElements(FOOTER_MENU);
        boolean result = false;
        for (WebElement link : menu) {
            if (link.getText().contains(selection)) {
                link.click();
                result = true;
            }
        }
        return result;
    }


}
