package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class ResultPage extends BasePage {
    @FindBy(xpath = "//p[contains(@class,'header__payment-info')]")
    private WebElement phoneNumberOutput;
    @FindBy(xpath = "//p[@class= 'header__payment-amount']")
    private WebElement amountOfMoneyOutPut;
    @FindBy(xpath = "//button[@class='colored disabled ng-star-inserted']")
    private WebElement paymentAmountButton;
    @FindBy(xpath = "//label[contains(@class, 'ng-tns-c47-1')]")
    private WebElement cardNumberInput;
    @FindBy(xpath = "//img[contains(@src,'mastercard-system')]")
    private WebElement mastercardIcon;
    @FindBy(xpath = "//img[contains(@src,'visa-system')]")
    private WebElement visaIcon;
    @FindBy(xpath = "//img[contains(@src,'belkart-system')]")
    private WebElement belIcon;
    @FindBy(xpath = "//img[contains(@src,'mir-system')]")
    private WebElement mirIcon;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c47-4')]")
    private WebElement expiryDateInput;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c47-5')]")
    private WebElement cvcInput;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c47-3')]")
    private WebElement cardHolderNameInput;


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement isPaymentWindowDisplayed() {
        WebElement iframe = getWait10().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        getDriver().switchTo().frame(iframe);
        return getWait10().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='app-wrapper__content']")));
    }

    public String getPhoneNumber() {
        return phoneNumberOutput.getText();
    }

    public String getAmountOfMoney() {
        return amountOfMoneyOutPut.getText();
    }

    public String getPaymentAmount() {
        return paymentAmountButton.getText();
    }

    public String getCardNumber() {
        return cardNumberInput.getText();
    }

    public String getExpiryDate() {
        return expiryDateInput.getText();
    }

    public String getCvc() {
        return cvcInput.getText();
    }

    public String getCardHolderName() {
        return cardHolderNameInput.getText();
    }

    public boolean isPaymentIconDisplayed() {
        List<WebElement> icons = Arrays.asList(mastercardIcon, visaIcon, belIcon, mirIcon);
        for (WebElement icon : icons) {
            if (icon.isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}
