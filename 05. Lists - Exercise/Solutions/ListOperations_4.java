package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                               .map(Integer::parseInt).collect(Collectors.toList());
        //{1, 23, 29, 18, 43, 21, 20}

        String command = scanner.nextLine();
        while(!command.equals("End")) {
            if (command.contains("Add")) {
                //1. command = "Add 3".split(" ") -> ["Add", "3"]
                //add number at the end
                int numberToAdd = Integer.parseInt(command.split(" ")[1]);
                numbers.add(numberToAdd);
            } else if (command.contains("Insert")) {
                //2. command = "Insert 24 1".split(" ") -> ["Insert", "24", "1"]
                //insert number at given index
                int numberToInsert = Integer.parseInt(command.split(" ")[1]);
                int index = Integer.parseInt(command.split(" ")[2]);
                //валидираме индекс
                if (index >= 0 && index <= numbers.size() - 1) {
                    //валиден индекс
                    numbers.add(index, numberToInsert);
                } else {
                    //невалиден индекс
                    System.out.println("Invalid index");
                }
            } else if (command.contains("Remove")) {
                //3. command = "Remove 1".split(" ") -> ["Remove", "1"]
                //remove that index
                int indexToRemove = Integer.parseInt(command.split(" ")[1]);
                //валидираме индекс
                if (indexToRemove >= 0 && indexToRemove <= numbers.size() - 1) {
                    //валиден индекс
                    numbers.remove(indexToRemove);
                } else {
                    //невалиден индекс
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift left")) {
                //4. command = 	"Shift left 3".split(" ") -> ["Shift", "left", "3"]
                //first number becomes last 'count' times
                int countShiftLeft = Integer.parseInt(command.split(" ")[2]);

                for (int i = 0; i < countShiftLeft; i++) {
                    //повтараме: shift left: първото число става последно
                    //{1, 23, 29, 18, 43, 21, 20}
                    //1. взимам първото число -> 1
                    int firstElement = numbers.get(0);
                    //2. премахвам го -> {23, 29, 18, 43, 21, 20}
                    numbers.remove(0);
                    //3. поставям го като последно -> {23, 29, 18, 43, 21, 20, 1}
                    numbers.add(firstElement);
                }
            } else if (command.contains("Shift right")) {
                //5. command =  "Shift right 5".split(" ") -> ["Shift", "right", "5"]
                //last number becomes first 'count' times
                int countShiftRight = Integer.parseInt(command.split(" ")[2]);

                for (int i = 0; i < countShiftRight; i++) {
                    //повтараме: shift right: последното число става първо
                    //{1, 23, 29, 18, 43, 21, 20}
                    //1. взимаме последното число -> 20
                    int lastNumber = numbers.get(numbers.size() - 1);
                    //2. премахваме последното число -> {1, 23, 29, 18, 43, 21}
                    numbers.remove(numbers.size() - 1);
                    //3. добавяме числото в началото -> {20, 1, 23, 29, 18, 43, 21}
                    numbers.add(0, lastNumber);
                }
            }

            command = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
