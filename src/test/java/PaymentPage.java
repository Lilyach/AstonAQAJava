import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PaymentPage {
    private final WebDriver driver;
    private final By phoneNumberFieldLocator = By.xpath("//*[@id='connection-phone']");
    private final By paymentAmountFieldLocator = By.xpath("//*[@id='connection-sum']");
    private final By continueButtonLocator = By.xpath("//*[@id='pay-connection']/button");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberFieldLocator).click();
        driver.findElement(phoneNumberFieldLocator).sendKeys(phoneNumber);
    }

    public void enterPaymentAmount(String amountOfMoney) {
        driver.findElement(paymentAmountFieldLocator).click();
        driver.findElement(paymentAmountFieldLocator).sendKeys(amountOfMoney);
    }

    public boolean isContinueButtonDisplayed() {
        return driver.findElement(continueButtonLocator).isDisplayed();
    }

    public ResultPage clickContinueButton() {
        driver.findElement(continueButtonLocator).click();
        return new ResultPage(driver);
    }
}
