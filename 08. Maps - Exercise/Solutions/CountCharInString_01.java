package maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharInString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //запис: символ -> бр. срещания
        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();

        //input = "Desi".toCharArray() -> ['D', 'e', 's', 'i']
        for (char symbol : input.toCharArray()) {
            //1. проверка за интервал
            if (symbol == ' ') {
                continue;
            }
            //2. проверка дали съм срещала дадената буква
            //2.1. не сме срещали
            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 1);
            }
            //2.2. вече да сме срещали такъв символ
            else {
                int currentCount = symbolsCount.get(symbol); //текущ бр. срещания
                symbolsCount.put(symbol, currentCount + 1);
            }
        }

        //map: key (символ) -> value (бре. срещания)
        //символ -> бр. срещания
        //1 начин
        for (Map.Entry<Character, Integer> entry : symbolsCount.entrySet()) {
            //entry -> всеки един запис
            //entry.getKey() -> символ
            //entry.getValue() -> бр. срещания
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        //2 начин
        /*symbolsCount
                .entrySet()  //съвкупността от записи
                .forEach(entry ->  System.out.println(entry.getKey() + " -> " + entry.getValue()));*/

        //3 начин
        //symbolsCount.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
