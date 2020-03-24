package main.java.music;

public class Violin extends StringedInstruments {

  public Violin() {
    this.name = "Violin";
    this.numberOfStrings = 4;
  }

  public Violin(int stringNumber) {
    this.name = "Violin";
    this.numberOfStrings = stringNumber;
  }


  @Override
  public String sound() {
  return "Screech";
  }

  @Override
  public void play() {
    System.out.println(name + ", a " + numberOfStrings + "-stringed instrument that goes " + sound());
  }
}
