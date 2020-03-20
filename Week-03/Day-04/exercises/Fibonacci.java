package exercises;

public class Fibonacci {

  public int fib(int index) {
    if (index <= 1) {
      return index;
    }
    return fib(index - 1) + fib(index - 2);
  }
}
