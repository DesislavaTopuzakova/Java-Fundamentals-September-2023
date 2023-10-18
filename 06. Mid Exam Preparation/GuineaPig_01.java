package examPrepMid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GuineaPig_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        double foodInKg = Double.parseDouble(scanner.nextLine()); //храна за 1 месец (килограми)
        double hayInKg = Double.parseDouble(scanner.nextLine()); //сено за 1 месец (килограми)
        double coverInKg = Double.parseDouble(scanner.nextLine()); //покривало за 1 месец (килограми)
        double pigWeightInKg = Double.parseDouble(scanner.nextLine());//тегло на свинчето (килограми)

        //2. преобразуваме всичко в грамове
        double foodInGrams = foodInKg * 1000; //храна за 1 месец (грамове)
        double hayInGrams = hayInKg * 1000; //сено за 1 месец (грамове)
        double coverInGrams = coverInKg * 1000; //покривало за 1 месец (грамове)
        double pigWeightInGrams = pigWeightInKg * 1000;//тегло на свинчето (грамове)

        for (int day = 1; day <= 30; day++) {
            //всеки ден яде по 300 гр.
            foodInGrams -= 300;

            //всеки втори ден -> сменя сеното
            if (day % 2 == 0) {
                //сено = 5% от останалата храна
                double neededHay =  0.05 * foodInGrams;
                hayInGrams -= neededHay;
            }

            //всеки трети ден -> сменя покривалото
            if (day % 3 == 0) {
                double coverNeeded = pigWeightInGrams/ 3; //нужно покривало за смяна
                coverInGrams -= coverNeeded;
            }

            //проверка дали някой от консумативите е свършил
            if (foodInGrams <= 0 || hayInGrams <= 0 || coverInGrams <= 0) {
                System.out.println("Merry must go to the pet store!");
                return; //прекратява цялата програма
            }
        }

        //преминали и 30-те дни
        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                foodInGrams / 1000, hayInGrams / 1000, coverInGrams / 1000);

        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
    }
}
