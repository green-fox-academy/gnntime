
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream11 {
  public static void main(String[] args) {
    Path filepath = Paths.get("gnntime/files/randomwiki.txt");
    try (Stream<String> lines = Files.lines(filepath)) {
      lines.flatMap(line -> Arrays.stream(line.split(" ")))
           .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
           .filter(word -> word.length() > 0)
           .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
           .entrySet()
           .stream()
           .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
           .limit(100)
           .forEach(System.out::println);
    } catch (IOException io) {
      System.out.println("File not found");
    }
  }
}
