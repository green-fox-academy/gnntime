package hammingdistance;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class HammingDistanceTest {

  @Test
  public void getHammingDistance1() throws Exception {
    HammingDistance hamming = new HammingDistance();
    String exampleString ="apple";
    List<String> exampleList = new ArrayList<>();
    exampleList.add("apple");
    exampleList.add("tuple");
    exampleList.add("alter");
    exampleList.add("apply");
    List<String> testList = new ArrayList<>();
    testList.add("apple");
    testList.add("tuple");
    testList.add("apply");
    assertEquals(testList.size(), HammingDistance.getHammingDistance(exampleString, exampleList).size());
  }

  @Test
  public void getHammingDistance2() throws Exception {
    HammingDistance haming = new HammingDistance();
    List<String> exampleList = new ArrayList<>();
    exampleList.add("donkey");
    exampleList.add("monday");
    exampleList.add("shaker");
    List<String> testList = new ArrayList<>();
    testList.add("donkey");
    testList.add("monday");
    assertEquals(testList.size(), HammingDistance.getHammingDistance("monkey", exampleList).size());
  }


  @Test
  public void hammingDistCounter1() {
    HammingDistance hamming = new HammingDistance();
    assertEquals(1, HammingDistance.hammingDistCounter("apple", "apply"));
  }

  @Test
  public void hammingDistCounter2() {
    HammingDistance hamming = new HammingDistance();
    assertEquals(5, HammingDistance.hammingDistCounter("apple", "12345"));
  }

}