import java.util.Scanner;

public class DrawPyramid {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Number of lines for your pyramid?");
    int rows = scanner.nextInt();
    int k = 0;

    for (int i = 1; i <= rows; ++i, k = 0) {
      for (int empty = 1; empty <= rows - i; ++empty) {
        System.out.print("  ");
      }

      while (k != 2 * i - 1) {
        System.out.print("* ");
        ++k;
      }

      System.out.println();
    }
  }
}


