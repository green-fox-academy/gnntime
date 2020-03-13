import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me the first number");
        int firstNumber = scanner.nextInt();
        System.out.println("Give me the second number");
        int secondNumber = scanner.nextInt();

        if (firstNumber > secondNumber) {
            System.out.println("The bigger number is: " + firstNumber);
        } else {
            System.out.println("The bigger number is: " + secondNumber);
        }


    }
}
