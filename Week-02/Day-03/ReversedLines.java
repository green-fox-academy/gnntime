import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {
  public static void main(String[] args) throws IOException {
    String origin = "files/reversed-lines.txt";
    String target = "files/reversed-lines-done.txt";
    lineReverser(origin, target);
  }

  public static void lineReverser(String origin, String target) throws IOException {
    Path filepathOrigin = Paths.get(origin);
    List<String> lines = Files.readAllLines(filepathOrigin);
    Path filepathTarget = Paths.get(target);
    List<String> linesReversed = new ArrayList<>();
    for (String line : lines) {
      char[] characters = line.toCharArray();
      char[] charactersReversed = new char[characters.length];
      for (int i = 0; i < characters.length; i++) {
        charactersReversed[i] = characters[characters.length - 1 - i];
      }
      linesReversed.add(new String(charactersReversed));

    }
    Files.write(filepathTarget, linesReversed);

  }

}
