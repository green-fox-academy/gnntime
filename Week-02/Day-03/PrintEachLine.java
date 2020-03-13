import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrintEachLine {

    public static void main(String[] args) {

    String target ="files/cars.txt";
    printLine(target);
    }
    public static void printLine (String origin) {
        try {
            Path filePath = Paths.get(origin);
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Unable to read " + origin);
        }


    }
}
