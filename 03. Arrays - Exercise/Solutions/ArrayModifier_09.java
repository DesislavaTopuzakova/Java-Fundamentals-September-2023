package arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //[23 -2 321 87 42 90 -123]
        //повтаряме: въвеждаме команди
        //стоп: въведем "end"
        //продължаваме: въведеното != "end"

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            //command != "end" -> валидна команда
            if (command.contains("swap")) {
                //1. command = "swap 1 2".split(" ") -> ["swap", "1", "2"]
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int firstIndexNumber = numbers[index1];
                int secondIndexNumber = numbers[index2];

                numbers[index1] = secondIndexNumber;
                numbers[index2] = firstIndexNumber;

            } else if (command.contains("multiply")) {
                //2. command = "multiply 0 1".split(" ") -> ["multiply", "0", "1"]
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int firstIndexNumber = numbers[index1];
                int secondIndexNumber = numbers[index2];

                int product = firstIndexNumber * secondIndexNumber;
                numbers[index1] = product;

            } else if (command.equals("decrease")) {
                //3. command = "decrease"
                //обхождаме всички елементи ->  -1
                for (int index = 0; index <= numbers.length - 1; index++) {
                    numbers[index]--;
                    //numbers[index] -= 1; => numbers[index] = numbers[index] - 1;
                }
            }

            command = scanner.nextLine();
        }

        //отпечатваме числата разделени с ", "
        //1-ви начин
        System.out.println(Arrays.toString(numbers)           //"[86, 7382, 2369942, -124, 41, 89, -3]"
                            .replace("[", "") //"86, 7382, 2369942, -124, 41, 89, -3]"
                            .replace("]", "") //"86, 7382, 2369942, -124, 41, 89, -3"
                           );

        //2-ри начин
        //след всяко число отпечатваме ", ", само без след последното
        /*for (int index = 0; index <= numbers.length - 1; index++) {
            int number = numbers[index];
            if (index != numbers.length - 1) {
                System.out.print(number + ", ");
            } else { //index == numbers.length - 1
                //последния индекс -> последното число в масива
                System.out.print(number);
            }
        }*/
    }
}
