import helpers.TestValues;
import org.junit.jupiter.api.*;
import pages.*;


public class MtsWebTest extends BaseTest {
    OnlineRechargePage onlineRechargePage = new OnlineRechargePage(driver);
    PhonePaymentPage phonePaymentPage = new PhonePaymentPage(driver);

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
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", serviceDetailsPage.getServiceDetailsAttribute(), "Ссылка не работает");
        serviceDetailsPage.clickMainPageBack();
    }

    @Test
    public void testCommunicationHeader() {
        String communicationServiceHeader = onlineRechargePage.communicationServiceSelect();
        Assertions.assertEquals("Услуги связи", communicationServiceHeader, "Название некорректно");
    }

    @Test
    public void testHomeInternetHeader() {
        String homeInternetHeader = onlineRechargePage.homeInternetSelect();
        Assertions.assertEquals("Домашний интернет", homeInternetHeader, "Название некорректно");
    }

    @Test
    public void testInstalmentHeader() {
        String instalmentHeader = onlineRechargePage.instalmentSelect();
        Assertions.assertEquals("Рассрочка", instalmentHeader, "Название некорректно");
    }

    @Test
    public void testArrearsHeader() {
        String arrearsHeader = onlineRechargePage.arrearsSelect();
        Assertions.assertEquals("Задолженность", arrearsHeader, "Название некорректно");
    }

    @Test
    public void testPaymentForm() {
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
}
