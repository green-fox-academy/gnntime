import static org.junit.Assert.*;


import exercises.Fibonacci;
import org.junit.Test;

public class FibonacciTest {

  @Test
  public void fib() {
    Fibonacci example = new Fibonacci();
    assertEquals(55, example.fib(10));
  }

  @Test
  public void fibIsZero() {
    Fibonacci example = new Fibonacci();
    assertEquals(0, example.fib(0));
  }
}