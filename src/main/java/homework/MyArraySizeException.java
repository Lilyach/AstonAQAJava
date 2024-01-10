package homework;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Массив должен быть размером 4*4");
    }
}
