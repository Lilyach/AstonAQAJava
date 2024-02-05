package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PaymentPage extends BasePage {

    private final By phoneNumberFieldLocator = By.xpath("//*[@id='connection-phone']");
    private final By paymentAmountFieldLocator = By.xpath("//*[@id='connection-sum']");
    private final By continueButtonLocator = By.xpath("//*[@id='pay-connection']/button");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillPhoneNumber(String phoneNumber) {
        getDriver().findElement(phoneNumberFieldLocator).click();
        getDriver().findElement(phoneNumberFieldLocator).sendKeys(phoneNumber);
    }

    public void enterPaymentAmount(String amountOfMoney) {
        getDriver().findElement(paymentAmountFieldLocator).click();
        getDriver().findElement(paymentAmountFieldLocator).sendKeys(amountOfMoney);
    }

    public boolean isContinueButtonDisplayed() {
        return getDriver().findElement(continueButtonLocator).isDisplayed();
    }

    public ResultPage clickContinueButton() {
        getDriver().findElement(continueButtonLocator).click();
        return new ResultPage(getDriver());
    }
}
