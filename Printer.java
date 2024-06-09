// class Answer {  
//     public static StringBuilder answer(String QUERY, String PARAMS){
      
//         // Напишите свое решение ниже

//         // Обработка строки JSON вручную
//         String prepare = PARAMS.replace("{", "").replace("}", "").replace("\"", "");
//         String[] paramsArray = prepare.split(",");

//         String name = paramsArray[0].split(":")[1];
//         String country = paramsArray[1].split(":")[1];
//         String city = paramsArray[2].split(":")[1];
//         String age = paramsArray[3].split(":")[1];

//         StringBuilder result = new StringBuilder(QUERY);

//         boolean firstCondition = true;

//         if (!name.equals("null")) {
//             result.append("name='").append(name).append("'");
//             firstCondition = false;
//         }
//         if (!country.equals("null")) {
//             if (!firstCondition) {
//                 result.append(" and ");
//             }
//             result.append("country='").append(country).append("'");
//             firstCondition = false;
//         }
//         if (!city.equals("null")) {
//             if (!firstCondition) {
//                 result.append(" and ");
//             }
//             result.append("city='").append(city).append("'");
//             firstCondition = false;
//         }
//         if (!age.equals("null")) {
//             if (!firstCondition) {
//                 result.append(" and ");
//             }
//             result.append("age=").append(age);
//         }

//         return result;
//     }
// }




// // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
// public class Printer{ 
// 	public static void main(String[] args) { 
//       String QUERY = "";
//       String PARAMS = "";
      
//       if (args.length == 0) {
//         // При отправке кода на Выполнение, вы можете варьировать эти параметры
//         QUERY = "select * from students where ";
// 	    PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
//       }
//       else{
//         QUERY = args[0];
//         PARAMS = args[1];
//       }     
      
//       Answer ans = new Answer();      
//       System.out.println(ans.answer(QUERY, PARAMS));
// 	}
// }






// import java.io.File;
// import java.io.FileWriter;
// import java.io.FileReader;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.util.Arrays;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// class BubbleSort {
//     private static File log;
//     private static FileWriter fileWriter;

//     public static void sort(int[] mas) {
//         log = new File("log.txt");

//         try {
//             // Очищаем файл перед началом сортировки
//             fileWriter = new FileWriter(log, false); // false для очистки файла
//             fileWriter.close();

//             // Открываем файл для добавления
//             fileWriter = new FileWriter(log, true); // true для добавления в конец файла

//             boolean swapped;
//             int n = mas.length;

//             for (int i = 0; i < n - 1; i++) {
//                 swapped = false;

//                 for (int j = 0; j < n - 1 - i; j++) {
//                     if (mas[j] > mas[j + 1]) {
//                         // Swap mas[j] and mas[j + 1]
//                         int temp = mas[j];
//                         mas[j] = mas[j + 1];
//                         mas[j + 1] = temp;
//                         swapped = true;
//                     }
//                 }

//                 // Log the current state of the array
//                 logArrayState(mas);

//                 // If no two elements were swapped in the inner loop, then break
//                 if (!swapped) {
//                     break;
//                 }
//             }

//             fileWriter.close();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static void logArrayState(int[] arr) {
//         String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
//         String arrayString = Arrays.toString(arr);

//         try {
//             fileWriter.write(timeStamp + " " + arrayString + System.lineSeparator());
//             fileWriter.flush();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
// public class Printer {
//     public static void main(String[] args) {
//         int[] arr = {};

//         if (args.length == 0) {
//             // При отправке кода на Выполнение, вы можете варьировать эти параметры
//             arr = new int[]{9, 3, 4, 8, 2, };
//         } else {
//             arr = Arrays.stream(args[0].split(", "))
//                     .mapToInt(Integer::parseInt)
//                     .toArray();
//         }

//         BubbleSort ans = new BubbleSort();
//         ans.sort(arr);

//         try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

// import java.util.Arrays;
// import java.util.ArrayList;

// class Answer {
//     public static ArrayList<Integer> removeEvenNumbers(Integer[] arr) {
//         // Создаем список ArrayList и заполняем его данными из массива
//         ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

//         // Удаляем четные числа из списка
//         list.removeIf(n -> n % 2 == 0);

//         // Возвращаем результирующий список
//         return list;
//     }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
// public class Printer { 
//     public static void main(String[] args) { 
//         Integer[] arr = {};

//         if (args.length == 0) {
//             // При отправке кода на Выполнение, вы можете варьировать эти параметры
//             arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//         } else {
//             arr = Arrays.stream(args[0].split(", "))
//                         .map(Integer::parseInt)
//                         .toArray(Integer[]::new);
//         }

//         Answer ans = new Answer();
//         ArrayList<Integer> result = ans.removeEvenNumbers(arr);
//         System.out.println(result);
//     }
// }



// import java.util.ArrayDeque;
// import java.util.Deque;

// class Calculator {
//     private Deque<Double> stack;

//     public Calculator() {
//         stack = new ArrayDeque<>();
//     }

