import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите число x: ");
    double x = scanner.nextDouble();
    double result = (Math.pow(Math.cos(x), 3)) - (Math.sin(2 * x)) + Math.cos(x) / Math.sin(x);
    System.out.println("Результат: " + result);
        
    }
}