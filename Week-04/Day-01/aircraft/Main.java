package aircraft;

public class Main {
  public static void main(String[] args) throws Exception {

    Carrier carr1 = new Carrier(100, 1000);
    Carrier carr2 = new Carrier(200, 1000);

    Aircrafts f16 = new F16();
    Aircrafts f35 = new F35();
    f16.refill(100);
    f35.refill(100);

    carr1.add(f16);
    carr1.add(f35);
    carr2.add(f35);
    carr2.add(f35);

    System.out.println(carr1.aircraftsList.get(0).getStatus());
    carr1.fight(carr2);
    try {
      carr1.fill();
    }
    catch (Exception e) {
      System.out.println("No ammo to fill...");
      return;
    }


    System.out.println(carr2.getHealthPoints());
    carr1.fight(carr2);
    carr1.fill();
    System.out.println(carr2.status());
    System.out.println(carr1.status());



  }
}