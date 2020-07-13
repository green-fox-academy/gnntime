public class Reverse {
  public static void main(String[] args) {

    String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
    System.out.print(reverse(toBeReversed));
  }

  public static String reverse(String original) {
    StringBuilder reversed = new StringBuilder();
    for (int i = original.length() - 1; i >= 0; i--) {
      reversed.append(original.charAt(i));
    }
    return reversed.toString();
  }
}
