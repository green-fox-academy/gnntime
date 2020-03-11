public class Reverse {
    public static void main(String[] args) {
        String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        System.out.print(reverse(toBeReversed));

    }
    public static String reverse(String original){
        String reversed ="";
        for (int i = original.length()-1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
            }
        return reversed;
    }
}
