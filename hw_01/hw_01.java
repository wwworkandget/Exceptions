package Exception.homework;

import java.util.Scanner;

public class hw_01 {
    // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения:

    // Метод, генерирующий ArithmeticException (деление на ноль)
    public static void divideByZero() {
        int a = 10;
        int b = 0;
        int c = a / b; // Генерация исключения
    }

    // Метод, генерирующий ArrayIndexOutOfBoundsException (выход за границы массива)
    public static void arrayOutOfBounds() {
        int[] arr = new int[5];
        arr[10] = 1; // Генерация исключения
    }

    // Метод, генерирующий NullPointerException (обращение к null-объекту)
    public static void nullPointer() {
        String str = null;
        int len = str.length(); // Генерация исключения
    }

    // Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете
    // получить?
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
    // Ответ: NumberFormatException, NullPointerException,
    // ArrayIndexOutOfBoundsException, IndexOutOfBoundsException, Exception

    // Реализуйте метод, принимающий в качестве аргументов два целочисленных
    // массива,
    // и возвращающий новый массив, каждый элемент которого равен разности элементов
    // двух входящих массивов в той же ячейке.
    // Если длины массивов не равны, необходимо как-то оповестить пользователя.
    public static int[] diffArrays(int[] a, int[] b) throws IllegalArgumentException {
        if (a.length != b.length) {
            throw new RuntimeException("Длины массивов не равны!");
        }
        int n = a.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }

    /*
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных
     * массива, и возвращающий новый массив,
     * каждый элемент которого равен частному элементов двух входящих массивов в той
     * же ячейке.
     * Если длины массивов не равны, необходимо как-то оповестить пользователя.
     * Важно: При выполнении метода единственное исключение, которое пользователь
     * может увидеть - RuntimeException, т.е. ваше.
     */
    public static int[] divArrays(int[] a, int[] b) throws RuntimeException {
        if (a.length != b.length) {
            throw new RuntimeException("Длины массивов не равны!");
        }
        int n = a.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (b[i] == 0) {
                throw new RuntimeException("Деление на ноль!");
            }
            result[i] = a[i] / b[i];
        }
        return result;
    }

    // Задание 6(с презентации) Создайте boolean метод, который запросит у
    // пользователя поля: login, password и confirm password
    // Логин должен содержать только символы: a, b, c, d, e, 0,1, _, если это не так
    // нужно бросить RuntimeException с соответствующим сообщением.
    // Логин должен быть не меньше 4 и не больше 8 символов, если это не так нужно
    // бросить RuntimeException с соответствующим сообщением.
    // Пароль должен быть не меньше 4 и не больше 8 символов и состоять только из
    // цифр, если это не так нужно бросить RuntimeException с соответствующим
    // сообщением.
    // Пароль и его повтор должны совпадать, если это не так нужно бросить
    // RuntimeException с соответствующим сообщением.
    public static boolean registerUser() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите логин (только a,b,c,d,e,0,1,_): ");
        String login = sc.nextLine();
        if (!login.matches("[abcde01_]{4,8}")) {
            throw new RuntimeException(
                    "Логин должен содержать только символы: a, b, c, d, e, 0, 1, _ и быть длиной от 4 до 8 символов!");
        }

        System.out.print("Введите пароль (только цифры): ");
        String password = sc.nextLine();
        if (!password.matches("\\d{4,8}")) {
            throw new RuntimeException("Пароль должен состоять только из цифр и быть длиной от 4 до 8 символов!");
        }

        System.out.print("Повторите пароль: ");
        String confirmPassword = sc.nextLine();
        if (!confirmPassword.equals(password)) {
            throw new RuntimeException("Пароль и его повтор должны совпадать!");
        }

        return true;
    }
}
