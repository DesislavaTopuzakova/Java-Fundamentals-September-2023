package arrays;

import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //нечетен ред от конзолата (1, 3, 5, 7,...)
        //първо число -> първи масив, второ число -> втория масив

        //четен ред от конзолата (2, 4, 6, 8,...)
        //първо число -> втори масив, второ число -> първи масив

        int rows = Integer.parseInt(scanner.nextLine()); //брой на редовете с числа
        int [] firstArray = new int[rows];
        int [] secondArray = new int[rows];

        for (int row = 1; row <= rows; row++) {
            String input =  scanner.nextLine(); //"2 5"
            String[] numbers = input.split(" ");  //"2 5".split(" ") -> ["2", "5"]
            int number1 = Integer.parseInt(numbers[0]); //"2" -> parse -> 2
            int number2 = Integer.parseInt(numbers[1]); //"5" -> parse -> 5

            if (row % 2 != 0) {
                //нечетен ред
                //number1 -> firstArray
                firstArray[row - 1] = number1;
                //number2 -> secondArray
                secondArray[row - 1] = number2;
            } else {
                //четен ред
                //number1 -> secondArray
                secondArray[row - 1] = number1;
                //number2 -> firstArray
                firstArray[row - 1] = number2;
            }

        }

        //отпечатваме масивите
        for (int number : firstArray) {
            System.out.print(number + " ");
        }
        System.out.println(); //сваляме курсора на нов ред
        for (int number : secondArray) {
            System.out.print(number + " ");
        }
    }
}
