import java.util.Scanner;

public class OneTwoALot {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Input a number");
    int number = scanner.nextInt();
    if (number <= 0) {
      System.out.println("Not enough!");

    }
    if (number == 1) {
      System.out.println("Number is one");
    }
    if (number == 2) {
      System.out.println("Number is two");
    }
    if (number > 2) {
      System.out.println("Number is a lot");
    }
  }

}
