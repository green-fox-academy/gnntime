import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logs {

  public static void main(String[] args) throws IOException {
    System.out.println(uniqueIpadresses());
    System.out.println(getPostRatio());
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

  public static List<String> uniqueIpadresses() throws IOException {
      List<String> lines = readFileIntoArrayList("files/logs.txt");
        HashMap<String, Integer> ipHashmap = new HashMap<>();
      List<String> ipAdressList = new ArrayList<>();
      List<String> uniqueIpAdressList = new ArrayList<>();
      for (String line : lines ) {
        ipAdressList.add(line.substring(27, 38));
      }
      for (String ip : ipAdressList) {
        if (ipAdressList.contains(ip)) {
          ipHashmap.put(ip, 1);
        }
      }
      for (Map.Entry<String, Integer> entry : ipHashmap.entrySet()) {
        uniqueIpAdressList.add(entry.getKey());
      }
      return uniqueIpAdressList;
  }

  public static double getPostRatio() throws IOException {
    List<String> lines = readFileIntoArrayList("files/logs.txt");
    double getCounter = 0;
    double postCounter = 0;
    for (String line : lines ) {
      if (line.contains("GET")) {
        getCounter++;
      } else if (line.contains("POST")) {
        postCounter++;
      }
    }
    return getCounter / postCounter;
  }
}
