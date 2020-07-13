import java.util.HashMap;

public class MapIntroduction1 {
  public static void main(String[] args) {
    HashMap<Integer, String> practiceMap = new HashMap<>();

    //Print out whether the map is empty or not
    System.out.println(practiceMap.isEmpty());
    System.out.println("The hashmap is not empty");

    //add the values
    practiceMap.put(97, "a");
    practiceMap.put(98, "b");
    practiceMap.put(99, "c");
    practiceMap.put(65, "A");
    practiceMap.put(66, "B");
    practiceMap.put(67, "C");

    //print all the keys
    for (Integer key : practiceMap.keySet()) {
      System.out.println(key);
    }

    //print all the values
    for (String values : practiceMap.values()) {
      System.out.println(values);
    }

    //Add value D with the key 68
    practiceMap.put(68, "D");

    //Print how many key-value pairs are in the map
    System.out.println(practiceMap.size());

    //Print the value that is associated with key 99
    System.out.println(practiceMap.get(99));

    //Remove the key-value pair where the key is 97
    practiceMap.clear();

  }

}
