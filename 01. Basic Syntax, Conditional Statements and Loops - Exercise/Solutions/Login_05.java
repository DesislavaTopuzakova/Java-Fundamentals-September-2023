package basics_recap;

import java.util.Scanner;

public class Login_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine(); //потребителското име -> "Acer"
        String password = ""; //парола -> "recA"

        for (int position = username.length() - 1; position >= 0; position--) {
            char currentSymbol = username.charAt(position); //символа на текущата позиция
            password += currentSymbol;
        }

        //имам потребителско име (username) и парола (password)

        //WHILE ЦИКЪЛ
        //повтаряме: въвеждане на парола
        //стоп: въведената парола == password
        //продължаваме: въведената парола != password

        int countWrongPassword = 0; //брой неуспешни опити
        String enteredPassword = scanner.nextLine(); //въведената парола

        while (!enteredPassword.equals(password)) {
            //грешна парола
            countWrongPassword++;
            //1. проверка дали сме блокирали профила
            if (countWrongPassword == 4) {
                System.out.printf("User %s blocked!", username);
                return;
            }

            //2. ОПИТАЙ ОТНОВО
            System.out.println("Incorrect password. Try again.");
            enteredPassword = scanner.nextLine();
        }

        //вярна парола
        System.out.printf("User %s logged in.", username);


    }
}
