import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {

  public static void main(String[] args) {
    System.out.println("Write a Stream Expression to get the even numbers from the following list:");
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    numbers.stream()
           .filter(x -> x % 2 == 0)
           .forEach(System.out::println);

    System.out.println("Write a Stream Expression to get the squared value of the positive numbers from the following list:");
    List<Integer> numbers2 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    numbers2.stream()
            .filter(x -> x > 0)
            .forEach(x -> System.out.println(x * x));

    System.out.println("Write a Stream Expression to find which number squared value is more then 20 from the following list:");
    List<Integer> numbers3 = Arrays.asList(3, 9, 2, 8, 6, 5);
    numbers3.stream()
            .filter(x -> x * x > 20)
            .forEach(System.out::println);

    System.out.println("Write a Stream Expression to get the average value of the odd numbers from the following list:");
    List<Integer> numbers4 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    numbers4.stream()
            .filter(x -> x % 2 != 0)
            .forEach(System.out::println);

    System.out.println("Write a Stream Expression to get the sum of the odd numbers in the following list:");
    List<Integer> numbers5 = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
    System.out.println(
    numbers5.stream()
            .filter(x -> x %2 != 0)
            .mapToDouble(Double::valueOf)
            .average()
            .getAsDouble()
    );

    System.out.println("Write a Stream Expression to find the uppercase characters in a string:");
    String example = "MountAin Dew";
    example.chars()
           .filter(Character::isUpperCase)
           .forEach(c -> System.out.print(Character.toString(c)));

    System.out.println("Write a Stream Expression to find the strings which starts with a given letter(as parameter), in the following list:");
    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
    String givenLetter ="C";
    cities.stream()
          .filter(element -> element.startsWith(givenLetter))
          .forEach(System.out::print);

    System.out.println("Write a Stream Expression to concatenate a Character list to a string!");
    List<Character> listOfCharacters = Arrays.asList('t', 'u', 'r', 'b', 'o');
    System.out.println(
    listOfCharacters.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining())
    );
    System.out.println("Write a Stream Expression to find the frequency of characters in a given string!");

  }
}
