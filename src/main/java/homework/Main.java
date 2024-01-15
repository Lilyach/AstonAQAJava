package homework;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] colors = {"зеленый", "красный", "желтый", "синий", "белый", "красный", "черный", "серый", "белый", "зеленый"};
        Set<String> uniqueColors = new HashSet<>(List.of(colors));
        System.out.println("Список уникальных цветов: " + uniqueColors);
        Map<String, Integer> numberOfColors = new HashMap<>();
        for (String color : colors
        ) {
            numberOfColors.put(color, numberOfColors.getOrDefault(color, 0) + 1);
        }
        System.out.println("Частота встречаемости цветов: ");
        for (Map.Entry<String, Integer> item : numberOfColors.entrySet()
        ) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Каримов", "899991111");
        phoneBook.add("Маликова", "899635555");
        phoneBook.add("Маликова", "899358410");
        phoneBook.add("Арбузов", "899321489");
        phoneBook.add("Каримов", "899154786");
        System.out.println("Каримов: " + phoneBook.get("Каримов") + "\nМаликова: " + phoneBook.get("Маликова") + "\nАрбузов: " + phoneBook.get("Арбузов"));
    }
}