package textProcessing;

import java.util.List;
import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine()  //"sh, too_long_username, !lleg@l ch@rs, jeffbutt"
                            .split(", "); //["sh", "too_long_username", "!lleg@l ch@rs", "jeffbutt"]

        for (String username : usernames) {
            //проверка дали е валидно -> print
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }

    //метод, който проверява дали username е валиден
    //true -> ако е валидно
    //false -> ako не е валидно
    public static boolean isValidUsername(String username) {
        //1. валидна дължина
        //[3; 16]
        if (username.length() < 3 || username.length() > 16) {
            //невалидна дължина -> невалиден username
            return false;
        }
        //дължина е [3; 16] -> валидна дължина

        //2. валидно съдържание -> букви, цифри, -, _
        //username = "TestUser".toCharArray() -> ['T', 'e', 's', 't', 'U', 's', 'e', 'r']
        for (int i = 0; i <= username.length() - 1; i++) {
            char symbol = username.charAt(i);
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                //невалиден символ -> невалиден username
                return false;
            }
        }

        //валидно съдържание и валидна дължина -> валиден username
        return true;
    }
}

//for text -> позиции на символите в текста
//foreach text -> символите в текст
