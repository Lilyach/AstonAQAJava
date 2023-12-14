package homework;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printcolor();
        compareNumbers();
    }

    static void printThreeWords() {
        System.out.println("Orange \nBanana \nApple");
    }

    static void checkSumSign() {
        int a = 35;
        int b = -24;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    static void printcolor() {
        int value = 200;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a = 48;
        int b = 0;
        String result = a >= b ? "a >= b" : "a < b";
        System.out.println(result);
    }
}
