package pirates;

import java.util.Random;

public class Pirate {

  private String status;
  protected boolean isAlive;
  private int rumLevel;
  private int brawlChance;
  private boolean isPassedOut;

  public Pirate() {
    this.status = "";
    this.isAlive = true;
    this.rumLevel = 0;
    this.isPassedOut = false;
    this.brawlChance = randomizeBrawlChance();
  }

  public int getRumLevel() {
    return rumLevel;
  }

  public void drinkSomeRum() {
    this.rumLevel++;
  }

  public void die() {
    this.isAlive = false;
  }

  public int randomizeBrawlChance() {
    Random randomGenerator = new Random();
    return randomGenerator.nextInt(9);
  }

  public void brawl(Pirate otherPirate) {
    if (otherPirate.isAlive) {
      if (this.brawlChance > otherPirate.brawlChance) {
        die();
      } else if (this.brawlChance < otherPirate.brawlChance) {
        otherPirate.die();
      } else if ((this.brawlChance >= 6)) {
        this.isPassedOut = true;
        otherPirate.isPassedOut = true;
      }
    }
  }

  public String howsItGoingMate() {
    if (this.isAlive) {
      if (!isPassedOut) {
        if (this.rumLevel < 5) {
          this.status = "Pour me another";
        } else {
          this.status = "Arghh, I'ma Pirate. How d'ya d'ink its goin?";
        }
      } else {
        this.status = "he's passed out";
      }
    } else {
      this.status = "he's dead";
    }
    return this.status;
  }
}
