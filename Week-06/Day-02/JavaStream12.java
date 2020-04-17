import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
public class JavaStream12 {
  public static void main(String[] args) throws IOException {
    List<String> lines = new ArrayList<>();
    List<Person> people = new ArrayList<>();
    Path filePath = Paths.get("gnntime/files/starwarscharacters.txt");
    try {
      lines = Files.readAllLines(filePath);
    } catch (NoSuchFileException nsf) {
      System.out.println("No such file");
    }
    lines.stream()
         .skip(1)
         .map(String::trim)
         .toArray()



    List<Person> people = new ArrayList<>();
    for (String line : lines) {
      String[] dataInArray = line.split(";");
      people.add(new Person(dataInArray[0], Integer.parseInt(dataInArray[1]), Integer.parseInt(dataInArray[2]),
          dataInArray[3], dataInArray[4], dataInArray[5], dataInArray[6], dataInArray[7]));
    }
    System.out.println(people);
    System.out.println(lines);
  }
}
*/
