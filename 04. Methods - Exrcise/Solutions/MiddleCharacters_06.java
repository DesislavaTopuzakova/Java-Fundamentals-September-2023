package methods;

import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        printMiddleCharacter(text);

    }

    //метод, който принтира средния символ
    public static void printMiddleCharacter (String text) {
        int length = text.length();

        if (length % 2 != 0) {
            //нечетна дължина -> 1 среден символ
            /*String text = "aString"; //7 символа -> r (3 позиция)
            String text1 = "Pesho"; //5 символа -> s (2 позиция)
            String text2 = "Pes"; //3 символа -> e (1 позиция)*/

            int indexOfMiddleCharacter = length / 2;
            //позицията на средния символ при нечетен брой символи
            System.out.println(text.charAt(indexOfMiddleCharacter));
        }
        else {
            //четна дължина -> 2 средни символа
            /*String text = "Desi";    //4 символа -> e (1 позиция) s (2 позиция)
              String text1 = "tables"; //6 символа -> b (2 позиция) l (3 позиция) */
            int indexFirstMiddleCharacter = length / 2 - 1;
            int indexSecondMiddleCharacter = length / 2;
            System.out.print(text.charAt(indexFirstMiddleCharacter));
            System.out.print(text.charAt(indexSecondMiddleCharacter));
        }
    }

}
