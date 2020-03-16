import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class CountLines {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input a file name");
    String filename = scanner.next();
    try {
      Path filePath = Paths.get("files/" + filename);
      List<String> lines = Files.readAllLines(filePath);
      for (String line : lines) {

      }
      System.out.println(lines.size());
    } catch (Exception e) {
      filename = null;
    }

  }
}
