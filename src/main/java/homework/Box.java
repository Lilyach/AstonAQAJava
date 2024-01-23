package homework;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();

    public void addFruits(T fruit) {
        fruits.add(fruit);
    }

    public float getWeightOfFruits() {
        if (fruits.isEmpty()) {
            return 0f;
        }
        float weightOfFruits = fruits.get(0) instanceof Apple ? 1.0f : 1.5f;
        return fruits.size() * weightOfFruits;
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeightOfFruits() - otherBox.getWeightOfFruits()) < 0.0001;
    }

    public void transferFruits(Box<? super T> otherBox) {
        if (this == otherBox) {
            return;
        }
        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
