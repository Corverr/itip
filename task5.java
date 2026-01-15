import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Введите текст для поиска:");
            String text = scanner.nextLine();

            if (text == null || text.trim().isEmpty()) {
                System.out.println("Ошибка: текст не может быть пустым");
                return;
            }

            System.out.print("Введите букву для поиска: ");
            String inputLetter = scanner.nextLine();

            if (inputLetter == null || inputLetter.trim().isEmpty()) {
                System.out.println("Ошибка: буква для поиска не может быть пустой");
                return;
            }

            if (inputLetter.length() != 1) {
                System.out.println("Ошибка: необходимо ввести только одну букву");
                return;
            }

            char searchChar = inputLetter.charAt(0);

            if (!Character.isLetter(searchChar)) {
                System.out.println("Ошибка: введенный символ не является буквой");
                return;
            }

            String regex = "\\b[" + Character.toLowerCase(searchChar) + Character.toUpperCase(searchChar) + "][a-zA-Zа-яА-Яа-я]*\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            System.out.println("\nРезультаты поиска слов, начинающихся с буквы '" + searchChar + "':");
            System.out.println("Текст: " + text);

            boolean found = false;
            int count = 0;

            while (matcher.find()) {
                String word = matcher.group();
                System.out.println( word);
                found = true;
                ++count;
            }

            if (!found) {
                System.out.println("Не найдено");
            }else {
                System.out.println("Найдено слов"+"-" + count);
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Error in regular expression syntax: " + e.getMessage());
            System.out.println("Please check your regular expression pattern");
        } catch (Exception e) {
            System.out.println("Error in: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}