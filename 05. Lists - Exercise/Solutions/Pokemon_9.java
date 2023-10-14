package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pokemon_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                                .map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0; // сума на всички премахнати елементи
        //repeat: въвеждаме индекси (цели числа) от конзолата
        //stop: празен лист -> бр. елементи <= 0
        //continue: имаме елементи в списъка -> бр. елементи > 0
        while (numbers.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index <= numbers.size() - 1) {
                //премахваме елемента на този индекс
                int removedElement = numbers.get(index); //премахнато число от списъка
                sum += removedElement;
                numbers.remove(index);
                //модифицираме елементите на списъка спрямо премахнатия елемент
                modifyList(numbers, removedElement);
            } else if (index < 0) {
                int removedElement = numbers.get(0); //премахнато число
                sum += removedElement;
                //премахваме първия елемент в списъка
                numbers.remove(0);
                //последния елемент
                int lastElement = numbers.get(numbers.size() - 1);
                //последния елемент на първо място
                numbers.add(0, lastElement);
                //модифицираме елементите на списъка спрямо премахнатия елемент
                modifyList(numbers, removedElement);
            } else if (index > numbers.size() - 1){
                int removedElement = numbers.get(numbers.size() - 1);
                sum += removedElement;
                //премахваме последния елемент
                numbers.remove(numbers.size() - 1);
                //първия елемент
                int firstElement = numbers.get(0);
                //първия елемент на последно място
                 numbers.add(firstElement);
                //модифицираме елементите на списъка спрямо премахнатия елемент
                 modifyList(numbers, removedElement);
            }
        }

        System.out.println(sum);
    }

    private static void modifyList(List<Integer> numbers, int removedElement) {
        for (int index = 0; index <= numbers.size() - 1; index++) {
            int currentNumber = numbers.get(index);
            if (currentNumber <= removedElement) {
                currentNumber += removedElement;
            } else { //currentNumber > removedElement
                currentNumber -= removedElement;
            }

            numbers.set(index, currentNumber);
        }
    }
}
