
package java_practice3;

import java.util.Scanner;
import java.util.Arrays;

public class Task3 {

    public static int[] createB(int[] a) {
        int[] b = new int[a.length];

        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            b[i] = sum;
        }

        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите N: ");
        int n = scanner.nextInt();

        int[] a = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] b = createB(a);

        System.out.println("Массив B: " + Arrays.toString(b));

        scanner.close();
    }
}
