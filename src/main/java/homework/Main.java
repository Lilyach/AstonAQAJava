package homework;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(8);
        long countOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Количество четных чисел в ряду " + numbers + ": " + countOfEvenNumbers);

        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");
        long countOfHigh = collection.stream()
                .filter(s -> s.equals("High"))
                .count();
        System.out.println("Количество High: " + countOfHigh);

        String firstElement = collection.stream()
                .findFirst()
                .orElse("0");
        System.out.println("Первый элемент в коллекции: " + firstElement);

        String lastElement = collection.stream()
                .reduce(((first, second) -> second))
                .orElse("0");
        System.out.println("Последний элемент в коллекции: " + lastElement);

        List<String> collectionF = Arrays.asList("f10", "f15", "f2", "f4", "f4");

        String[] sortedArray = collectionF.stream()
                .sorted()
                .toArray(String[]::new);

        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));

        Students students = new Students();
        double averageAgeOfMan = students.getAverageAgeOfMan();
        System.out.println("Средний возраст студентов мужского пола: " + averageAgeOfMan);
        System.out.println("Студенты, кому грозит получение повестки в этом году:");
        students.printStudentsForMilitaryService();

        List<String> filteredLogins = LoginFilter.filterLoginsStartingWithF();

        System.out.println("Логины, начинающиеся на 'f':");
        filteredLogins.forEach(System.out::println);
    }

    static List<Integer> generateRandomNumbers(int i) {
        Random random = new Random();
        return random.ints(i, 1, 100)
                .boxed()
                .collect(Collectors.toList());
    }
}

