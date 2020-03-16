import java.util.Scanner;

public class MileToKmConverter {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Input value in miles to convert:");
    double miles = scanner.nextDouble();
    double km = miles * 1.609344;
    System.out.println(km + "km");


  }
}
