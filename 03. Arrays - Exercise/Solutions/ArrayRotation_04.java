package arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        int [] numbers = Arrays.stream(scanner.nextLine() //"51 47 32 61 21"
                         .split(" "))  //["51", "47", "32", "61", "21"]
                         .mapToInt(Integer::parseInt) //[51, 47, 32, 61, 21]
                         .toArray();

        int rotations = Integer.parseInt(scanner.nextLine()); //брой ротации

        for (int rotation = 1; rotation <= rotations; rotation++) {
            //ротация на масива
            //1. взимаме първия елемент
            int firstElement = numbers[0]; //51
            //2. преместваме елементите (копиране) елементите наляво
            //!!!без промяна на последната позиция
            //[51, 47, 32, 61, 21] -> //[47, 32, 61, 21, 21]
            for (int index = 0; index < numbers.length - 1; index++) {
                 numbers[index] = numbers[index + 1];
            }
            //3. поставяме първия елемент на последно място
            //[47, 32, 61, 21, 51]
            numbers[numbers.length - 1] = firstElement;
        }

        //приключили с ротациите -> принтираме елементите на масива
        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}
