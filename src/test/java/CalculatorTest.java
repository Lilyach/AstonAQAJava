import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest extends BaseTest {
    CalculatorPage calculatorPage = new CalculatorPage(driver);

    @Test
    public void testCalculatorOperations() {

        calculatorPage.performAddition(5, 5);
        assertEquals("10", calculatorPage.getResult());

        calculatorPage.performSubtraction(9, 4);
        assertEquals("5", calculatorPage.getResult());

        calculatorPage.performMultiplication(2, 3);
        assertEquals("6", calculatorPage.getResult());

        calculatorPage.performDivision(8, 2);
        assertEquals("4", calculatorPage.getResult());
    }
}
