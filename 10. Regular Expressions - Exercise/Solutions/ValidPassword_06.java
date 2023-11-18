package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexPassword = "_\\.+(?<passwordText>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.+";
        Pattern pattern = Pattern.compile(regexPassword);

        int n = Integer.parseInt(scanner.nextLine()); //брой пароли

        for (int i = 1; i <= n; i++) {
            String password = scanner.nextLine();
            //валидна ли е тази парола
            Matcher matcher = pattern.matcher(password);
            //1. matcher = [] -> невалидна парола
            //2. matcher = ["_...ChelseA_."] -> валидна парола

            if (matcher.find()) {
                //валидна парола -> категоризация в група
                //категория => цифрите в паролата
                String textPassword = matcher.group("passwordText"); //"ChelseA"
                StringBuilder sbDigitsCategory = new StringBuilder(); //долепям намерените цифри
                for (char symbol : textPassword.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        //цифра
                        sbDigitsCategory.append(symbol);
                    }
                }
                //sbDigitsCategory долепени всички цифри в паролата
                //1. нямаме цифри в паролата
                if (sbDigitsCategory.length() == 0) {
                    System.out.println("Group: default");
                }
                //2. имаме цифри в паролата
                else {
                    System.out.println("Group: " + sbDigitsCategory);
                }
            } else {
                System.out.println("Invalid pass!");
            }

        }
    }
}
