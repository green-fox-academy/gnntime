package exercises;

public class Sum {

  int sum;

  public int getSum(Integer[] numbers) {
    try {
      for (int value : numbers) {
        this.sum += value;
      }
    } catch (NullPointerException e) {
      return 0;
    }
    return sum;
  }
}
