public

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные - Фамилия, Имя, Отчество, " +
                    "дата рождения(dd.mm.yyyy), номер телефона и пол(f или m) через пробел:");
            String userData = scanner.nextLine();
            String[] dataArr = userData.split(" ");
            if (dataArr.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }
            String lastName = dataArr[0];
            String firstName = dataArr[1];
            String patronymic = dataArr[2];
            String dateOfBirth = dataArr[3];
            String phoneNumber = dataArr[4];
            String gender = dataArr[5];

            if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }
            if (!phoneNumber.matches("\\d+")) {
                throw new IllegalArgumentException("Неверный формат номера телефона");
            }
            if (!gender.matches("[mf]")) {
                throw new IllegalArgumentException("Неверный формат пола");
            }

            String fileName = lastName + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(String.format("<%s><%s><%s><%s><%s><%s>",
                        lastName, firstName, patronymic, dateOfBirth, phoneNumber, gender));
                writer.newLine();
            }

            System.out.println("Данные сохранены в файл " + fileName);

        } catch (IllegalArgumentException e) {
            System.out.println("Неверный формат данных: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}