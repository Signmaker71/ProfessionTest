package OlimpiaGamePagesV2;

import org.openqa.selenium.WebDriver;

public class Q052DontRemember {

    private WebDriver webDriver;

    public Q052DontRemember(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Q031HaveAJob clickHaveJobButton() {
        return new Q031HaveAJob(webDriver);
    }
    public Q032DontHave clickHaveNoJobButton() {
        return new Q032DontHave(webDriver);
    }

}
