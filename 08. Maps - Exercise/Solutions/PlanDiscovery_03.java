package maps;

import java.util.*;

public class PlanDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        int countPlants = Integer.parseInt(scanner.nextLine());
        //растение -> индекс на рядкост (rarity)
        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        //растение -> списък с рейтинги
        Map<String, List<Double>> plantsRating = new LinkedHashMap<>();

        for (int plant = 1; plant <= countPlants; plant++) {
            String input = scanner.nextLine();
            //"{plant}<->{rarity}".split("<->") -> ["{plant}", "{rarity}"]
            String plantName = input.split("<->")[0]; //име на растението
            int rarity = Integer.parseInt(input.split("<->")[1]); //индекс на рядкост

            plantsRarity.put(plantName, rarity);
            plantsRating.putIfAbsent(plantName, new ArrayList<>());
        }

        //2. изпълнение на команди
        String command = scanner.nextLine();
        while (!command.equals("Exhibition")){
            String plantName = command.split(" ")[1]; //име на растението, с което ще работим
            //проверка има ли такова растение
            if (!plantsRarity.containsKey(plantName)) {
                //нямаме такова растение
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }
            if (command.contains("Rate")) {
                //command = "Rate: {plant} - {rating}"
                // .split(" ") -> ["Rate:", "{plant}", "-", "{rating}"]
                double rating = Double.parseDouble(command.split(" ")[3]);
                plantsRating.get(plantName).add(rating);
            } else if (command.contains("Update")) {
                //command = "Update: {plant} - {new_rarity}"
                //.split(" ") -> ["Update:", "{plant}", "-", "{new_rarity}"]
                int newRarity = Integer.parseInt(command.split(" ")[3]);
                plantsRarity.put(plantName, newRarity);
            } else if (command.contains("Reset")) {
                //command = "Reset: {plant}".split(" ") -> ["Reset:", "{plant}"]
                plantsRating.get(plantName).clear();
            }

            command = scanner.nextLine();
        }

        //3. отпечатване
        System.out.println("Plants for the exhibition:");
        plantsRarity.entrySet().forEach(entry -> {
            //entry
            //key -> име на растение
            //value -> индекс на рядкост
            String plantName = entry.getKey();
            int rarity = entry.getValue();
            double averageRating = plantsRating.get(plantName).stream().mapToDouble(a -> a).average().orElse(0.0);

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plantName, rarity, averageRating);

        });
    }
}
