import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MainPage {

    private final WebDriver driver;
    private final By blockTitleLocator = By.xpath("//h2[text()='Онлайн пополнение ' and text()='без комиссии']");
    private final By paymentLogotypeLocator = By.xpath("//*[@id='pay-section']//img");
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
        return driver.findElement(paymentLogotypeLocator).isDisplayed();
    }

    public int getPaymentSystemLogosCount() {
        List<WebElement> logos = driver.findElements(paymentLogotypeLocator);
        return logos.size();
    }

    public boolean isDetailsOfServiceLinkDisplayed() {
        return driver.findElement(detailsOfServiceLinkLocator).isDisplayed();
    }

    public ServiceDetailsPage clickServiceDetailsLink() {
        driver.findElement(detailsOfServiceLinkLocator).click();
        return new ServiceDetailsPage(driver);
    }
}
