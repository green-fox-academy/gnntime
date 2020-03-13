public class PrintAll {
    public static void main(String[] args) {
        // with fori
        int numbers [] = {4, 5, 6, 7};
        for (int i = 0; i < numbers.length ; i++) {
            System.out.print(numbers[i] + ", ");
        }
        //with for each
        System.out.println();
        for (int number : numbers) {
            System.out.print(number + ", ");
        }

    }
}