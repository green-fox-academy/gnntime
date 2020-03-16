public class divideByZero {
  public static void main(String[] args) {

    divide(500);
  }

  public static void divide(int divided) {
    int divisor = 10;
    if (divided == 0) {
      throw new ArithmeticException("fail");
    } else {
      System.out.println("Result is " + (divided / divisor));
    }

  }
}
