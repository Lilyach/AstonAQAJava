package homework;


public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 4; i++) {
            appleBox.addFruits(new Apple());
        }

        for (int i = 0; i < 5; i++) {
            orangeBox.addFruits(new Orange());
        }

        System.out.println("Вес коробки с яблоками: " + appleBox.getWeightOfFruits());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeightOfFruits());

        Box<Apple> otherAppleBox = new Box<>();
        System.out.println("Сравнение коробки с яблоками и другой коробкой с яблоками: " + appleBox.compare(otherAppleBox));
        System.out.println("Сравнение коробки с яблоками и коробки с апельсинами: " + appleBox.compare(orangeBox));

        Box<Apple> newAppleBox = new Box<>();
        appleBox.transferFruits(newAppleBox);
        System.out.println("Вес новой коробки с яблоками после пересыпания: " + newAppleBox.getWeightOfFruits());
        System.out.println("Вес старой коробки с яблоками после пересыпания: " + appleBox.getWeightOfFruits());
    }
}