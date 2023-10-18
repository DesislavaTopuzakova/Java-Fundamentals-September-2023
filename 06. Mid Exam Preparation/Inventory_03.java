package examPrepMid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String command = scanner.nextLine(); //входни данни: валидна команда или "Craft!"
        while (!command.equals("Craft!")) {
            //1. command = "Collect - {item}".split(" - ") -> ["Collect", "{item}"]
            //2. command = "Drop - {item}".split(" - ") -> ["Drop", "{item}"]
            //3. command = "Combine Items - {item}:{new_item}".split(" - ") -> ["Combine Items", "{item}:{new_item}"]
            //4. command = "Renew – {item}".split(" - ") -> ["Renew", "{item}"]
            String[] commandParts = command.split(" - ");
            String commandName = commandParts[0]; // "Collect", "Drop", "Combine Items", "Renew"
            String item = commandParts[1];

            switch (commandName) {
                case "Collect":
                    if (!items.contains(item)) {
                        items.add(item);
                    }
                    break;
                case "Drop":
                    items.remove(item); //remove -> 1. проверява дали имаме елемента  2. премахваме
                    break;
                case "Combine Items":
                    //item = "{old_item}:{new_item}".split(":") -> ["{old_item}", "{new_item}"]
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];
                    if (items.contains(oldItem)) {
                        int indexOldItem = items.indexOf(oldItem);
                        //add(index, element) -> вмъква, да не губим елементи
                        //set(index, element) -> замества, губим елемент на дадения индекс
                        items.add(indexOldItem + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (items.contains(item)) {
                        items.remove(item);
                        items.add(item);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        //принтираме крайния списък
        System.out.println(String.join(", ", items));

    }
}
