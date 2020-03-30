package pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {

  private String name;
  private List<Pirate> crew = new ArrayList<>();
  private List<Pirate> crewAlive = new ArrayList<>();
  private Pirate captain;
  protected int score = 0;

  public Ship(String name) {
    this.name = name;
  }

  public void fillShip() {
    Random randomGenerator = new Random();
    int numberOfPirates = randomGenerator.nextInt(20 + 1);
    for (int i = 0; i < numberOfPirates; i++) {
      Pirate salty = new Pirate();
      this.crew.add(salty);
    }
    this.captain = new Pirate();
  }

  public void updateAliveCrew() {
    this.crewAlive = this.crew;
    for (Pirate pirate : this.crew) {
      if (!pirate.isAlive) {
        this.crewAlive.remove(pirate);
      }
    }
  }

  public void party() {
    Random randomGenerator = new Random();
    int numberOfRums = randomGenerator.nextInt(10);
    updateAliveCrew();
    for ( Pirate pirate : crewAlive ) {
      for (int i = 0; i < numberOfRums; i++) {
        pirate.drinkSomeRum();
      }
    }
  }

  public boolean battle(Ship otherShip) {
    updateAliveCrew();
    otherShip.updateAliveCrew();
    this.score = getAlivePirates() - captain.getRumLevel();
    otherShip.score = otherShip.getAlivePirates() - otherShip.captain.getRumLevel();
    Random randomGenerator = new Random();
    if (crewAlive.size() !=0) {
      int numberOfDeaths1 = randomGenerator.nextInt(crewAlive.size() +1);
      int numberOfDeaths2 = randomGenerator.nextInt(otherShip.crewAlive.size() +1);
      if (this.score > otherShip.score) {
        for (int i = 0; i < numberOfDeaths2; i++) {
          otherShip.crewAlive.get(i).die();
        }
        party();
        return true;
      }
      for (int i = 0; i < numberOfDeaths1; i++) {
        crewAlive.get(i).die();
      }
      otherShip.party();
      return false;
    }
    return false;
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
    String display = "The name of the ship is: " + this.name + ", the number of pirates on the ship is: " + crew.size() +
        " out of which " + getAlivePirates() + " are alive" + " The ships's captain consumed: "
        + captain.getRumLevel() + "bottles of rum. The captain's status is: " + captain.howsItGoingMate();
    return display;
  }

  public void addPirateToShip(Pirate pirate) {
    this.crew.add(pirate);
  }

  public void assignAsCaptain(Pirate pirate) {
    this.captain = pirate;
  }
}
