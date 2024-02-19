package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ServiceDetailsPage extends BasePage {
    @FindBy(xpath = "//span[@class='breadcrumbs__link']")
    private WebElement serviceDetailsAttribute;
    @FindBy(xpath = "//span[@itemprop='name']")
    private WebElement mainPageBack;

    public ServiceDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getServiceDetailsAttribute() {
        return serviceDetailsAttribute.getText();
    }

    public MainPage clickMainPageBack() {
        mainPageBack.click();
        return new MainPage(getDriver());
    }
}
