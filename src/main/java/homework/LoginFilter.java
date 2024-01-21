package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoginFilter {
    public static List<String> filterLoginsStartingWithF() {
        List<String> logins = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логины (для завершения введите пустую строку):");
        while (true) {
            String login = scanner.nextLine().trim();

            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }
        List<String> filteredLogins = logins.stream()
                .filter(login -> login.startsWith("f"))
                .collect(Collectors.toList());
        return filteredLogins;
    }
}
