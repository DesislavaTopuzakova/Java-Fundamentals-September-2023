package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean liftFull = true;

        for (int i = 0; i < wagons.length; i++) {
            int availableSpace = 4 - wagons[i];

            if (availableSpace > 0) {
                if (availableSpace > waitingPeople) {
                    wagons[i] += waitingPeople;
                    waitingPeople = 0;
                    liftFull = false;

                } else {
                    wagons[i] = 4;
                    waitingPeople -= availableSpace;
                }
            }

        }

        if (!liftFull) {
            System.out.println("The lift has empty spots!");
        } else if (waitingPeople > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", waitingPeople);
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
