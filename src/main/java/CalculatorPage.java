import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorPage {

    private final AppiumDriver<MobileElement> driver;

    public CalculatorPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void performAddition(int num1, int num2) {
        driver.findElementById("digit_" + num1).click();
        driver.findElementByAccessibilityId("сложить").click();
        driver.findElementById("digit_" + num2).click();
        driver.findElementByAccessibilityId("равно").click();
    }

    public void performSubtraction(int num1, int num2) {
        driver.findElementById("digit_" + num1).click();
        driver.findElementByAccessibilityId("вычесть").click();
        driver.findElementById("digit_" + num2).click();
        driver.findElementByAccessibilityId("равно").click();
    }

    public void performMultiplication(int num1, int num2) {
        driver.findElementById("digit_" + num1).click();
        driver.findElementByAccessibilityId("умножение").click();
        driver.findElementById("digit_" + num2).click();
        driver.findElementByAccessibilityId("равно").click();
    }

    public void performDivision(int num1, int num2) {
        driver.findElementById("digit_" + num1).click();
        driver.findElementByAccessibilityId("разделить").click();
        driver.findElementById("digit_" + num2).click();
        driver.findElementByAccessibilityId("равно").click();
    }

    public String getResult() {
        MobileElement resultElement = driver.findElementById("result_final");
        resultElement.click();
        return resultElement.getText();
    }
}
