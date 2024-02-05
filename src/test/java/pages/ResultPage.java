package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ResultPage extends BasePage {

    private final By paymentFrameLocator = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By paymentWindowLocator = By.xpath("//div[@class='app-wrapper__content']");

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaymentWindowDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrameLocator));
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentWindowLocator)).isDisplayed();

        getDriver().switchTo().defaultContent();
        return isDisplayed;
    }
}
