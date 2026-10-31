
package java_practice3;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите M: ");
        int m = scanner.nextInt();

        System.out.print("Введите N: ");
        int n = scanner.nextInt();

        System.out.print("Введите D: ");
        int d = scanner.nextInt();

        int[][] a = new int[m][n];

        System.out.println("Введите " + m + " чисел:");

        for (int i = 0; i < m; i++) {
            a[i][0] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = a[i][j - 1] + d;
            }
        }

        System.out.println("Полученная матрица:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
