package methods;

import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        //факториел на първото число (firstNumber)
        long factFirstNumber = calculateFactorial(firstNumber);

        //факториел на второто число (secondNumber)
        long factSecondNumber = calculateFactorial(secondNumber);


        //факториел на първото число / факториел на второто число -> %.2f
        double result = factFirstNumber * 1.0 / factSecondNumber;
        System.out.printf("%.2f", result);
    }

    //метод, който връща резултат (факториел на даденото число)
    //!!! изчисленият факториел може да бъде много голямо число !!!
    public static long calculateFactorial (int number) {
        //number = 8
        //8! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8
        long fact = 1; //стойността на факториел
        for (int i = 1; i <= number ; i++) {
            fact = fact * i;
        }

        return fact;
    }
}
