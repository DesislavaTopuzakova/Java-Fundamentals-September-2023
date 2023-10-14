package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine() //"1 2 3 4 5 5 5 6"
                                .split(" "))//["1", "2", "3", "4", "5", "5", "5", "6"]
                                .map(Integer::parseInt) //[1, 2, 3, 4, 5, 5, 5, 6]
                                 .collect(Collectors.toList());  //{1, 2, 3, 4, 5, 5, 5, 6}

        String command = scanner.nextLine(); //валидна команда или "end"
        //repeat: въвеждаме команда
        //stop: command == "end"
        //continue: command != "end"
        while (!command.equals("end")) {
            if (command.contains("Delete")) {
                //1. command = "Delete 4".split(" ") -> ["Delete", "4"]
                int numberForDelete = Integer.parseInt(command.split(" ")[1]); //число, което ще премахвам
                //премахвам всички елементи в списъка, които са равни на numberForDelete
                numbers.removeAll(Arrays.asList(numberForDelete));
            } else if (command.contains("Insert")) {
                //2. command = "Insert 2 0".split(" ") -> ["Insert", "2", "0"]
                int element = Integer.parseInt(command.split(" ")[1]); //елемент за вмъкване
                int position = Integer.parseInt(command.split(" ")[2]); //индекс за вмъкване
                //вмъкваме дадения елемент на дадената позиция
                numbers.add(position, element);
            }
            command = scanner.nextLine();
        }

        //списък с числа -> печатаме -> {3, 4, 5, 6}
        for (int number : numbers ) {
            System.out.print(number + " ");
        }
    }
}
