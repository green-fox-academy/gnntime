public class Pirate {

  protected String name;
  private int amountOfGold;
  private int healthPoints;
  private boolean isCaptain;
  private boolean hasAWoodenLeg;


  public Pirate(String name) {
    this.name = name;
    this.amountOfGold = 10;
    this.healthPoints = 10;
  }

  public void setCaptain(boolean captain) {
    isCaptain = captain;
  }

  public boolean isCaptain() {
    return isCaptain;
  }

  public void setHasAWoodenLeg(boolean hasAWoodenLeg) {
    this.hasAWoodenLeg = hasAWoodenLeg;
  }

  public boolean isHasAWoodenLeg() {
    return hasAWoodenLeg;
  }

  public void work(){
    if (isCaptain) {
      this.amountOfGold = this.amountOfGold + 10;
      this.healthPoints = this.healthPoints - 5;
    }
   this.amountOfGold = this.amountOfGold + 1;
   this.healthPoints = this.healthPoints - 1;
 }

 public void party(){
    if (isCaptain) {
      this.healthPoints = this.healthPoints + 10;
    }
   this.healthPoints = this.healthPoints + 1;
 }

  public int getAmountOfGold() {
    return amountOfGold;
  }

  @Override
  public String toString() {
    if (hasAWoodenLeg) {
      return "Hello, I'm " + this.name + " I have a wooden leg " + amountOfGold + " golds";
    }
    return  "Hello, I'm " + this.name + " I still have my real legs and " + amountOfGold + " golds";
 }
}
