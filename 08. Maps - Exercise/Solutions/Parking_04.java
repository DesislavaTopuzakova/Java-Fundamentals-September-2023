package maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Parking_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //собственик -> номер на колата
        Map<String, String> parkingData = new LinkedHashMap<>();

        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= countCommands; count++) {
            String command = scanner.nextLine();
            //1. command = "register {username} {licensePlateNumber}"
            //2. command = "unregister {username}"
            String [] commandParts = command.split(" ");
            //commandParts = ["register", "{username}", "{licensePlateNumber}"]
            //commandParts = ["unregister", "{username}"]
            String commandName = commandParts[0]; //име на командата: "register" или "unregister"
            String username = commandParts[1]; //име на собственик

            switch (commandName) {
                case "register":
                    String carNumber = commandParts[2]; //номер на кола
                    //1. имаме в паркинга такъв собственик
                    if (parkingData.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingData.get(username));
                    }
                    //2. нямаме в паркинга такъв собственик
                    else {
                        parkingData.put(username, carNumber);
                        System.out.printf("%s registered %s successfully%n", username, carNumber);
                    }
                    break;
                case "unregister":
                    //1. нямали сме такъв собственик
                    if (!parkingData.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    //2. имали сме такъв собственик
                    else {
                        parkingData.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }
        }
        //map: собственик -> номер на колата
        //"собственик => номер на кола"
        //entry
        //entry.getKey() -> собственика
        //entry.getValue() -> номер на кола
        parkingData.entrySet().forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
    }
}
