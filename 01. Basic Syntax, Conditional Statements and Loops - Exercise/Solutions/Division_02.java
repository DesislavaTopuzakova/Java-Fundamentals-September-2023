package basics_recap;

import java.util.Scanner;

public class Division_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        //2, 3, 6, 7, 10
        if (number % 10 == 0) {
            //числото се дели на 10
            System.out.println("The number is divisible by 10");
        } else if (number % 7 == 0) {
            //числото се дели на 7
            System.out.println("The number is divisible by 7");
        } else if (number % 6 == 0) {
            //числото се дели на 6
            System.out.println("The number is divisible by 6");
        } else if (number % 3 == 0) {
            //числото се дели на 3
            System.out.println("The number is divisible by 3");
        } else if (number % 2 == 0) {
            //числото се дели на 2 -> четно
            System.out.println("The number is divisible by 2");
        } else {
            System.out.println("Not divisible");
        }

    }
}
