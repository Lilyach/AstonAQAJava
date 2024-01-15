package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        phoneBook.computeIfAbsent(surname, s -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }

}
