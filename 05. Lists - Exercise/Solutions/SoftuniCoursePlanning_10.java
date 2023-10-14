package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftuniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни -> списък със занятия (текст)
        List<String> topics = Arrays.stream(scanner.nextLine() //"Data Types, Objects, Lists"
                                .split(", ")) //["Data Types", "Objects", "Lists"]
                                .collect(Collectors.toList()); //{"Data Types", "Objects", "Lists"}

        String command = scanner.nextLine();
        while (!command.equals("course start")) {
            //валидна команда
            //1. command = "Add:{lessonTitle}".split(":")                -> ["Add", "{lessonTitle}"]
            //2. command = "Insert:{lessonTitle}:{index}".split(":")     -> ["Insert", "{lessonTitle}", "{index}"]
            //3. command = "Remove:{lessonTitle}".split(":")             -> ["Remove", "{lessonTitle}"]
            //4. command = "Swap:{lessonTitle}:{lessonTitle}".split(":") -> ["Swap", "{lessonTitle}", "{lessonTitle}"]
            //5. command = "Exercise:{lessonTitle}".split(":")           -> ["Exercise", "{lessonTitle}"]
            String [] commandParts = command.split(":");
            String commandName = commandParts[0]; //"Add", "Insert", "Remove", "Swap", "Exercise"
            String topic = commandParts[1]; //име на занятието

            switch (commandName) {
                case "Add":
                    //command = "Add:Databases"
                    //add the lesson to the end of the schedule, if it does not exist
                    if (!topics.contains(topic)) {
                        topics.add(topic);
                    }
                    break;
                case "Insert":
                    //command = "Insert:Databases:1".split(":") -> ["Insert", "Databases", "1"]
                    //insert the lesson to the given index, if it does not exist
                    int indexForInsert = Integer.parseInt(commandParts[2]); //позиция за вмъкване
                    if (!topics.contains(topic)) {
                        topics.add(indexForInsert, topic);
                    }
                    break;
                case "Remove":
                    //command = "Remove:Data Types"
                    //remove the lesson, if it exists
                    if (topics.contains(topic)) {
                        int topicIndex = topics.indexOf(topic);//позиция на темата
                        String exerciseName = topic + "-Exercise";//име на упражнение
                        boolean hasExercise = topicIndex != topics.size() - 1 && topics.get(topicIndex + 1).equals(exerciseName);
                        //true -> имаме упражнение след темата
                        //false -> нямаме упражнение след темата

                        //премахваме темата
                        topics.remove(topic);
                        //има ли упражнение след темата -> премахваме и него
                        if (hasExercise) {
                            topics.remove(exerciseName);
                        }
                    }

                    break;
                case "Swap":
                    //command = "Swap:Data Types:Objects".split(":") -> ["Swap", "{lessonTitle1}", "{lessonTitle2}"]
                    //change the place of the two lessons, if they exist
                    //topic -> първата тема за размяната
                    String topic2 = commandParts[2]; //втората тема за размяна

                    if (topics.contains(topic) && topics.contains(topic2)) {
                        //занятията съществуват -> размяна  на темите
                        int indexFirst = topics.indexOf(topic); //позиция на първата тема
                        int indexSecond = topics.indexOf(topic2); //позиция на втората тема

                        topics.set(indexSecond, topic);
                        topics.set(indexFirst, topic2);

                        //размяна на упражнения
                        String exFirstTopic = topic + "-Exercise"; //име на упражнение след първата тема
                        String exSecondTopic = topic2 + "-Exercise"; //име на упражнение след втората тема

                        //проверка дали съществува упражнение след първата тема
                        if (topics.contains(exFirstTopic)) {
                            topics.remove(exFirstTopic);
                            topics.add(topics.indexOf(topic) + 1, exFirstTopic);
                        }

                        //проверка дали съществува упражнение след втората тема
                        if (topics.contains(exSecondTopic)) {
                            topics.remove(exSecondTopic);
                            topics.add(topics.indexOf(topic2) + 1, exSecondTopic);
                        }
                    }
                    break;
                case "Exercise":
                    //command = "Exercise:Methods"
                    //добавя упражнение към дадената тема
                    String exerciseName = topic + "-Exercise"; //име на упражнение
                    //1. проверка дали имаме такава тема
                    if (topics.contains(topic)) {
                        //имам такава тема -> добавям упражнение
                        int indexTopic = topics.indexOf(topic); //позиция на темата
                        //моята тема е последна
                        if (indexTopic == topics.size() - 1) {
                            //моята тема е последна -> НЯМАМЕ УПРАЖНЕНИЕ СЛЕД НЕЯ
                            topics.add(exerciseName);

                        }
                        //проверка съществува ли вече упражнение за тази тема
                        else if (!topics.get(indexTopic + 1).equals(exerciseName)) {
                            //след моята тема няма упражнение
                            topics.add(indexTopic + 1, exerciseName);
                        }
                    } else {
                        //нямаме такава тема
                        //1. добавяме темата на края на списъка
                        //2. добавяме упражнение
                        topics.add(topic);
                        topics.add(exerciseName);
                    }

                    break;

            }

            command = scanner.nextLine();
        }

        int number = 1; //номерацията преди всяка тема
        for (String topic : topics) {
            System.out.println(number + "." + topic);
            number++;
        }
    }
}
