package homework.task1;

public class Dog extends Animal {
    private String name;
    private static int dogCount = 0;

    public Dog(String name) {
        this.name = name;
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        String output = (distance <= 500) ? "Пес " + name + " пробежал" + distance + " м" : "Пес " + name + " не может пробежать такое расстояние";
        System.out.println(output);
    }

    @Override
    public void swim(int distance) {
        String result = (distance <= 10) ? "Пес " + name + " проплыл " + distance + " м" : "Пес " + name + " не может проплыть такое расстояние";
        System.out.println(result);
    }
}
