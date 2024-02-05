import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class MtsWebTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        WebElement cookieAcceptButton = driver.findElement(By.id("cookie-agree"));
        cookieAcceptButton.click();
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testBlockTitle() {
        String blockTitle = mainPage.getBlockTitle();
        Assertions.assertTrue(mainPage.isBlockTitleDisplayed(), "Название не отображается");
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", blockTitle, "Название некорректно");
    }

    @Test
    public void testPaymentLogotypes() {
        Assertions.assertTrue(mainPage.isPaymentLogotypeDisplayed(), "Логотипы платежных систем не отображаются");
    }

    @Test
    public void testServiceDetailsLink() {
        Assertions.assertTrue(mainPage.isDetailsOfServiceLinkDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");
        ServiceDetailsPage serviceDetailsPage = mainPage.clickServiceDetailsLink();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", serviceDetailsPage.getCurrentUrl(), "Ссылка не работает");
    }

    @Test
    public void testPaymentForm() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillPhoneNumber("297777777");
        paymentPage.enterPaymentAmount("200");
        Assertions.assertTrue(paymentPage.isContinueButtonDisplayed(), "Кнопка 'Продолжить' не отображается");
        ResultPage resultPage = paymentPage.clickContinueButton();
        Assertions.assertTrue(resultPage.isPaymentWindowDisplayed(), "Окно платежа не отображается");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
