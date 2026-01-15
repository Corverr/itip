import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите IP-адрес: ");
        String ipAddress = scanner.nextLine();

        try {
            Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

            if (pattern.matcher(ipAddress).matches()) {
                System.out.println("IP-адрес корректен!");

            } else {
                System.out.println("IP-адрес некорректен!");
                
                if (!ipAddress.matches("^[0-9.]+$")) {
                    System.out.println("- Содержит недопустимые символы (можно использовать только цифры и точки)");
                }

                String[] parts = ipAddress.split("\\.");
                if (parts.length != 4) {
                    System.out.println("- Должен содержать ровно 4 числа, разделенные точками");
                } else {
                    for (int i = 0; i < parts.length; i++) {
                        if (parts[i].isEmpty()) {
                            System.out.println("- часть " + (i + 1) + ": пустая");
                        } else {
                            try {
                                int num = Integer.parseInt(parts[i]);
                                if (num < 0 || num > 255) {
                                    System.out.println("- часть " + (i + 1) + ": число " + num + " вне диапазона 0-255");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("- часть " + (i + 1) + ": '" + parts[i] + "' не является числом");
                            }
                        }
                    }
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