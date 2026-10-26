
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите A: ");
        double a = scanner.nextDouble();

        System.out.print("Введите B: ");
        double b = scanner.nextDouble();

        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }

        System.out.println("A = " + a);
        System.out.println("B = " + b);

        scanner.close();
    }
}
