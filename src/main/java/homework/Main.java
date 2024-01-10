package homework;


public class Main {
    public static void main(String[] args) {
        String[][] array = {{"15", "7", "40", "6"}, {"1", "8", "95", "6"}, {"5", "8", "1", "68"}, {"5", "2", "0", "7"}};
        try {
            int sum = MyArray.transformArray(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка типа данных массива: " + e.getMessage());
        }
    }
}