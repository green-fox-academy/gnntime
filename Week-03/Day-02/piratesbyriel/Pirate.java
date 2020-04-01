package piratesbyriel;


import java.util.Random;

public class Pirate {
  private int intoxicationLevel;
  private boolean isPassedOut;
  private boolean isDead;
  private Parrot parrot;

  public void drinkSomeRum(){
    if (isDead){
      System.out.println("he's dead");
      return;
    }

    intoxicationLevel ++;
  }

  public void howsItGoingMate(){
    if (isDead){
      System.out.println("he's dead");
      return;
    } else {
      if (intoxicationLevel < 5){
        System.out.println("Pour me anudder!");
      } else {
        System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        isPassedOut = true;
      }
    }
  }

  public void sleep(){
    if (isDead){
      System.out.println("he's dead");
      return;
    }
    intoxicationLevel=0;
    isPassedOut = false;
  }

  public void die(){
    isDead = true;
  }

  public void brawl(Pirate enemy){
    if (isDead || enemy.isDead){
      return;
    }

    Random random = new Random();
    int chance = random.nextInt(3);

    if (chance == 0){
      isDead = true;
    } else if (chance == 1) {
      enemy.isDead = true;
    } else {
      isPassedOut = true;
      enemy.isPassedOut = true;
    }
  }

  public void addParrot(Parrot parrot){
    this.parrot = parrot;
  }

  public int getIntoxicationLevel() {
    return intoxicationLevel;
  }

  public boolean isPassedOut() {
    return isPassedOut;
  }

  public boolean isDead() {
    return isDead;
  }

  public void setDead(boolean dead) {
    isDead = dead;
  }
}