import helpers.TestValues;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;


public class WildberriesTest {
    private static WebDriver driver;
    private static WildberriesMainPage wildberriesMainPage;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wildberries.ru/");
        wildberriesMainPage = new WildberriesMainPage(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testPaymentForm() throws InterruptedException {
        Thread.sleep(5000);
        wildberriesMainPage.searchForItem("чайник")
                .addItemToCart("чайник");
        Assertions.assertTrue(wildberriesMainPage.getTeapotTitle().contains(TestValues.EXPECTED_TEAPOT_TITLE), "Название некорректно");
        wildberriesMainPage.clearSearchOutput();
        wildberriesMainPage.searchForItem("пастила")
                .addItemToCart("пастила");
        Assertions.assertTrue(wildberriesMainPage.getPastilaTitle().contains(TestValues.EXPECTED_PASTILA_TITLE), "Название некорректно");
        wildberriesMainPage.clearSearchOutput();
        wildberriesMainPage.searchForItem("отбеливатель елизар")
                .addItemToCart("отбеливатель елизар");
        Assertions.assertTrue(wildberriesMainPage.getOxygenBleachTitle().contains(TestValues.EXPECTED_OXYGEN_BLEACH_TITLE), "Название некорректно");
        wildberriesMainPage.clickCartButton();

        WildberriesCartPage wildberriesCartPage = new WildberriesCartPage(driver);
        Assertions.assertEquals(TestValues.EXPECTED_TEAPOT_TITLE, wildberriesCartPage.getTeapotItemCart(), "Название некорректно");
        Assertions.assertTrue(wildberriesCartPage.getTeapotCartPrice().contains(TestValues.EXPECTED_TEAPOT_PRICE), "Цена некорректная");
        Assertions.assertEquals(TestValues.EXPECTED_PASTILA_TITLE, wildberriesCartPage.getPastilaItemCart(), "Название некорректно");
        Assertions.assertTrue(wildberriesCartPage.getPastilaCartPrice().contains(TestValues.EXPECTED_PASTILA_PRICE), "Цена некорректная");
        Assertions.assertEquals(TestValues.EXPECTED_OXYGEN_BLEACH_TITLE, wildberriesCartPage.getOxygenBleachItemCart(), "Название некорректно");
        Assertions.assertTrue(wildberriesCartPage.getOxygenBleachCartPrice().contains(TestValues.EXPECTED_OXYGEN_BLEACH_PRICE), "Цена некорректная");
        Assertions.assertTrue(wildberriesCartPage.getTotalCartItems().contains("3 шт"), "Название некорректно");
        Assertions.assertTrue(wildberriesCartPage.getTotalCartPrice().contains(TestValues.EXPECTED_TOTAL_PRICE), "Общая стоимость товаров некорректная");

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
