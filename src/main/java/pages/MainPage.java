package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;


public class MainPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Онлайн пополнение ' and text()='без комиссии']")
    private WebElement blockTitle;
    @FindBy(xpath = "//div[@id='pay-section']//img[@alt='Visa']")
    private WebElement visaLogo;
    @FindBy(xpath = "//div[@id='pay-section']//img[@alt='Verified By Visa']")
    private WebElement verVisaLogo;
    @FindBy(xpath = "//div[@id='pay-section']//img[@alt='MasterCard']")
    private WebElement masterLogo;
    @FindBy(xpath = "//div[@id='pay-section']//img[@alt='MasterCard Secure Code']")
    private WebElement masterSecLogo;
    @FindBy(xpath = "//div[@id='pay-section']//img[@alt='Белкарт']")
    private WebElement belLogo;
    @FindBy(xpath = "//div[@id='pay-section']//img[@alt='МИР']")
    private WebElement mirLogo;
    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement detailsOfServiceLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getBlockTitle() {
        return blockTitle.getText();
    }

    public boolean isBlockTitleDisplayed() {
        return blockTitle.isDisplayed();
    }

    public boolean isPaymentLogotypeDisplayed() {
        List<WebElement> logotypes = Arrays.asList(visaLogo, verVisaLogo, masterLogo, masterSecLogo, belLogo, mirLogo);
        for (WebElement logotype : logotypes) {
            if (logotype.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean isDetailsOfServiceLinkDisplayed() {
        return detailsOfServiceLink.isDisplayed();
    }

    public ServiceDetailsPage clickServiceDetailsLink() {
        detailsOfServiceLink.click();
        return new ServiceDetailsPage(getDriver());
    }
}
