import helpers.TestValues;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

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
    public void testCommunicationHeader() {
        OnlineRechargePage onlineRechargePage = new OnlineRechargePage(driver);
        String communicationServiceHeader = onlineRechargePage.communicationServiceSelect();
        Assertions.assertEquals("Услуги связи", communicationServiceHeader, "Название некорректно");
    }

    @Test
    public void testHomeInternetHeader() throws InterruptedException {
        OnlineRechargePage onlineRechargePage = new OnlineRechargePage(driver);
        String homeInternetHeader = onlineRechargePage.homeInternetSelect();
        Thread.sleep(7000);
        Assertions.assertEquals("Домашний интернет", homeInternetHeader, "Название некорректно");
    }

    @Test
    public void testInstalmentHeader() {
        OnlineRechargePage onlineRechargePage = new OnlineRechargePage(driver);
        String instalmentHeader = onlineRechargePage.instalmentSelect();
        Assertions.assertEquals("Рассрочка", instalmentHeader, "Название некорректно");
    }

    @Test
    public void testArrearsHeader() throws InterruptedException {
        OnlineRechargePage onlineRechargePage = new OnlineRechargePage(driver);
        String arrearsHeader = onlineRechargePage.arrearsSelect();
        Thread.sleep(5000);
        Assertions.assertEquals("Задолженность", arrearsHeader, "Название некорректно");
    }

    @Test
    public void testPaymentForm() {
        PhonePaymentPage phonePaymentPage = new PhonePaymentPage(driver);
        phonePaymentPage.fillPhonePayment("297777777", "200");
        Assertions.assertTrue(phonePaymentPage.isContinueButtonDisplayed(), "Кнопка 'Продолжить' не отображается");
        ResultPage resultPage = phonePaymentPage.clickContinueButton();
        resultPage.isPaymentWindowDisplayed();
        Assertions.assertTrue(resultPage.getPhoneNumber().contains(TestValues.EXPECTED_PHONE_NUMBER));
        Assertions.assertTrue(resultPage.isPaymentIconDisplayed(), "Иконки платежных систем не отображаются");
        Assertions.assertTrue(resultPage.getAmountOfMoney().contains(TestValues.EXPECTED_AMOUNT_OF_MONEY));
        Assertions.assertTrue(resultPage.getPaymentAmount().contains(TestValues.EXPECTED_PAYMENT_AMOUNT));
        Assertions.assertTrue(resultPage.getCardNumber().contains(TestValues.CARD_NUMBER_PLACEHOLDER));
        Assertions.assertTrue(resultPage.getExpiryDate().contains(TestValues.EXPIRE_DATE_PLACEHOLDER));
        Assertions.assertTrue(resultPage.getCvc().contains(TestValues.CVC_PLACEHOLDER));
        Assertions.assertTrue(resultPage.getCardHolderName().contains(TestValues.CARD_HOLDER_NAME_PLACEHOLDER));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
