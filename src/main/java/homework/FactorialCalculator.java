package homework;

import java.util.stream.IntStream;

public class FactorialCalculator {
    public int calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        return IntStream.rangeClosed(1, n)
                .reduce(1, (i, j) -> i * j);
    }
}
