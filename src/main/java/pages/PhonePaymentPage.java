package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PhonePaymentPage extends BasePage {
    @FindBy(xpath = "//*[@id='connection-phone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id='connection-sum']")
    private WebElement paymentAmountField;
    @FindBy(xpath = "//*[@id='pay-connection']/button")
    private WebElement continueButton;

    public PhonePaymentPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPaymentAmountField() {
        return paymentAmountField;
    }

    public WebElement getPhoneNumberField() {
        return phoneNumberField;
    }

    public void fillPhonePayment(String phoneNumber, String amountOfMoney) {
        phoneNumberField.click();
        phoneNumberField.sendKeys(phoneNumber);
        paymentAmountField.click();
        paymentAmountField.sendKeys(amountOfMoney);
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();
    }

    public ResultPage clickContinueButton() {
        continueButton.click();
        return new ResultPage(getDriver());
    }
}
