import static org.junit.Assert.assertEquals;


import exercises.CountLetters;
import java.util.Collections;
import java.util.HashMap;
import org.junit.Test;

public class CountLettersTest {

  @Test
  public void countLetters() {
    String word = "pendulum";
    CountLetters one = new CountLetters();
    System.out.println(Collections.singletonList(one.countLetters(word)));
    HashMap<Character, Integer> compare = new HashMap<>();
    compare.put('p', 1);
    compare.put('d', 1);
    compare.put('e', 1);
    compare.put('u', 2);
    compare.put('l', 1);
    compare.put('m', 1);
    compare.put('n', 1);
    assertEquals(compare, one.countLetters(word));
  }
}