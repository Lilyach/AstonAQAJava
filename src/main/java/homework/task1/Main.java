package homework.task1;


public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бозик");
        Dog dog2 = new Dog("Филя");
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Васька");
        cats[1] = new Cat("Пельмень");
        cats[2] = new Cat("Рыжик");
        Bowl bowl = new Bowl(5);

        dog1.run(600);
        dog2.swim(5);
        cats[0].swim(14);
        cats[1].run(5);
        cats[2].run(1000);

        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество животных: " + Animal.getAnimalCount());
        bowl.addFood(7);

        for (Cat cat : cats) {
            cat.eat(4);
        }

        for (Cat cat : cats) {
            System.out.println(cat.isSatiety() ? cat.name + " сытый" : cat.name + " голодный");
        }
    }
}
