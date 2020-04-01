package piratesbyriel;

import java.util.ArrayList;
import java.util.List;
import pirates.Ship;

public class Armada {
  private List<Ship> ships = new ArrayList<>();

  public boolean war(Armada enemy){
    int indexOfThis = 0;
    int indexOfEnemy = 0;

    while (indexOfThis < ships.size() && indexOfEnemy < enemy.ships.size()){
      boolean thisWins = ships.get(indexOfThis).battle(enemy.ships.get(indexOfEnemy));
      if (thisWins){
        indexOfEnemy++;
      } else {
        indexOfThis++;
      }
    }

    return indexOfThis<indexOfEnemy;
  }

  public void addShip(Ship ship){
    ships.add(ship);
  }
}