package textProcessing;

import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //входни данни
        String input = scanner.nextLine(); //"George Peter"
        String [] texts = input.split(" "); //["George", "Peter"]

        String firstText = texts[0]; // "George"
        String secondText = texts[1]; //"Peter"

        printSumCharacters(firstText, secondText);


    }

    public static void printSumCharacters (String firstText, String secondText) {
        //кой е по-дългия текст
        int maxLength = Math.max(firstText.length(), secondText.length()); //дължина на по-дългия текст -> 6
        //кой е по-късия текст
        int minLength = Math.min(firstText.length(), secondText.length()); //дължина на по-късия текст -> 5

        int sum = 0;
        //love -> length 4 -> [0; 3]
        //SoftUni -> length 7 -> [0; 6]
        //обхождаме до по-късия текст
        for (int position = 0; position <= minLength - 1; position++) {
            sum += (firstText.charAt(position) * secondText.charAt(position));
        }


        //?? имаме ли символи, които не сме обходили
        //1. двата текста са еднакви
        if (firstText.length() == secondText.length()) {
            System.out.println(sum);
        }
        //2. първия текст е по-дълъг
        else if (maxLength == firstText.length()) {
            //Georgе
            //обходя останалите символи
            for (int position = minLength; position <= firstText.length() - 1; position++) {
                sum += firstText.charAt(position);
            }
            System.out.println(sum);
        }
        //3. втория текст е по-дълъг
        else {
            //обходя останалите символи
            for (int position = minLength; position <= secondText.length() - 1; position++) {
                sum += secondText.charAt(position);
            }
            System.out.println(sum);
        }

    }
}
