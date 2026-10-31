
package java_practice3;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();

        int[] a = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] even = new int[n / 2];
        int[] odd = new int[(n + 1) / 2];

        for (int i = 1; i < n; i += 2) {
            even[i / 2] = a[i];
        }

        for (int i = 0; i < n; i += 2) {
            odd[i / 2] = a[i];
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        for (int x : even) {
            System.out.print(x + " ");
        }

        for (int x : odd) {
            System.out.print(x + " ");
        }

        scanner.close();
    }
}
