import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");

            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            if (pattern.matcher(password).matches()) {
                System.out.println("Пароль корректен!");
            } else {
                System.out.println("Пароль не соответствует требованиям:");

                if (password.length() < 8 || password.length() > 16) {
                    System.out.println("- Длина должна быть от 8 до 16 символов");
                }

                if (!password.matches(".*[A-Z].*")) {
                    System.out.println("- Должна быть хотя бы одна заглавная буква");
                }

                if (!password.matches(".*\\d.*")) {
                    System.out.println("- Должна быть хотя бы одна цифра");
                }

                if (!password.matches("[A-Za-z\\d]*")) {
                    System.out.println("- Разрешены только латинские буквы и цифры");
                }
            }

        } catch (PatternSyntaxException e) {
            System.out.println("Error in regular expression syntax: " + e.getMessage());
            System.out.println("Please check your regular expression pattern");
        } catch (Exception e) {
            System.out.println("Error in: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}