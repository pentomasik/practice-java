package java_practice2;

public class Task4 {
    public static double perimeter(double x1, double x2, double y1, double y2) {
        double a = Math.abs(x2 - x1);
        double b = Math.abs(y2 - y1);
        return 2 * (a + b);
    }
    public static void main(String[] args) {
        System.out.println("Периметр по координатам");
        double result = perimeter(1, 4, 2, 6);
        System.out.println("Периметр = " + result);
    }
}
