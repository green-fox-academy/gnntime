package counter;

public class Main {
  public static void main(String[] args) {
    Counter one = new Counter();
    Counter two = new Counter(5);
    one.add();
    one.add(3);
    one.add(3);
    System.out.println(one.get());
    System.out.println(two.get());
  }
}
