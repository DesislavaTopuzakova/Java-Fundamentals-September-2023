package textProcessing;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //входни данни
        String input = scanner.nextLine(); //"P34562Z q2576f   H456z"
        String[] codes = input.split("\\s+"); //["P34562Z", "q2576f", "H456z"]

        double sum = 0; //сума от модифицираните числа на всички кодове
        for (String code : codes) {
            //code: "{буква}{число}{буква}"
            //1. модифицирам числото спрямо буквите
            double modifiedNumber = getModifiedNumber(code)  ;//модифицирано число
            //2. сумирам
            sum += modifiedNumber;
        }

        System.out.printf("%.2f", sum);
    }

    //върне модифицираното число от кода
    private static double getModifiedNumber(String code) {
        //code: "{буква}{число}{буква}" => "H456z"
        char letterBefore = code.charAt(0); //'H' -> буква преди числото
        char letterAfter = code.charAt(code.length() - 1); //'z'
        double number = Double.parseDouble(code.replace(letterBefore, ' ') // " 456z"
                                                .replace(letterAfter, ' ') // " 456 "
                                                .trim()); //"456" -> parseDouble -> 456

        //модификация спрямо буквата преди числото -> letterBefore
        if (Character.isUpperCase(letterBefore)) {
            //главна буква -> A(65) до Z(90)
            int positionUpperLetter = (int) letterBefore - 64; //позицията на буквата в азбуката
            number /= positionUpperLetter;
            //number = number / positionUpperLetter;
        } else {
            //малка буква -> a(97) до z (122)
            int positionLowerLetter = (int) letterBefore - 96; //позицията на буквата в азбуката
            number *= positionLowerLetter;
            //number = number * positionLowerLetter;
        }

        //модификация на число спрямо буквата след него -> letterAfter
        if (Character.isUpperCase(letterAfter)) {
            //главна буква -> A(65) до Z(90)
            int positionUpperLetter = (int) letterAfter - 64; //позицията на буквата в азбуката
            number -= positionUpperLetter;
            //number = number - positionUpperLetter;
        } else {
            //малка буква -> a(97) до z (122)
            int positionLowerLetter = (int) letterAfter - 96; //позицията на буквата в азбуката
            number += positionLowerLetter;
            //number = number + positionLowerLetter;
        }

        return number;
    }
}
