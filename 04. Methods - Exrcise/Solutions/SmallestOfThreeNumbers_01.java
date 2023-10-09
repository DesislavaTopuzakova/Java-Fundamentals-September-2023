package methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber =  Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());


        printSmallestNumber(firstNumber, secondNumber, thirdNumber);


    }

    //новите методи
    //метод, който отпечатва най-малкото от трите въведени числа
    public static void printSmallestNumber (int n1, int n2, int n3) {
        System.out.println(Math.min(Math.min(n1, n2), n3));
    }
}
