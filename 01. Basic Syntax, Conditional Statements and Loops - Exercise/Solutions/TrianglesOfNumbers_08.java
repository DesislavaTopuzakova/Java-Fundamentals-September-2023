package basics_recap;

import java.util.Scanner;

public class TrianglesOfNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //n == брой редове, които трябва да отпечатаме

        for (int row = 1; row <= n; row++) { //брой на редовете
            //какво печатам за всеки един ред
            for (int number = 1; number <= row; number++) { //колко пъти отпечатвам номера на реда
                System.out.print(row + " ");
            }
            System.out.println();
        }

    }
}
