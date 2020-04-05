import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottery {

  public static void main(String[] args) {
    // Create a method that find the 5 most common lottery numbers in lottery.csv

    mostCommonLotteryNumbers("files/lottery.txt");

  }
  public static void mostCommonLotteryNumbers(String fileName) {
    List<String> lines = new ArrayList<>();
    List<Integer> numbersConverter = new ArrayList<>();
    HashMap<Integer, Integer> commonNumbers = new HashMap<>();
    Path filePath = Paths.get(fileName);
    try {
      lines = Files.readAllLines(filePath);
    } catch (NoSuchFileException nsfe) {
      System.out.println("No such file");
    }
    catch (IOException io) {
      System.out.println("Cannot read file");
    }
    catch (Exception e) {
      System.out.println("Something went wrong");
    }
    String numberInOneString = "";
    for (String line : lines) {
      String[] splitLines = line.split("Ft;");
        numberInOneString += splitLines[4];
      for ( String string : splitLines[4].split(";") ) {
        numbersConverter.add(Integer.parseInt(string));
      }
    }
    System.out.println(numbersConverter);
    for (int i : numbersConverter ) {
      if (!commonNumbers.containsKey(i) ) {
        commonNumbers.put(i, 0);
      }
      if (commonNumbers.containsKey(i)) {
        int occurence = commonNumbers.get(i);
        occurence++;
        commonNumbers.put(i, occurence);
      }
    }
    Map<Integer, Integer> result = new HashMap<>();
    while (result.size() < 5) {
      int maxOccurences = 0;
      int actualInt = 0;
      for (Map.Entry<Integer, Integer> entry : commonNumbers.entrySet()) {
        if (entry.getValue() > maxOccurences){
          maxOccurences = entry.getValue();
          actualInt = entry.getKey();
        }
      }
      result.put(actualInt, maxOccurences);
      commonNumbers.remove(actualInt);
    }
    System.out.println(result);
  }
}