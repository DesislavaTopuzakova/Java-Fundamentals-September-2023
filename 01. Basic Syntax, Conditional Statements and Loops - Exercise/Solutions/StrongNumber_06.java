package basics_recap;

import java.util.Scanner;

public class StrongNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = number; //първоначала стойност на числото, която не променям

        //WHILE ЦИКЪЛ
        //повтаряме: взимаме последната цифра -> ....... -> премахваме последната цифра
        //стоп: число <= 0 -> нямаме цифри в него
        //продължаваме: число > 0 -> имам цифри в него

        int sumFact = 0; //сума от факториелите на цифрите
        while (number > 0) {
            //1. взимаме последната цифра
            int lastDigit = number % 10; //последната или единствена цифра

            //2. обработваме цифрата -> факториел
            //9! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9
            int fact = 1; //факториел на цифрата
            for (int i = 1; i <= lastDigit; i++) {
                fact = fact * i;
            }
            //знам колко е факториелът на цифрата -> fact
            sumFact += fact;

            //3. премахваме цифрата
            number = number / 10; //number /= 10
        }


        //проверка дали е strong
        if (sumFact == startNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
