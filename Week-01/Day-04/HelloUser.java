import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter your name!");
        String name = scanner2.nextLine();

        System.out.println("Hello, " + name);
    }
}
