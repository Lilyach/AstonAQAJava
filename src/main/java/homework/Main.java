package homework;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] colors = {"зеленый", "красный", "желтый", "синий", "белый", "красный", "черный", "серый", "белый", "зеленый"};
        List<String> uniqueColors = Arrays.stream(colors)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Список уникальных цветов: " + uniqueColors);
        Map<String, Long> numberOfColors = Arrays.stream(colors)
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println("Частота встречаемости цветов: ");
        for (Map.Entry<String, Long> item : numberOfColors.entrySet()
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