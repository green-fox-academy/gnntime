package main.java.music;

public class ElectricGuitar extends StringedInstruments {

  public ElectricGuitar() {
    this.name = "Electric Guitar";
    this.numberOfStrings = 6;

  }

  public ElectricGuitar(int stringNumber) {
    this.name = "Electric Guitar";
    this.numberOfStrings = stringNumber;
  }

  @Override
  public String sound() {
    return "Twang";
  }

  @Override
  public void play() {
    System.out.println(name + ", a " + numberOfStrings + "-stringed instrument that goes " + sound());

  }
}
