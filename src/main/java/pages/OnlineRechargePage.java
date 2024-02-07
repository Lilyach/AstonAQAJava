package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OnlineRechargePage extends BasePage {
    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement serviceDropdown;

    @FindBy(xpath = "//p[text()='Домашний интернет']")
    private WebElement homeInternetHeader;
    @FindBy(xpath = "//p[text()='Рассрочка']")
    private WebElement instalmentHeader;
    @FindBy(xpath = "//p[text()='Задолженность']")
    private WebElement arrearsHeader;

    public OnlineRechargePage(WebDriver driver) {
        super(driver);
    }

    public String communicationServiceSelect() {
        serviceDropdown.click();
        return serviceDropdown.getText();
    }

    public String homeInternetSelect() {
        serviceDropdown.click();
        homeInternetHeader.click();
        return homeInternetHeader.getText();
    }

    public String instalmentSelect() {
        serviceDropdown.click();
        instalmentHeader.click();
        return serviceDropdown.getText();
    }

    public String arrearsSelect() {
        serviceDropdown.click();
        arrearsHeader.click();
        return arrearsHeader.getText();
    }
}
