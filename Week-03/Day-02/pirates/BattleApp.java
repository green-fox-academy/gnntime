package pirates;

public class BattleApp {

  public static void main(String[] args) {
  Ship ship1 = new Ship("Bloody");
  Ship ship2 = new Ship("Mary");
  ship1.fillShip();
  ship2.fillShip();
    System.out.println(ship1.battle(ship2));
    System.out.println(ship1.getShipInfo());
  }
}
