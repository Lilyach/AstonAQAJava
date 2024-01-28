import homework.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {
    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(calculator.calculateFactorial(5), 120);
    }

    @Test
    public void testFactorialOfZeroNumber() {
        Assert.assertEquals(calculator.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Assert.expectThrows(IllegalArgumentException.class, () -> calculator.calculateFactorial(-1));
    }
}
