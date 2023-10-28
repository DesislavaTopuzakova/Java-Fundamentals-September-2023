package ObjectsAndClasses.OpinionPoll_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //брой редове
        List<Person> peopleList = new ArrayList<>(); //списък с хората

        for (int row = 1; row <= n; row++) {
            String personalData = scanner.nextLine(); //"Peter 12".split(" ") -> ["Peter", "12"]
            String name = personalData.split(" ")[0]; //име
            int age = Integer.parseInt(personalData.split(" ")[1]); //възраст

            //проверка за възрастта
            if (age > 30) {
                Person person = new Person(name, age); //обект от класа
                peopleList.add(person);
            }
        }

        //списък с хората над 30 години
        //всеки човек -> отпечатваме
        for (Person person : peopleList) {
            //име - възраст
            System.out.println(person.getName() + " - " + person.getAge());
        }

    }
}
