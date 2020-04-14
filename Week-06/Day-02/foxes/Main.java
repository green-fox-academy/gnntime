package foxes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
/*  Create a Fox class with 3 properties:name, color and age Fill a list with at least 5 foxes and:

  Write a Stream Expression to find the foxes with green color!
  Write a Stream Expression to find the foxes with green color, and age less then 5 years!
  Write a Stream Expression to find the frequency of foxes by color!*/

  public static void main(String[] args) {

  List<Fox> foxDen = Arrays.asList(new Fox("Pauli", "green", 5),
                                   new Fox("Helen", "blue", 6),
                                   new Fox("Charles", "red", 10),
                                   new Fox("Dixy", "brown", 3),
                                   new Fox("Foxy", "green", 4));

  foxDen.stream()
        .filter(fox -> fox.getColor().equals("green"))
        .forEach(fox -> System.out.println(fox.getName()));
  foxDen.stream()
        .filter(fox -> fox.getColor().equals("green") && fox.getAge() < 5)
        .forEach(fox -> System.out.println(fox.getName()));
    Map<String, Long> frequencyOfColor = foxDen.stream()
          .collect(Collectors.groupingBy(Fox::getColor, Collectors.counting()));
    System.out.println(frequencyOfColor);
  }
}
