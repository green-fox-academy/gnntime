//public class Doubled {
//
//    public static void main(String[] args) {
//         Create a method that decrypts the duplicated-chars.txt
//
//
//    }
//}


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {
  public static void main(String[] args) {
    duplicatedDecoder("files/duplicated-chars.txt", "files/duplicated-chars_decoded.txt");
  }

  public static void duplicatedDecoder(String filepathSource, String filepathDestination) {
    Path filePathFrom = Paths.get(filepathSource);
    Path filePathTo = Paths.get(filepathDestination);
    try {
      List<String> lines = Files.readAllLines(filePathFrom);
      List<String> linesDecoded = new ArrayList<String>();
      for (String line : lines) {
        char[] characters = line.toCharArray();
        char[] charactersDecoded = new char[characters.length / 2];
        for (int i = 0; i < characters.length; i += 2) {
          charactersDecoded[i / 2] = characters[i];
        }


        linesDecoded.add(new String(charactersDecoded));
      }
      Files.write(filePathTo, linesDecoded);
    } catch (IOException e) {
      System.out.println("could not read file");
    }
  }
}