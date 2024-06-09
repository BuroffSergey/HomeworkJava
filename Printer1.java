import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    // Метод для добавления контакта в телефонную книгу
    public void addContact(String name, String phoneNumber) {
        // Проверяем, существует ли уже такое имя в телефонной книге
        if (phoneBook.containsKey(name)) {
            // Если имя уже есть, добавляем новый номер телефона
            phoneBook.get(name).add(phoneNumber);
        } else {
            // Если имени нет, создаем новую запись с номером телефона
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для вывода отсортированного списка контактов
    public void printSortedContacts() {
        // Сортируем контакты по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort(Comparator.comparingInt(e -> ((Entry<String, List<String>>) e).getValue().size()).reversed());

        // Выводим отсортированные контакты
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


public class Printer1 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем контакты в телефонную книгу
        phoneBook.addContact("Ivan", "123-456-789");
        phoneBook.addContact("Elena", "987-654-321");
        phoneBook.addContact("Ivan", "111-111-111");
        phoneBook.addContact("Elena", "222-222-222");
        phoneBook.addContact("Oleg", "333-333-333");
        phoneBook.addContact("Sergey", "111-222-333");
        phoneBook.addContact("Sergey", "123-333-333");
        phoneBook.addContact("Sergey", "333-333-111");

        // Выводим отсортированный список контактов
        phoneBook.printSortedContacts();
    }
}