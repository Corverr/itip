import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class CustomFileReader {
    public static void main(String[] args) {
        try {
            List<String> lines= Files.readAllLines(Path.of("input.txt"));
            Files.write(Path.of("output.txt"), lines);
            System.out.println("File cloned");
        } catch (NoSuchFileException e) {
            System.out.println("File Not Found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
