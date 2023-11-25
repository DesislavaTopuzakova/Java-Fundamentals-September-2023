package examPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. СЪХРАНЯВАНЕ НА ДАННИ ЗА ГРАДОВЕТЕ
        //град -> население
        Map<String, Integer> townPopulation = new LinkedHashMap<>();
        //град -> злато
        Map<String, Integer> townGold = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            //input = "Tortuga||345000||1250".split("||") -> ["Tortuga", "345000", "1250"]
            String town = input.split("\\|\\|")[0]; //"Tortuga"
            int population = Integer.parseInt(input.split("\\|\\|")[1]); //"345000" -> 345000
            int gold = Integer.parseInt(input.split("\\|\\|")[2]); //"1250" -> 1250

            //не е записан града
            if (!townPopulation.containsKey(town) && !townGold.containsKey(town)) {
                townPopulation.put(town, population);
                townGold.put(town, gold);
            } else {
                //имаме такъв град
                townPopulation.put(town, townPopulation.get(town) + population);
                townGold.put(town, townGold.get(town) + gold);

            }

            input = scanner.nextLine();
        }

        //2. ОБРАБОТКА НА ДАННИТЕ ЗА ГРАДОВЕТЕ
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            //command = "Plunder=>{town}=>{people}=>{gold}".split("=>") -> ["Plunder","{town}", "{people}", {gold}"]
            //command = "Prosper=>{town}=>{gold}".split("=>") -> ["Prosper", "{town}", {gold}"]
            String[] commandParts = command.split("=>");
            String commandName = commandParts[0]; //име на команда -> "Plunder" или "Prosper"
            String town = commandParts[1]; //град

            switch (commandName) {
                case "Plunder":
                    //плячкосваме / нападаме
                    int killedPeople = Integer.parseInt(commandParts[2]); //убити хора
                    int stealGold = Integer.parseInt(commandParts[3]); //откраднато злато
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, stealGold, killedPeople);
                    townPopulation.put(town, townPopulation.get(town) - killedPeople);
                    townGold.put(town, townGold.get(town) - stealGold);

                    //проверка дали града ще съществува
                    if (townPopulation.get(town) <= 0 || townGold.get(town) <= 0) {
                        //изчезва града, ако няма или хора, или злато
                        townPopulation.remove(town);
                        townGold.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;

                case "Prosper":
                    //икономически прогрес
                    int earnedGold = Integer.parseInt(commandParts[2]); //заработено злато
                    if (earnedGold <= 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        townGold.put(town, townGold.get(town) + earnedGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                earnedGold, town, townGold.get(town));
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        //3. ОТПЕЧАТВАНЕ НА ГРАДОВЕТЕ
        if (townPopulation.size() > 0) {
            //имаме налични градове
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townGold.size());
            townGold.entrySet().forEach(entry -> {
                //entry
                //key -> град
                //value -> злато
                String town = entry.getKey();
                int gold = entry.getValue();
                int population = townPopulation.get(town);
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", town, population, gold);
            });
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
