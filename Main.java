import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        try {
            System.out.print("Введите мин. длину пароля: ");
            int minLenght = Integer.parseInt(sc.nextLine());
            checker.setSetMinLength(minLenght);

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int maxRepeat = Integer.parseInt(sc.nextLine());
            checker.setSetMaxRepeat(maxRepeat);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        try {
            while (true) {
                System.out.print("Введите пароль или end: ");
                String password = sc.nextLine();

                if ("end".equals(password)) {
                    break;
                }

                System.out.println(checker.verify(password) ? "Подходит" : "Не подходит!");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
