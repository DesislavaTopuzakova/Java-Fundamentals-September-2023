package methods;

import java.util.Scanner;

public class TopInteger_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int number = 1; number <= n; number++) {
            //проверка дали е топ
            //1. сумата от цифрите да се дели на 8 -> checkSumDigitsIsDivisibleBy8
            boolean isValidSumDigits = checkSumDigitsIsDivisibleBy8(number);
            //2. съдържа поне една нечетна цифра
            boolean isContainsOddDigit = checkContainsOddDigits(number);

            if (isValidSumDigits && isContainsOddDigit) {
                //топ число
                System.out.println(number);
            }
        }
    }

    //метод, който проверява дали сумата от цифрите на числото се дели на 8
    //true -> сумата се дели на 8
    //false -> сумата не се дели на 8
    public static boolean checkSumDigitsIsDivisibleBy8 (int number) {
        int sum = 0; //сума от цифрите
        while (number > 0) {
            int lastDigit = number % 10; //последна цифра
            sum += lastDigit; //сумираме последна цифра
            number /= 10; //премахваме последната цифра
        }
        //сумата от цифрите на числото
        if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //метод, който проверява дали имаме поне една нечетна цифра в числото
    //true -> ако имаме поне една нечетна цифра
    //false -> ако нямаме нито една нечетна цифра
    public static boolean checkContainsOddDigits (int number) {
        //4365
        while (number > 0) {
            int lastDigit = number % 10; // последна цифра
            if (lastDigit % 2 != 0) {
                //нечетна цифра -> поне една нечетна
                return true;
            } else {
                //четна цифра -> премахваме
                number /= 10;
            }
        }

        //проверили всички цифри и никоя не е била нечетна
        return false;
    }
}
