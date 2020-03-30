package aircraft;

public class Main {
  public static void main(String[] args) {

    Carrier carr1 = new Carrier(100, 1000);
    Carrier carr2 = new Carrier(200, 1000);

    Aircrafts air1 = new Aircrafts();
    Aircrafts air2 = new Aircrafts();
    air1.refill(100);
    air2.refill(100);

    carr1.add(air1);
    carr1.add(air2);
    carr2.add(air2);
    carr2.add(air2);

    carr1.fight(carr2);
    System.out.println(carr2.getHealthPoints());


  }
}