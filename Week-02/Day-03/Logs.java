import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logs {

  public static void main(String[] args) {



  }


  public static List<String> readFileIntoArrayList(String filePath) throws IOException {
    List<String> lines = new ArrayList<>();
    Path fileName = Paths.get(filePath);
    try {
      lines = Files.readAllLines(fileName);
    } catch (IOException io) {
      throw new IOException("File does not exist.");
    }
    return lines;
  }

}
