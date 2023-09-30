package dataTypes_ex;

import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine()); //брой подправки, които събираме в първия ден
        //стоп: startingYield < 100 -> не можем да събираме подправки
        //продължаваме: startingYield >= 100 -> можем да събираме подправки

        int days = 0; //брой дни, в които събираме подправки
        int total = 0; //общ стойност на събраните подправки

        while (startingYield >= 100) {
            //събираме подправки
            days++;
            //колко подправки събираме
            int spicePerDay = startingYield - 26;
            //сумираме събраните подправки
            total += spicePerDay;

            startingYield -= 10; //полето отслабва преди следващия ден - 10
        }

        //не можем да събираме подправки -> бракувани 26 от събраните
        total -= 26;

        //може да сме на минус
        if (total < 0) {
            total = 0;
        }

        System.out.println(days);
        System.out.println(total);


    }
}
