import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Births {

  public static void main(String[] args) {
    // Create a function that
    // - takes the name of a CSV file as a parameter,
    //   - every row is in the following format: <person name>;<birthdate in YYYY-MM-DD format>;<city name>
    // - returns the year when the most births happened.
    //   - if there were multiple years with the same number of births then return any one of them

    // You can find such a CSV file in this directory named births.csv
    // If you pass "births.csv" to your function, then the result should be either 2006, or 2016.
    yearWhenMostBirthsHappened("files/births.txt");
    System.out.println(yearWhenMostBirthsHappened("files/births.txt"));
  }

  public static String yearWhenMostBirthsHappened(String fileOrigin) {
    HashMap<String, Integer> births = new HashMap<>();
    List<String> lines = new ArrayList<>();
    List<String> listOfDates = new ArrayList<>();
    List<String> listOfYears = new ArrayList<>();
    Path filepath = Paths.get(fileOrigin);
    try {
      lines = Files.readAllLines(filepath);
    } catch (IOException io) {
      System.out.println("File not found");
    }
    for ( String line : lines ) {
      String[] years = line.split(";");
      listOfDates.add(years[1]);
    }
    for ( String date : listOfDates ) {
      listOfYears.add(date.substring(0, 4));
    }

    for (String years : listOfYears) {
      if (births.containsKey(years)) {
        births.put(years, births.get(years) +1);
      } else {
        births.put(years, 1);
      }
    }
    int occurence = 0;
    String year = "";
    for (Map.Entry<String, Integer> entry : births.entrySet() ) {
      if (entry.getValue() > occurence) {
        occurence = entry.getValue();
        year = entry.getKey();
      }
    }
    return year;
  }
}
