import java.util.Scanner;

public class DrawTriangle {
  public static void main(String[] args) {
    int linesNumber;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Give the number of lines");
    linesNumber = scanner.nextInt();
    for (int i = 1; i <= linesNumber; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

  }
}
