package piratesbyriel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
  private List<Pirate> crew = new ArrayList<>();
  Random random = new Random();

  public void fillShip(){
    crew.add(new Captain());
    int piratesNumber = random.nextInt(10)+1;

    for (int i = 0; i < piratesNumber; i++) {
      crew.add(new Pirate());
    }
  }

  // If we do not know which one is captain
  private Captain getCaptain(){
    for (Pirate pirate :crew) {
      if (pirate instanceof Captain){
        return (Captain)pirate;
      }
    }

    return null;
  }

  public void reportStatus(){
    if (crew.size() == 0){
      System.out.println("Sorry, the ship is empty");
      return;
    }

    Pirate captan = crew.get(0);

    if (captan.getIntoxicationLevel() > 0){
      System.out.println("The captain consumed " + captan.getIntoxicationLevel() + " rums");
    }

    System.out.println("The captain is" + (captan.isPassedOut() ? "" : " not " ) + "passed out");
    System.out.println("The captain is" + (captan.isDead() ? "" : " not " ) + "dead");
    System.out.println("There are " + calculatePiratesAlive() + " pirates alive in the ship");
  }

  private int calculatePiratesAlive(){
    int counter=0;
    for (Pirate pirate : crew) {
      if (!pirate.isDead()){
        counter++;
      }
    }

    return counter;
  }

  public boolean battle(Ship enemy){
    boolean thisWins = calculateScore() > enemy.calculateScore();
    int loserCrewAliveMembers = thisWins ? enemy.calculatePiratesAlive() : calculatePiratesAlive();
    int peopleToBeKilled = random.nextInt(loserCrewAliveMembers)+1;

    int killed = 0;
    while (killed <= peopleToBeKilled){
      if (thisWins){
        Pirate enemyToBeKilled = enemy.crew.get(killed);
        if (!enemyToBeKilled.isDead()) {
          enemyToBeKilled.die();
          killed++;
        }
      } else {
        Pirate pirateToBeKilled = crew.get(killed);
        if (!pirateToBeKilled.isDead()) {
          pirateToBeKilled.die();
          killed++;
        }
      }
    }

    if(thisWins){
      party();
    } else {
      enemy.party();
    }

    return thisWins;
  }

  private int calculateScore(){
    if (crew.size() == 0){
      System.out.println("Sorry, the ship is empty");
      return 0;
    }

    int piratesAlive = calculatePiratesAlive();
    int numberOfRumsTakenByCaptain = crew.get(0).getIntoxicationLevel();
    return piratesAlive-numberOfRumsTakenByCaptain;
  }

  private void party(){
    int rums = random.nextInt(11);

    while (rums > 0){
      for (Pirate pirate : crew) {
        if (!pirate.isDead()){
          pirate.drinkSomeRum();
          rums--;
        }

        if(rums == 0){
          break;
        }
      }
    }
  }
}