package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WildberriesMainPage extends BasePage {
    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@aria-label='Очистить поиск']")
    private WebElement searchInputClear;
    @FindBy(xpath = "//article[@data-nm-id='25993220']//a[@href='/lk/basket']")
    private WebElement teapotItem;
    @FindBy(xpath = "//article[@data-nm-id='16154247']//a[@href='/lk/basket']")
    private WebElement pastilaItem;
    @FindBy(xpath = "//article[@data-nm-id='19252625']//a[@href='/lk/basket']")
    private WebElement oxygenBleachItem;
    @FindBy(xpath = "//article[@data-nm-id='25993220']//span[contains (@class,'product-card__name')]")
    private WebElement teapotTitle;
    @FindBy(xpath = "//article[@data-nm-id='16154247']//span[contains (@class,'product-card__name')]")
    private WebElement pastilaTitle;
    @FindBy(xpath = "//article[@data-nm-id='19252625']//span[contains (@class,'product-card__name')]")
    private WebElement oxygenBleachTitle;
    @FindBy(xpath = "//a[@data-wba-header-name='Cart']")
    private WebElement cartButton;

    public WildberriesMainPage(WebDriver driver) {
        super(driver);
    }

    public WildberriesMainPage searchForItem(String itemName) {
        searchInput.click();
        searchInput.sendKeys(itemName, Keys.ENTER);
        return new WildberriesMainPage(getDriver());

    }

    public void clearSearchOutput() {
        searchInputClear.click();
    }

    public void addItemToCart(String itemName) {
        WebElement itemElement;
        switch (itemName) {
            case "чайник":
                itemElement = teapotItem;
                break;
            case "пастила":
                itemElement = pastilaItem;
                break;
            case "отбеливатель елизар":
                itemElement = oxygenBleachItem;
                break;
            default:
                throw new IllegalArgumentException("Unknown item: " + itemName);
        }
        getWait10().until(ExpectedConditions.visibilityOf(itemElement));
        itemElement.click();
    }

    public String getTeapotTitle() {
        return teapotTitle.getText();
    }

    public String getPastilaTitle() {
        return pastilaTitle.getText();
    }

    public String getOxygenBleachTitle() {
        return oxygenBleachTitle.getText();
    }

    public WildberriesCartPage clickCartButton() {
        getWait10().until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
        return new WildberriesCartPage(getDriver());
    }
}
