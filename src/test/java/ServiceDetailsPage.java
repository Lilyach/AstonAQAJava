import org.openqa.selenium.WebDriver;

public class ServiceDetailsPage {
    private final WebDriver driver;

    public ServiceDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
