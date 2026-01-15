import java.util.regex.PatternSyntaxException;

public class task3 {
    public static void main(String[] args) {
        String text = "helloWorld isVery popularPhrase";
        System.out.println("Исходный текст: " + text);

        try {
            String result = text.replaceAll("([a-z])([A-Z])", "$1!$2");
            System.out.println("Текст с выделением: " + result);

        } catch (PatternSyntaxException e) {
            System.out.println("Error in regular expression syntax: " + e.getMessage());
            System.out.println("Please check your regular expression pattern");
        } catch (Exception e) {
            System.out.println("Error in: " + e.getMessage());
        }
    }
}