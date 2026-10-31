
package java_practice2;

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

                if ((allowZero ? number >= 0 : number > 0)
                        && Double.isFinite(number)
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

    public static double calculatePayment(double amount,
                                          double rate,
                                          int months) {
        double r = rate / 100 / 12;

        if (r == 0) {
            return amount / months;
        }

        double k = Math.pow(1 + r, months);

        return amount * r * k / (k - 1);
    }

    public static void calculateCredit() {
        System.out.println("Для возврата в меню введите exit");

        double amount = readNumber("Сумма кредита: ", false, false);
        if (amount == -1) return;

        double rate = readNumber("Годовая ставка: ", true, false);
        if (rate == -1) return;

        double monthsValue = readNumber("Срок в месяцах: ", false, true);
        if (monthsValue == -1) return;

        if (monthsValue > Integer.MAX_VALUE) {
            System.out.println("Слишком большой срок кредита");
            return;
        }

        int months = (int) monthsValue;

        double payment = calculatePayment(amount, rate, months);
        double total = payment * months;

        System.out.println("Ежемесячный платеж: " + payment);
        System.out.println("Общая сумма выплат: " + total);
        System.out.println("Переплата: " + (total - amount));
    }

    public static void showProgramInfo() {
        System.out.println("Программа рассчитывает кредит и переплату.");
    }

    public static void showDeveloperInfo() {
        System.out.println("Переверзев Денис ");
    }
}
