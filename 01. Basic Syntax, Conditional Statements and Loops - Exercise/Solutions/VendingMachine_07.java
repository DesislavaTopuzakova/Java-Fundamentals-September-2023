package basics_recap;

import java.util.Scanner;
import java.util.regex.Pattern;

public class VendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ПЪРВА ЧАСТ -> ПУСКАНЕТО НА МОНЕТИ
        String input = scanner.nextLine(); //дробно число под формата на текст или текст ("Start")
        double sumCoins = 0;
        while (!input.equals("Start")) {
            //input = "0.50"
            double coin = Double.parseDouble(input); //стойността на пуснатата монета
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                //валидна монета -> машината я приема
                sumCoins += coin;
            } else {
                //невалидна монета -> машината не я приема
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }

        //каква е депозираната / пусната сума, която ще се използва за пазаруване -> sumCoins

        //ВТОРАТА ЧАСТ -> ЗАКУПУВАНЕ НА ПРОДУКТ
        String product = scanner.nextLine(); //"Nuts", "Water", "Crisps", "Soda", "Coke"
        while (!product.equals("End")) {
            //валиден продукт -> проверка кой продукт точно е избран
            switch (product) {
                case "Nuts":
                    //цената е 2.00
                    if (sumCoins >= 2) {
                        //мога да си купя продукта
                        System.out.println("Purchased Nuts");
                        sumCoins -= 2;
                    } else {
                        //не мога да си купя продукта
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    //цената е 0.70
                    if (sumCoins >= 0.70) {
                        //мога да си купя продукта
                        System.out.println("Purchased Water");
                        sumCoins -= 0.70;
                    } else {
                        //не мога да си купя продукта
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    //цената е 1.50
                    if (sumCoins >= 1.50) {
                        //мога да си купя продукта
                        System.out.println("Purchased Crisps");
                        sumCoins -= 1.50;
                    } else {
                        //не мога да си купя продукта
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    //цената е 0.80
                    if (sumCoins >= 0.80) {
                        //мога да си купя продукта
                        System.out.println("Purchased Soda");
                        sumCoins -= 0.80;
                    } else {
                        //не мога да си купя продукта
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    //цената е 1.00
                    if (sumCoins >= 1) {
                        //мога да си купя продукта
                        System.out.println("Purchased Coke");
                        sumCoins -= 1;
                    } else {
                        //не мога да си купя продукта
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    //продуктът е различен от: "Nuts", "Water", "Crisps", "Soda", "Coke"
                    System.out.println("Invalid product");
                    break;
            }

            product = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sumCoins);
    }
}
