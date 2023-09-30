package arrays;

import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        String firstRow = scanner.nextLine(); //"Hey hello 2 4"
        String secondRow = scanner.nextLine(); //"10 hey 4 hello"

        String [] firstArray = firstRow.split(" "); // ["Hey", "hello", "2", "4"]
        String [] secondArray = secondRow.split(" "); // ["10", "hey", "4", "hello"]

        //за всеки елемент на втория масив -> проверка дали го има в първия масив

        for (String el2 : secondArray) { // ["10", "hey", "4", "hello"]
            for (String el1 : firstArray) { // ["Hey", "hello", "2", "4"]
                if (el2.equals(el1)) {
                    System.out.print(el2 + " ");
                }
            }
        }
    }
}
