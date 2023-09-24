package dataTypes_ex;

import java.util.Scanner;

public class TriplesFromLatinLetters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //кои букви от азбуката трябва да съдържат моите тройки

        for (char letter1 = 'a'; letter1 < 'a' + n; letter1++) { //първия символ в тройката
            for (char letter2 = 'a'; letter2 < 'a' + n; letter2++) { //втория символ в тройката
                for (char letter3 = 'a'; letter3 < 'a' + n; letter3++) { //третия символ в тройката
                    //тройка: "{letter1}{letter2}{letter3}"
                    System.out.printf("%c%c%c%n", letter1, letter2, letter3);
                    //System.out.println("" + letter1 + letter2 + letter3);
                }
            }
        }
    }
}
