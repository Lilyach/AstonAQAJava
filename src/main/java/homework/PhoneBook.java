package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(surname, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(surname, phoneNumbers);
    }

    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }

}
