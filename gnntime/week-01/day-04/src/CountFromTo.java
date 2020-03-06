import java.util.Scanner;

public class CountFromTo {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give two numbers");
        a = scanner.nextInt();
        b = scanner.nextInt();
        if (b < a) {
            System.out.println("The second number should be bigger.");
        } else for (a = a; a < b; a++) {
            System.out.println(a);
        }



    }
}