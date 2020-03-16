public class FizzBuzz {
  public static void main(String[] args) {
    int a;
    for (a = 0; a < 100; a++) {
      if ((a % 3 == 0) && (a % 5 == 0)) {
        System.out.println("FizzBuzz");
      } else if (a % 3 == 0) {
        System.out.println("Fizz");
      } else if (a % 5 == 0) {
          System.out.println("Buzz");
      } else {
          System.out.println(a);
      }

    }

  }
}
