import homework.FactorialCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {
    @Test
    public void testCalculateFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();
        Assertions.assertEquals(24, calculator.calculateFactorial(4));
        Assertions.assertEquals(1, calculator.calculateFactorial(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculateFactorial(-1));
    }
}