//     public double calculate(char op, int a, int b) {
//         double result = 0;
//         switch (op) {
//             case '+':
//                 result = a + b;
//                 break;
//             case '-':
//                 result = a - b;
//                 break;
//             case '*':
//                 result = a * b;
//                 break;
//             case '/':
//                 result = (double) a / b;
//                 break;
//             case '<':
//                 if (stack.size() < 2) {
//                     throw new IllegalStateException("No previous result to undo");
//                 }
//                 stack.pop();
//                 result = stack.pop();
//                 stack.push(result);
//                 break;
//             default:
//                 throw new IllegalArgumentException("Invalid operator: " + op);
//         }
//         stack.push(result);
//         return result;
//     }
// }
// // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
// public class Printer {
//     public static void main(String[] args) {
//         int a, b, c, d;
//         char op, op2, undo;

//         if (args.length == 0) {
//         // При отправке кода на Выполнение, вы можете варьировать эти параметры
//             a = 3;
//             op = '+';
//             b = 7;
//             c = 4;
//             op2 = '+';
//             d = 7;
//             undo = '<';
//         } else {
//             a = Integer.parseInt(args[0]);
//             op = args[1].charAt(0);
//             b = Integer.parseInt(args[2]);
//             c = Integer.parseInt(args[3]);
//             op2 = args[4].charAt(0);
//             d = Integer.parseInt(args[5]);
//             undo = args[6].charAt(0);
//         }

//         Calculator calculator = new Calculator();
//         double result = calculator.calculate(op, a, b);
//         System.out.println(result);
//         double result2 = calculator.calculate(op2, c, d);
//         System.out.println(result2);
//         double prevResult = calculator.calculate(undo, 0, 0);
//         System.out.println(prevResult);
//     }
// }


// import java.util.HashMap;

// class NamesCounter {
//     private HashMap<String, Integer> names = new HashMap<>();

//     // Метод для добавления имени в HashMap
//     public void addName(String name) {
//         // Проверяем, существует ли уже такое имя в HashMap
//         if (names.containsKey(name)) {
//             // Если имя уже есть, увеличиваем его количество на 1
//             int count = names.get(name);
//             names.put(name, count + 1);
//         } else {
//             // Если имени нет, добавляем его в HashMap с количеством 1
//             names.put(name, 1);
//         }
//     }

//     // Метод для вывода содержимого HashMap
//     public void showNamesOccurrences() {
//         // Перебираем все пары "имя - количество" в HashMap
//         for (String name : names.keySet()) {
//             int count = names.get(name);
//             System.out.println(name + "=" + count);
//         }
//     }
// }

// // Не удаляйте и не меняйте метод Main!
// public class Printer {
//     public static void main(String[] args) {
//         String name1;
//         String name2;
//         String name3;
//         String name4;
//         String name5;

//         if (args.length == 0) {
//             name1 = "Elena";
//             name2 = "Elena";
//             name3 = "Elena";
//             name4 = "Elena";
//             name5 = "Ivan";
//         } else {
//             name1 = args[0];
//             name2 = args[1];
//             name3 = args[2];
//             name4 = args[3];
//             name5 = args[4];
//         }
//         NamesCounter namesCounter = new NamesCounter();

//         namesCounter.addName(name1);
//         namesCounter.addName(name2);
//         namesCounter.addName(name3);
//         namesCounter.addName(name4);
//         namesCounter.addName(name5);

//         namesCounter.showNamesOccurrences();
//     }
// }



// import java.util.HashMap;

// class NamesCounter {
//     private HashMap<String, Integer> names = new HashMap<>();

//     // Метод для добавления имени в HashMap
//     public void addName(String name) {
//         // Проверяем, существует ли уже такое имя в HashMap
//         if (names.containsKey(name)) {
//             // Если имя уже есть, увеличиваем его количество на 1
//             int count = names.get(name);
//             names.put(name, count + 1);
//         } else {
//             // Если имени нет, добавляем его в HashMap с количеством 1
//             names.put(name, 1);
//         }
//     }

//     // Метод для вывода содержимого HashMap
//     public void showNamesOccurrences() {
//         // Выводим HashMap напрямую
//         System.out.println(names);
//     }
// }

// // Не удаляйте и не меняйте метод Main!
// public class Printer {
//     public static void main(String[] args) {
//         String name1;
//         String name2;
//         String name3;
//         String name4;
//         String name5;

//         if (args.length == 0) {
//             name1 = "Elena";
//             name2 = "Elena";
//             name3 = "Elena";
//             name4 = "Elena";
//             name5 = "Ivan";
//         } else {
//             name1 = args[0];
//             name2 = args[1];
//             name3 = args[2];
//             name4 = args[3];
//             name5 = args[4];
//         }
//         NamesCounter namesCounter = new NamesCounter();

//         namesCounter.addName(name1);
//         namesCounter.addName(name2);
//         namesCounter.addName(name3);
//         namesCounter.addName(name4);
//         namesCounter.addName(name5);

//         namesCounter.showNamesOccurrences();
//     }
// }



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


public class Printer {
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