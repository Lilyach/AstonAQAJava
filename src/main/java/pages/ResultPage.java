package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends BasePage {
    @FindBy(xpath = "//*[@class= 'header__payment-info']")
    private WebElement phoneNumberOutput;
    @FindBy(xpath = "//*[@class= 'header__payment-amount']")
    private WebElement amountOfMoneyOutPut;
    @FindBy(xpath = "//button[@class='colored disabled ng-star-inserted']")
    private WebElement paymentAmountButton;

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
}
