
public class IncrementElement {
  public static void main(String[] args) {

    int[] numbers = {1, 2, 3, 4, 5};
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 3) {
        numbers[i] = numbers[i] + 1;
      }

    }
    System.out.println(numbers[2]);

  }
}
