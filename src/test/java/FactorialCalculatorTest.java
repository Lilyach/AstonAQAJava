import homework.FactorialCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {
    private final FactorialCalculator calculator = new FactorialCalculator();
    @Test
    public void testFactorialOfPositiveNumber() {
        Assertions.assertEquals(24, calculator.calculateFactorial(4));
    }
    @Test
    public void testFactorialOfZero() {
        Assertions.assertEquals(1, calculator.calculateFactorial(0));
    }
    @Test
    public void testFactorialOfNegativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculateFactorial(-1));
    }
}
