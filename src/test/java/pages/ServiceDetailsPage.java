package pages;

import org.openqa.selenium.WebDriver;


public class ServiceDetailsPage extends BasePage {

    public ServiceDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
