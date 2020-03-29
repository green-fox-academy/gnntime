package pirates;

public class Main {

  public static void main(String[] args) {

    Pirate pirate1 = new Pirate();
    Pirate pirate2 = new Pirate();
    pirate1.die();

    Ship ship1 = new Ship("Sunny");

    ship1.assignAsCaptain(pirate2);
    ship1.addPirateToShip(pirate1);
    ship1.fillShip();
    System.out.println(ship1.getShipInfo());
    Ship ship2 = new Ship("Black Rock");
    System.out.println(ship1.battle(ship2));
    System.out.println(ship1.getShipInfo());
  }
}