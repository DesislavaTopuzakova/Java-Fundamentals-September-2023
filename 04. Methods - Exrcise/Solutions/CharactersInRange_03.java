package methods;

import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0); //"a".charAt(0) -> 'a'
        char secondSymbol = scanner.nextLine().charAt(0);

        printSymbolsInRange(firstSymbol, secondSymbol);
    }

    //метод, който отпечатва символите в даден диапазон
    public static void printSymbolsInRange (char firstSymbol, char secondSymbol) {
        //започваме от символа с по-малък аски код
        if (firstSymbol < secondSymbol) {
            //започваме от firstSymbol -> символите в (firstSymbol; secondSymbol)
            for (char symbol = (char) (firstSymbol + 1); symbol < secondSymbol; symbol++) {
                System.out.print(symbol + " ");
            }

        } else { //firstSymbol >= secondSymbol
            //започваме от secondSymbol -> символите в (secondSymbol; firstSymbol)
            for (char symbol = (char) (secondSymbol + 1); symbol < firstSymbol; symbol++) {
                System.out.print(symbol + " ");
            }
        }
    }
}
