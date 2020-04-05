import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonCharacters {
  public static void main(String[] args) throws Exception {

    System.out.println(returnMostCommonCharacters());

  }

  private static Map<Character, Integer> returnMostCommonCharacters() throws Exception {
    Path filepath = Paths.get("assets/MostCommonCharacters.txt");
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(filepath);
    } catch (IOException io) {
      throw new IOException("File does not exist");
    }
    Map<Character, Integer> characterOccurences = countCharacterOccurences(lines);
    Map<Character, Integer> result = selectMostCommonCharacters(characterOccurences, 2);
    return result;
  }

  private static Map<Character, Integer> selectMostCommonCharacters(Map<Character, Integer> characterOccurences, int limit) {
    Map<Character, Integer> result = new HashMap<>();
    while (result.size() < limit){
      int maxOccurences = 0;
      Character actualChar = null;
      for (Map.Entry<Character, Integer> entry : characterOccurences.entrySet()) {
        if (entry.getValue() > maxOccurences){
          maxOccurences = entry.getValue();
          actualChar = entry.getKey();
        }
      }
      result.put(actualChar, maxOccurences);
      characterOccurences.remove(actualChar);
    }
    return result;
  }

  private static Map<Character, Integer> countCharacterOccurences(List<String> lines) {
    Map<Character, Integer> result = new HashMap<>();
    for (String line :lines) {
      for (int i = 0; i < line.length(); i++) {
        Character actualChar = line.charAt(i);
        if (result.containsKey(actualChar)){
          result.put(actualChar, result.get(actualChar) +1);
        } else {
          result.put(actualChar, 1);
        }
      }
    }
    return result;
  }
}