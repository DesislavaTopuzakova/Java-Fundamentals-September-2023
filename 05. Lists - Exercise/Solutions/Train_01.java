package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                                .map(Integer::parseInt).collect(Collectors.toList());
        //{0, 0, 0, 10, 2, 4}

        int maxCapacity = Integer.parseInt(scanner.nextLine()); //макс брой хора

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            //валидна команда
            if (command.contains("Add")) {
                //1. command = "Add 10".split(" ") -> ["Add", "10"]
                int count = Integer.parseInt(command.split(" ")[1]); //бр. хората в новия вагон
                wagons.add(count);
            } else {
                //2. command = "100" -> брой на хората за настаняване по вагоните
                int passengersCount = Integer.parseInt(command); //бр. хората, които да добавя в някой вагон
                for (int wagon = 0; wagon <= wagons.size() - 1; wagon++) {
                     int passengersPerWagon = wagons.get(wagon); //бр. хората в текущия вагон
                    if (passengersPerWagon + passengersCount <= maxCapacity) {
                        //можем да добавим хората в този вагон
                        wagons.set(wagon, passengersPerWagon + passengersCount);
                        break;
                    }

                }
            }
            command = scanner.nextLine();
        }

        for (int number : wagons) {
            System.out.print(number + " ");
        }
    }
}
