package counter;

public class Counter {
  int integerValue = 0;
  int defaultValue = 0;

  public Counter() {
  }
  public Counter(int startAt) {
    this.integerValue = startAt;
    this.defaultValue = startAt;
  }
  public void add() {
    integerValue += 1;
  }
  public void add(int number) {
    integerValue = integerValue + number;
  }
  public int get() {
    return integerValue;
  }
  public void reset() {
    integerValue = defaultValue;
  }
}
