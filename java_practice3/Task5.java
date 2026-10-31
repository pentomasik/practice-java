
package java_practice3;

import java.util.Scanner;

public class Task5 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    calculateCredit();
                    break;
                case "2":
                    showProgramInfo();
                    break;
                case "3":
                    showDeveloperInfo();
                    break;
                case "0":
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный пункт меню");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n1. Рассчитать кредит");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("0. Выход");
        System.out.print("Выберите пункт: ");
    }

    public static double readNumber(String message,
                                    boolean allowZero,
                                    boolean integerOnly) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();

                if (Double.isFinite(number)
                        && (allowZero ? number >= 0 : number > 0)
                        && (!integerOnly || number % 1 == 0)) {
                    return number;
                }
            } else {
                String input = scanner.next();

                if (input.equals("exit")) {
                    return -1;
                }
            }

            System.out.println("Неверное значение! Повторите ввод или введите exit.");
        }
    }

    public static double[] inputData() {
        System.out.println("Для возврата в меню введите exit");

        double amount = readNumber("Сумма кредита: ", false, false);
        if (amount == -1) return null;

        double rate = readNumber("Годовая ставка: ", true, false);
        if (rate == -1) return null;

        double months = readNumber("Срок в месяцах: ", false, true);
        if (months == -1) return null;

        return new double[]{amount, rate, months};
    }

    public static boolean checkData(double[] data) {
        return data[0] > 0
                && data[1] >= 0
                && data[2] > 0
                && data[2] <= Integer.MAX_VALUE;
    }

    public static double[] calculate(double[] data) {
        double amount = data[0];
        double rate = data[1];
        int months = (int) data[2];

        double r = rate / 100 / 12;
        double payment;

        if (r == 0) {
            payment = amount / months;
        } else {
            double k = Math.pow(1 + r, months);
            payment = amount * r * k / (k - 1);
        }

        double total = payment * months;
        double overpayment = total - amount;

        return new double[]{payment, total, overpayment};
    }

    public static void printResult(double[] result) {
        System.out.println("Ежемесячный платеж: " + result[0]);
        System.out.println("Общая сумма выплат: " + result[1]);
        System.out.println("Переплата: " + result[2]);
    }

    public static void calculateCredit() {
        double[] data = inputData();

        if (data == null) return;

        if (!checkData(data)) {
            System.out.println("Некорректные данные!");
            return;
        }

        double[] result = calculate(data);
        printResult(result);
    }

    public static void showProgramInfo() {
        System.out.println("Программа рассчитывает кредит и переплату.");
    }

    public static void showDeveloperInfo() {
        System.out.println("Разработчик: Переверзев Денис");
    }
}
