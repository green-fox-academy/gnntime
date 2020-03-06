import java.util.Scanner;

public class PartyIndicator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println("How many girls are coming to the party?");
        int girls = scanner.nextInt();

        System.out.println("How many boys are coming to the party?");
        int boys = scanner.nextInt();
        int people = boys + girls;

        if (boys == girls && people >= 20) {
            System.out.println("The party is excellent!");
        }

        if (boys != girls && people <= 20) {
            System.out.println("Quite cool party!");
        }

        if (people < 20) {
            System.out.println("Average Party...");
        }

        if (girls == 0) {
            System.out.println("Sasusage party");
        }

    }
}
