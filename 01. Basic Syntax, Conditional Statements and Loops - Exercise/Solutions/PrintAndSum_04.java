package basics_recap;

import java.util.Scanner;

public class PrintAndSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. отпечатвам числата в диапазон => ОК
        //2. намирам сумата на числата в диапазон

        int startNumber = Integer.parseInt(scanner.nextLine()); //начало на диапазона
        int endNumber = Integer.parseInt(scanner.nextLine()); //край на диапазона

        //FOR ЦИКЪЛ
        //1. начало: startNumber
        //2. край: endNumber
        //3. какво повтаряме?
        //4. промяна: +1

        int sum = 0; //сума от числата в диапазона
        for (int number = startNumber; number <= endNumber; number++) {
            System.out.print(number + " ");
            sum = sum + number; //sum += number;
        }

        //преминали през всички числа в диапазона
        System.out.printf("%nSum: " + sum);
    }
}
