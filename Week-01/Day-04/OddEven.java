import java.util.Scanner;

public class OddEven {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input a number");
    int number = scanner.nextInt();
    if (number % 2 == 0) {
      System.out.println("Even");
    } else {
      System.out.println("Odd");
    }
  }

}

