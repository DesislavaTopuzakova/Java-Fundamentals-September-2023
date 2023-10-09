package methods;

import java.util.Scanner;

public class Matrix_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //брой на редове = брой на колони
        printTable(n);
    }

    //метод, който отпечатва таблицата
    public static void printTable (int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
