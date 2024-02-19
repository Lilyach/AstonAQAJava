package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WildberriesCartPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href,'25993220/')]//span[@class='good-info__good-name']")
    private WebElement teapotItemCart;
    @FindBy(xpath = "//a[contains(@href,'16154247/')]//span[@class='good-info__good-name']")
    private WebElement pastilaItemCart;
    @FindBy(xpath = "//a[contains(@href,'19252625/')]//span[@class='good-info__good-name']")
    private WebElement oxygenBleachItemCart;
    @FindBy(xpath = "//div[contains(@class, 'list-item__price-new') and contains(text(), '250')]")
    private WebElement teapotCartPrice;
    @FindBy(xpath = "//div[contains(@class, 'list-item__price-new') and contains(text(), '368')]")
    private WebElement pastilaCartPrice;
    @FindBy(xpath = "//div[contains(@class, 'list-item__price-new') and contains(text(), '271')]")
    private WebElement OxygenBleachCartPrice;
    @FindBy(xpath = "//p[@class='b-top__total line']/span[1]")
    private WebElement totalCartPrice;
    @FindBy(xpath = "//div[@class='b-top__count line']")
    private WebElement totalCartItems;

    public WildberriesCartPage(WebDriver driver) {
        super(driver);
    }

    public String getTeapotItemCart() {
        return teapotItemCart.getText();
    }

    public String getTeapotCartPrice() {
        return teapotCartPrice.getText();
    }

    public String getPastilaItemCart() {
        return pastilaItemCart.getText();
    }

    public String getPastilaCartPrice() {
        return pastilaCartPrice.getText();
    }

    public String getOxygenBleachItemCart() {
        return oxygenBleachItemCart.getText();
    }

    public String getOxygenBleachCartPrice() {
        return OxygenBleachCartPrice.getText();
    }

    public String getTotalCartPrice() {
        return totalCartPrice.getText();
    }

    public String getTotalCartItems() {
        return totalCartItems.getText();
    }
}
