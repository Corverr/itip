import java.util.regex.*;

public class task1 {
    public static void main(String[] args) {
        String text = "243 65gfbv6  65 54w g57";

        try{
            Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+");
            Matcher matcher = pattern.matcher(text);

            System.out.println("Found numbers:");

            boolean numbersFound = false;

            while (matcher.find()) {
                String number = matcher.group();
                System.out.println(number);
                numbersFound = true;
            }

            if (!numbersFound) {
                System.out.println("No numbers found in the text");
            }
        }  catch (PatternSyntaxException e) {
            System.out.println("Error in regular expression syntax: " + e.getMessage());
            System.out.println("Please check your regular expression pattern");
        } catch (Exception e) {
            System.out.println("Error in: " + e.getMessage());
        }
    }
}