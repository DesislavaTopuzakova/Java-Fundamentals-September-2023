package examPreparation;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {                                
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder messageBuilder = new StringBuilder(message); //място за обработка на съобщението
        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            //input = "InsertSpace:|:{index}".split(":|:") -> ["InsertSpace", "{index}"]
            //input = "Reverse:|:{substring}".split(":|:") -> ["Reverse", "{substring}"]
            //input = "ChangeAll:|:{substring}:|:{replacement}".split(":|:") -> ["ChangeAll", "{substring}", "{replacement}"]
            String[] commandParts = input.split(":\\|:");
            String commandName = commandParts[0]; //име на команда: "InsertSpace", "Reverse", "ChangeAll"

            switch (commandName) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandParts[1]);
                    messageBuilder.insert(index, " ");
                    System.out.println(messageBuilder);
                    break;
                case "Reverse":
                    String substring = commandParts[1]; //съобщение за махане
                    if (messageBuilder.toString().contains(substring)) {
                        //1. махаме текста от съобщението
                        int indexOfSubstring = messageBuilder.indexOf(substring);
                        messageBuilder.delete(indexOfSubstring, indexOfSubstring + substring.length() + 1);
                        //2. reverse
                        String reversedSubstring = new StringBuilder(substring).reverse().toString();
                        //3. добавяме обърнатия текст в края на съобщението
                        messageBuilder.append(reversedSubstring);

                        System.out.println(messageBuilder);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                        String textForReplace = commandParts[1];
                        String replacementText = commandParts[2];
                        messageBuilder = new StringBuilder(messageBuilder.toString().replaceAll(textForReplace, replacementText));
                        System.out.println(messageBuilder);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("You have a new text message: " + messageBuilder);

    }
}
