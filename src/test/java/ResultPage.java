import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ResultPage {
    private final WebDriver driver;
    private final By paymentFrameLocator = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By paymentWindowLocator = By.xpath("//div[@class='app-wrapper__content']");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPaymentWindowDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrameLocator));
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentWindowLocator)).isDisplayed();

        driver.switchTo().defaultContent();
        return isDisplayed;
    }
}
