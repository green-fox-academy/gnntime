import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedOrder {
  public static void main(String[] args) throws IOException {
    String origin = "files/reversed-order.txt";
    String target = "files/reversed-order-done.txt";
    orderReverser(origin, target);
  }

  public static void orderReverser(String origin, String target) throws IOException {
    Path filepathOrigin = Paths.get(origin);
    Path filepathTarget = Paths.get(target);
    List<String> linesToReverse = Files.readAllLines(filepathOrigin);
    List<String> reversedLines = new ArrayList<>(linesToReverse);
    //adding lines with .add
    /*
    for (int i = 0; i < linesToReverse.size(); i++) {
      String line = linesToReverse.get(linesToReverse.size() - i - 1);
      reversedLines.add(line);
    }
    */
    //adding lines with .set

    for (int i = 0; i < linesToReverse.size() ; i++) {
      reversedLines.set(i, linesToReverse.get(linesToReverse.size() -i -1));
    }

    Files.write(filepathTarget, reversedLines);
  }

}
