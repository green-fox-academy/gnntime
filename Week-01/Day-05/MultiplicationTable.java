import java.util.Scanner;

public class MultiplicationTable {
  public static void main(String[] args) {

    int a, b;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input a number:");
    a = scanner.nextInt();

    for (b = 1; b <= 10; b++) {
      System.out.println(a + " * " + b + " = " + (a * b));

    }
  }
}

