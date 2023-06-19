package exc_HW2;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        inputFloat();
    }

    private static float inputFloat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите число типа float: ");
                String input = scanner.nextLine();
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Введены некорректные данные");
            }
            scanner.close();
        }
    }

}