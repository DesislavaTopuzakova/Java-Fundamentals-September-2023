package examPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine(); //текст с информация
        //text = "#Bread#19/03/21#4000#|Invalid|03/03.20||Apples|08/10/20|200||Carrots|06/08/20|500||Not right|6.8.20|5|"
        String regex = "([#|])(?<foodName>[A-Za-z\\s]+)\\1(?<expirationDate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1";
        Pattern pattern = Pattern.compile(regex); //шаблон
        Matcher matcher = pattern.matcher(text);
        //matcher = {"#Bread#19/03/21#4000#", "|Apples|08/10/20|200|", "|Carrots|06/08/20|500|"}

        int totalCalories = 0; //сума от калориите на храни
        StringBuilder foodsOutput = new StringBuilder(); //конструирам храните за отпечатване

        while (matcher.find()) {
            //matcher -> "#Bread#19/03/21#4000#"
            //matcher = "#(?<foodName>Bread)#(?<expirationDate>19/03/21)#(?<calories>4000)#";
            String foodName = matcher.group("foodName"); //"Bread"
            String expirationDate = matcher.group("expirationDate"); //"19/03/21"
            int calories = Integer.parseInt(matcher.group("calories")); //"4000" -> 4000

            totalCalories += calories;
            String output = String.format("Item: %s, Best before: %s, Nutrition: %d%n", foodName, expirationDate, calories);
            foodsOutput.append(output);
        }

        //знаем колко общо калории може да си набавим от храната
        int days = totalCalories / 2000; //колко дни ще оцелеем с наличната храна
        System.out.printf("You have food to last you for: %d days!%n", days);
        //отпечатваме храните
        System.out.println(foodsOutput);



    }
}
