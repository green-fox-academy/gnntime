package main.java.music;

public class BassGuitar extends StringedInstruments {

  public BassGuitar() {
    this.name = "Bass Guitar";
    this.numberOfStrings = 4;

  }

  public BassGuitar(int stringNumber) {
    this.name = "Bass Guitar";
    this.numberOfStrings = stringNumber;
  }

  @Override
  public String sound() {
    return "Duum-duum-duum";
  }

  @Override
  public void play() {
    System.out.println(name + ", a " + numberOfStrings + "-stringed instrument that goes " + sound());
  }
}
