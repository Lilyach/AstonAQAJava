package homework;


public class Main {
    public static void main(String[] args) {

        Lesson3 result = new Lesson3();
        int[] array2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.println(result.isSumInRange(7, 20));

        result.printNumberType(0);

        System.out.println(result.isNegative(-3));

        result.printStringMultipleTimes("Happy New Year 2024! ", 2);

        System.out.println(result.isLeapYear(2024));

        result.invertArray(new int[]{1, 0, 1, 0, 0});

        result.createAndFillArray(new int[100]);

        result.multiplyByTwoArray(array2);

        result.fillDiagonal(new int[4][4]);

        result.createArray(5,6);

    }
}