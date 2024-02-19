package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class OnlineRechargePage extends BasePage {
    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement serviceDropdown;

    @FindBy(xpath = "//li[2]//p[ @class='select__option']")
    private WebElement homeInternetHeader;
    @FindBy(xpath = "//li[3]//p[ @class='select__option']")
    private WebElement instalmentHeader;
    @FindBy(xpath = "//li[4]//p[ @class='select__option']")
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
        getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[2]//p[ @class='select__option']")));
        homeInternetHeader.click();
        return homeInternetHeader.getText();
    }

    public String instalmentSelect() {
        serviceDropdown.click();
        getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[3]//p[ @class='select__option']")));
        instalmentHeader.click();
        return serviceDropdown.getText();
    }

    public String arrearsSelect() {
        serviceDropdown.click();
        getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='select__item'][3]//p")));
        arrearsHeader.click();
        return arrearsHeader.getText();
    }
}
