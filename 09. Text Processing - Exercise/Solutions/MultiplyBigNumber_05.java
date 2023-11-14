package textProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine(); //"923847238931983192462832102"
        int secondNumber = Integer.parseInt(scanner.nextLine()); //4

        StringBuilder result = new StringBuilder(); //"3"
        int over = 0; //на ум

        for (int position = firstNumber.length() - 1; position >= 0; position--) {
            //'2' char -> "2" string -> 2 int
            int digit = Integer.parseInt(firstNumber.charAt(position) + "");
            int product = digit * secondNumber + over; //23

            over = product / 10;
            result.insert(0, product % 10);
            
        }

        System.out.println(result);


    }
}
