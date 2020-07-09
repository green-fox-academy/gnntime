import java.util.ArrayList;
import java.util.List;

public class Ship {

  private List<Pirate> listOfPirates;

  public Ship() {
    this.listOfPirates = new ArrayList<>();
  }

  public List<Pirate> getListOfPirates() {
    return listOfPirates;
  }

  public void setListOfPirates(List<Pirate> listOfPirates) {
    this.listOfPirates = listOfPirates;
  }

  public boolean isThereACaptain() {
    for (Pirate pirate : this.listOfPirates) {
      if (pirate.isCaptain()) {
        return true;
      }
    }
    return false;
  }

  public ArrayList<String> getPoorPirates() {
    ArrayList<String> poorPirateNames = new ArrayList<>();
    ArrayList<Pirate> poorPirates = new ArrayList<>();
    for (Pirate pirate : this.listOfPirates) {
      if ((pirate.getAmountOfGold() < 15) && (pirate.isHasAWoodenLeg())) {
        poorPirates.add(pirate);
      }
    }
    for (Pirate pirate : poorPirates) {
      poorPirateNames.add(pirate.name);
    }
    return poorPirateNames;
  }

  public void addPirate(Pirate pirate) {
    if (!pirate.isCaptain()) {
      this.listOfPirates.add(pirate);
    } else if (!isThereACaptain()) {
      this.listOfPirates.add(pirate);
    }
  }

  public int getGolds() {
    int totalGold = 0;
    for (Pirate pirate : this.listOfPirates) {
      totalGold += pirate.getAmountOfGold();
    }
    return totalGold;
  }

  public void lastDayOnTheShip() {
    for (Pirate pirate : listOfPirates ) {
      pirate.party();
    }
  }

  public void prepareForBattle() {
    for (Pirate pirate : listOfPirates) {
      for (int i = 0; i < 5; i++) {
        pirate.work();
      }
      lastDayOnTheShip();
    }
  }
}
