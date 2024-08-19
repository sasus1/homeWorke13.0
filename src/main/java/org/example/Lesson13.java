package org.example;
import java.util.HashMap;
public class Lesson13 {
    private static String analyzedData = " Регулярно регулировать конечно сложно, но очень нужно зебры в черно- белую полоску встречаются реже зебр в бело- черную полоску посчитать всех зЕбр в прайде может любой человек Это не такая уж и сложная задача.";
    private static final String format = "|%1$-40.38s|%2$-30.28s|\n";
    private static final HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        analyzedData = analyzedData.replaceAll("[^A-Za-zА-ЯЁа-яё0-9 ]", " ").toLowerCase();
        analyzedData = analyzedData.replaceAll("[\\s]{2,}", " ");
        String[] regularArray = analyzedData.split(" ");
        System.out.println("Текст имеет " + regularArray.length + " слов.");
        for (String s : regularArray) {
            hashMap.putIfAbsent(s, 0);
            hashMap.put(s, hashMap.get(s) + 1);
        }
        System.out.println(" Результат");
        System.out.println("_________________________________________________________________________");
        System.out.format(format, "         слово / фраза", " Количество повторений");
        System.out.println("=========================================================================");
        hashMap.entrySet().stream().sorted(HashMap.Entry.<String, Integer>comparingByValue().reversed()).forEach(stringIntegerEntry -> {
            String k = stringIntegerEntry.getKey();
            Integer v = stringIntegerEntry.getValue();
            System.out.format(format, " " + k + " ", "   " + +v + " раз.");
        });
        System.out.println("-------------------------------------------------------------------------");

        PhoneBook pB = new PhoneBook();
        // заполняем справочник данными
        System.out.println("Задание №2 телефонный справочник");
        pB.add("Петров", "+7 (960) 222-22-22");
        pB.add("Иванов", "+7 (960) 444-44-44");
        pB.add("Сидоров", "+7 (960) 555-55-55");
        pB.add("Смирнов", "+7 (960) 666-66-66");
        pB.add("Петров", "+7 (960) 777-77-77");
        pB.add("Иванов", "+7 (960) 888-88-88");
        pB.add("Сидоров", "+7 (960) 999-99-99");
        pB.add("Петров", "+7 (960) 333-33-33");
        pB.get("Петров");
        pB.get("Иванов");
        pB.get("Сидоров");
    }
}