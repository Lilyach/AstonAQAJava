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
    public void testHomeInternetHeader() {
        OnlineRechargePage onlineRechargePage = new OnlineRechargePage(driver);
        String homeInternetHeader = onlineRechargePage.homeInternetSelect();
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
    public void testPaymentForm() throws InterruptedException {
        PhonePaymentPage phonePaymentPage = new PhonePaymentPage(driver);
        phonePaymentPage.fillPhonePayment("297777777", "200");
        Assertions.assertTrue(phonePaymentPage.isContinueButtonDisplayed(), "Кнопка 'Продолжить' не отображается");
        ResultPage resultPage = phonePaymentPage.clickContinueButton();
        resultPage.isPaymentWindowDisplayed();
        String actualPhoneNumber = resultPage.getPhoneNumber();
        String expectedPhoneNumber = "Оплата: Услуги связи Номер:375297777777";
        Assertions.assertEquals(expectedPhoneNumber, actualPhoneNumber, "Номер некорректный");
        String actualAmountOfMoney = resultPage.getAmountOfMoney();
        String expectedAmountOfMoney = "200.00 BYN";
        Assertions.assertEquals(expectedAmountOfMoney, actualAmountOfMoney, "Сумма некорректная");
        String actualPaymentAmount = resultPage.getPaymentAmount();
        String expectedPaymentAmount = "Оплатить 200.00 BYN";
        Assertions.assertEquals(expectedPaymentAmount, actualPaymentAmount, "Сумма некорректная");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
