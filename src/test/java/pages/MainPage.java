package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;


public class MainPage extends BasePage {


    private final By blockTitleLocator = By.xpath("//h2[text()='Онлайн пополнение ' and text()='без комиссии']");
    private final By visaLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='Visa']");
    private final By verVisaLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='Verified By Visa']");
    private final By masterLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='MasterCard']");
    private final By masSecLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='MasterCard Secure Code']");
    private final By belLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='Белкарт']");
    private final By mirLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='МИР']");
    private final By detailsOfServiceLinkLocator = By.linkText("Подробнее о сервисе");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getBlockTitle() {
        return getDriver().findElement(blockTitleLocator).getText();
    }

    public boolean isBlockTitleDisplayed() {
        return getDriver().findElement(blockTitleLocator).isDisplayed();
    }

    public boolean isPaymentLogotypeDisplayed() {
        List<By> locators = Arrays.asList(visaLogoLocator, verVisaLogoLocator, masterLogoLocator, masSecLogoLocator, belLogoLocator, mirLogoLocator);
        for (By locator : locators) {
            if (getDriver().findElement(locator).isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean isDetailsOfServiceLinkDisplayed() {
        return getDriver().findElement(detailsOfServiceLinkLocator).isDisplayed();
    }

    public ServiceDetailsPage clickServiceDetailsLink() {
        getDriver().findElement(detailsOfServiceLinkLocator).click();
        return new ServiceDetailsPage(getDriver());
    }
}
