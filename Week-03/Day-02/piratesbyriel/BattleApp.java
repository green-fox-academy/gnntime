package piratesbyriel;

public class BattleApp {
  public static void main(String[] args) {
    Ship ship1 = new Ship();
    ship1.fillShip();

    Ship ship2 = new Ship();
    ship2.fillShip();

    boolean firstWins = ship1.battle(ship2);
    System.out.println((firstWins ? "First" : "Second") + " ship won the battle");
  }
}