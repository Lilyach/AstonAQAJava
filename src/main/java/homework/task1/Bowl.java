package homework.task1;

public class Bowl {
    private int amountOfFood;

    public Bowl(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            amountOfFood += amount;
            System.out.println("Добавлено " + amount + " еды в миску.");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды.");
        }
    }
}
