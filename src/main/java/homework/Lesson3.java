package homework;


import java.util.Arrays;

public class Lesson3 {
    public boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public void printNumberType(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " положительное");
        } else {
            System.out.println("Число " + number + " отрицательное");
        }
    }

    public boolean isNegative(int a) {
        return a < 0;
    }

    public void printStringMultipleTimes(String string, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(string);

        }
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return true;
        }
    }

    public void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }

        System.out.print("Modified array: [ ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }

    public void createAndFillArray(int[] array1) {
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 1;
        }

        System.out.print("Array: [ ");
        for (int value : array1) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }

    public void multiplyByTwoArray(int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] < 6) {
                array2[i] *= 2;
            }
        }
        System.out.print("Modified array: [ ");
        for (int number : array2) {
            System.out.print(number + " ");
        }
        System.out.println("]");
    }

    public void fillDiagonal(int[][] array3) {
        int n = array3.length;
        for (int i = 0; i < n; i++) {
            array3[i][i] = 1;
        }
        for (int[] ints : array3) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public void createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }
}




