package piratesbyriel;
import java.util.Random;

public class WarApp {
  public static void main(String[] args) {
    Random random = new Random();
    Armada armada1 = new Armada();
    Armada armada2 = new Armada();

    int ships = random.nextInt(9)+1;

    for (int i = 0; i < ships; i++) {
      boolean toFirstArmada = random.nextBoolean();

      Ship ship = new Ship();
      ship.fillShip();

      if (toFirstArmada) {
        armada1.addShip(ship);
      } else {
        armada2.addShip(ship);
      }
    }

    boolean firstWins = armada1.war(armada2);
    System.out.println("The " + (firstWins ? "first" : "second") + " armada won the battle");
  }
}