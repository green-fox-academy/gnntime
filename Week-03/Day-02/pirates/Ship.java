package pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {

  private String name;
  private List<Pirate> crew = new ArrayList<>();
  private int crewSize = 0;
  private Pirate captain;
  private int score = 0;

  public Ship(String name) {
    this.name = name;
  }

  public void fillShip() {
    Random randomGenerator = new Random();
    int numberOfPirates = randomGenerator.nextInt(20 + 1);
    for (int i = 0; i < numberOfPirates; i++) {
      Pirate salty = new Pirate();
      this.crew.add(salty);
      this.crewSize++;
    }
    this.captain = new Pirate();
  }

  public boolean battle(Ship otherShip) {
    this.score = getAlivePirates() - captain.getRumLevel();
    Random randomGenerator = new Random();
    int numberOfDeaths = randomGenerator.nextInt(score * 2 - 1);
    int numberOfRums = randomGenerator.nextInt(10000);
    if (this.score > otherShip.score) {
      for (int i = 0; i < crew.size() + numberOfDeaths/2; i++) {
        crew.get(i).die();
        otherShip.crew.get(i).die();
      }
      for (int i = 0; i < getAlivePirates() ; i++) {
        for (int j = 0; j < numberOfRums; j++) {
          crew.get(i).drinkSomeRum();
          captain.drinkSomeRum();
        }
      }
      return true;
    } else {
      for (int i = 0; i < getAlivePirates() ; i++) {
        for (int j = 0; j < numberOfRums; j++) {
          crew.get(i).drinkSomeRum();
          captain.drinkSomeRum();
        }
      }
      return false;
    }
  }

  public int getAlivePirates() {
    int numberOfAlivePirates = 0;
    for (Pirate pirate : this.crew) {
      if (pirate.isAlive) {
        numberOfAlivePirates++;
      }
    }
    return numberOfAlivePirates;
  }

  public String getShipInfo() {
    String display = "The name of the ship is: " + this.name + ", the number of pirates on the ship is: " + crewSize +
        " out of which " + getAlivePirates() + " are alive" + " The ships's captain consumed: "
        + captain.getRumLevel() + "bottles of rum. The captain's status is: " + captain.howsItGoingMate();
    return display;
  }

  public void addPirateToShip(Pirate pirate) {
    this.crew.add(pirate);
    this.crewSize++;
  }

  public void assignAsCaptain(Pirate pirate) {
    this.captain = pirate;
    this.crewSize++;
  }
}
