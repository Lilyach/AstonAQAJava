package homework.task1;

public class Cat extends Animal {
    String name;
    private boolean satiety;
    private static int catCount = 0;

    public Cat(String name) {
        super();
        this.name = name;
        catCount++;
        satiety = false;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isSatiety() {
        return satiety;
    }

    @Override
    public void run(int distance) {
        String output = (distance <= 200) ? "Кот " + name + " пробежал " + distance + " м" : "Кот " + name + " не может пробежать такое расстояние";
        System.out.println(output);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот " + name + " не умеет плавать");
    }

    public void eat(int amountOfFood) {
        if (amountOfFood > 0) {
            satiety = true;
            System.out.println("Кот " + name + " поел и наелся.");
        } else {
            System.out.println("В миске недостаточно еды для кота.");
        }
    }
}
