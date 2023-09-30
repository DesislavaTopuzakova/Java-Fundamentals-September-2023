package dataTypes_ex;

import java.util.Scanner;

public class SumDigits_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0; //сумата от цифрите

        //стоп: числото няма цифри (число <= 0)
        //продължаваме: числото има цифри (число > 0)
        while (number > 0) {
            //1. последна цифра
            int lastDigit = number % 10;
            //2. сумираме последна цифра
            sum += lastDigit; //sum = sum + lastDigit;
            //3. премахваме
            number /= 10; //number = number / 10;
        }

        System.out.println(sum);
    }
}
