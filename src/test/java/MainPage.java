import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {

    private final WebDriver driver;
    private final By blockTitleLocator = By.xpath("//h2[text()='Онлайн пополнение ' and text()='без комиссии']");
    private final By visaLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='Visa']");
    private final By verVisaLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='Verified By Visa']");
    private final By masterLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='MasterCard']");
    private final By masSecLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='MasterCard Secure Code']");
    private final By belLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='Белкарт']");
    private final By mirLogoLocator = By.xpath("//div[@id='pay-section']//img[@alt='МИР']");
    private final By detailsOfServiceLinkLocator = By.linkText("Подробнее о сервисе");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitleLocator).getText();
    }

    public boolean isBlockTitleDisplayed() {
        return driver.findElement(blockTitleLocator).isDisplayed();
    }

    public boolean isPaymentLogotypeDisplayed() {
        return driver.findElement(visaLogoLocator).isDisplayed() &
                driver.findElement(verVisaLogoLocator).isDisplayed() &
                driver.findElement(masterLogoLocator).isDisplayed() &
                driver.findElement(masSecLogoLocator).isDisplayed() &
                driver.findElement(belLogoLocator).isDisplayed() &
                driver.findElement(mirLogoLocator).isDisplayed();
    }

    public boolean isDetailsOfServiceLinkDisplayed() {
        return driver.findElement(detailsOfServiceLinkLocator).isDisplayed();
    }

    public ServiceDetailsPage clickServiceDetailsLink() {
        driver.findElement(detailsOfServiceLinkLocator).click();
        return new ServiceDetailsPage(driver);
    }
}
