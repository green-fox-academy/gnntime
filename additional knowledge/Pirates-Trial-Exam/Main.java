public class Main {

  public static void main(String[] args) {

    Pirate pirate1 = new Pirate("Jack");
    Pirate pirate2 = new Pirate("John");
    Pirate pirate4 = new Pirate("Johny");
    Pirate pirate3 = new Pirate("Hank");
    pirate2.setCaptain(true);
    pirate2.setHasAWoodenLeg(false);
    pirate4.setHasAWoodenLeg(true);
    pirate3.setHasAWoodenLeg(true);
    Ship ship1 = new Ship();
    ship1.addPirate(pirate1);
    ship1.addPirate(pirate2);
    ship1.addPirate(pirate2);
    ship1.addPirate(pirate2);
    ship1.addPirate(pirate2);
    ship1.addPirate(pirate4);
    ship1.addPirate(pirate4);
    ship1.addPirate(pirate4);
    ship1.addPirate(pirate3);
    pirate4.work();
    pirate4.work();
    pirate4.work();
    pirate4.work();
    pirate4.work();

    ship1.prepareForBattle();

    System.out.println(ship1.getListOfPirates().toString());
    System.out.println(ship1.getPoorPirates().toString());
    System.out.println(ship1.getGolds());
  }
}
