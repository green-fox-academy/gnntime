package aircraft;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
  protected List<Aircrafts> aircraftsList;
  private int initialAmmo;
  private int healthPoints;
  private int storedAmmo;

  public Carrier(int initialAmmo, int healthPoints) {
    this.initialAmmo = initialAmmo;
    this.healthPoints = healthPoints;
    this.aircraftsList = new ArrayList<>();
    this.storedAmmo = this.initialAmmo;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public void add(Aircrafts aircrafts) {
    aircraftsList.add(aircrafts);
  }
  /*fill
  It should fill all the aircraft with ammo and subtract the needed ammo from the ammo storage
  If there is not enough ammo then it should start to fill the aircrafts with priority first
  If there is no ammo when this method is called, it should throw an exception*/

  public void fill() throws Exception {
    int ammoUsed;
    if (this.storedAmmo == 0) {
      throw new Exception("No ammo to fill...");
    } else {

      for (int i = 0; i < aircraftsList.size(); i++) {
        if (aircraftsList.get(i).isPriority()) {
          this.storedAmmo = aircraftsList.get(i).refill(this.storedAmmo);
        }
      }
      for (int i = 0; i < aircraftsList.size(); i++) {
        if (!aircraftsList.get(i).isPriority()) {
          this.storedAmmo = aircraftsList.get(i).refill(this.storedAmmo);
        }
      }
    }
  }

  public void fight(Carrier carrier){
    //aircraft.fight();
    int damage = 0;
    for (Aircrafts aircraft: this.aircraftsList) {
      aircraft.fight();
      damage = damage + aircraft.fight();
    }
    carrier.healthPoints += damage;
    //this.healthPoints= this.healthPoints - carrier.aircraftsList.size()*carrier.aircraft.getBaseDamage();
    //DECREASE THE AMMO - PENDING
    System.out.println(carrier.healthPoints);
  }
}

