import static org.junit.Assert.*;


import exercises.Sum;
import org.junit.Test;

public class SumTest {

  @Test
  public void getSum1() {
    Integer[] num = {10,10,10};
    Sum one = new Sum();
    assertEquals(30, one.getSum(num));

  }
  @Test
  public void getSum2() {
    Integer[] num = null;
    Sum two = new Sum();
    assert num != null;

  }
  @Test
  public void getSum3() {
    Integer[] num = {};
    Sum three = new Sum();
    assertEquals(0,three.getSum(num));
  }
}