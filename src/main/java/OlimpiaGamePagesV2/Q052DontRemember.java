package OlimpiaGamePagesV2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q052DontRemember {

    private WebDriver driver;
    WebDriverWait wait;

    public Q052DontRemember(WebDriver driver) {
        this.driver = driver;
    }

    public Q031HaveAJob clickHaveJobButton() {
        return new Q031HaveAJob(driver);
    }
    public Q032DontHave clickHaveNoJobButton() {
        return new Q032DontHave(driver);
    }

}
