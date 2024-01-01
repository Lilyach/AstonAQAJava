package homework.task2;


public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(6, "белый", "черный");
        circle.printCharacteristics("круг", circle.getFillColor(), circle.getBorderColor());

        Rectangle rectangle = new Rectangle(5, 7, "синий", "красный");
        rectangle.printCharacteristics("прямоугольник", rectangle.getFillColor(), rectangle.getBorderColor());

        Triangle triangle = new Triangle(5, 6, 7, "желтый", "оранжевый");
        triangle.printCharacteristics("треугольник", triangle.getFillColor(), triangle.getBorderColor());
    }
}

