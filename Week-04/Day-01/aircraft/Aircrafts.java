package aircraft;

public abstract class Aircrafts {
  private int maxAmmo;
  private int baseDamage;
  private int currentAmmo;
  private String type;

  public Aircrafts() {
    currentAmmo = 0;
  }


  public int getMaxAmmo() {
    return maxAmmo;
  }

  public void setMaxAmmo(int maxAmmo) {
    this.maxAmmo = maxAmmo;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

  public void setBaseDamage(int baseDamage) {
    this.baseDamage = baseDamage;
  }

  public int getCurrentAmmo() {
    return currentAmmo;
  }

  public void setCurrentAmmo(int currentAmmo) {
    this.currentAmmo = currentAmmo;
  }

  public int fight() {
    int totalDamage = this.baseDamage * this.currentAmmo;
    currentAmmo = 0;
    return totalDamage;
  }

  public int refill(int refillAmount) {
    if (refillAmount <= this.maxAmmo) {
      this.currentAmmo += refillAmount;
      return refillAmount - this.currentAmmo;
    } else {
      this.currentAmmo = this.maxAmmo;
      return refillAmount - this.maxAmmo;
    }
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }

  public String getStatus() {
    return "Type " + getType() + ", Ammo: " + getCurrentAmmo() + ", Base Damage: " + getBaseDamage()
        + ", All" + " Damage: " + fight();
  }

  public boolean isPriority() {
    return getType() == "F35";
  }
}



