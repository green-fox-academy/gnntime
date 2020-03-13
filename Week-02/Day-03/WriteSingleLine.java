import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteSingleLine {
    public static void main(String[] args) {
    String name = "Gabriel";
    writeFile(name);
    }
    public static List<String> writeFile(String a) {
        List<String> content = new ArrayList<>();
        content.add(a);
        try {
            Path filePath = Paths.get("Week-02\\Day-03\\files\\my-file.txt");
            Files.write(filePath, content);
        } catch (Exception e) {
            System.out.println("Unable to write file:my-file.txt");
        }
        return content;
    }
}
