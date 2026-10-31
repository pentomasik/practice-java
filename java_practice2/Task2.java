package java_practice2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите A: ");
        double a = scanner.nextDouble();

        System.out.print("Введите N: ");
        int n = scanner.nextInt();

        double sum = 0;
        int sign = 1;

        for (int i = 1; i <= n; i++) {
            sum += sign * Math.pow(a, i);
            sign = -sign;
        }

        System.out.println("Сумма = " + sum);

        scanner.close();
    }
}
