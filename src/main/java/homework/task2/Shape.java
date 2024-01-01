package homework.task2;

public interface Shape {
    double calculatePerimeter();

    double calculateArea();

    String getFillColor();

    String getBorderColor();


    default void printCharacteristics(String shapeName, String fillColor, String borderColor) {
        System.out.printf("Характеристики %s:%nПериметр: %f%nПлощадь: %f%nЦвет фона: %s%nЦвет границы: %s%n%n", shapeName, calculatePerimeter(), calculateArea(), fillColor, borderColor);
    }
}
