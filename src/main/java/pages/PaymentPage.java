package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage extends BasePage {
    @FindBy(xpath = "//*[@id='connection-phone']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//*[@id='connection-sum']")
    private WebElement paymentAmountField;
    @FindBy(xpath = "//*[@id='pay-connection']/button")
    private WebElement continueButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillPhoneNumber(String phoneNumber) {
        phoneNumberField.click();
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterPaymentAmount(String amountOfMoney) {
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