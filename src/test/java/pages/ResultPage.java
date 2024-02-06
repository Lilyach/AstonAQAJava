package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultPage extends BasePage {

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement paymentFrame;
    @FindBy(xpath = "//div[@class='app-wrapper__content']")
    private WebElement paymentWindow;

    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPaymentWindowDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOf(paymentWindow)).isDisplayed();

        getDriver().switchTo().defaultContent();
        return isDisplayed;
    }
}
