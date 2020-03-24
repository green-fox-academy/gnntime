package implementCharSequence;

import java.util.stream.IntStream;

public class Shifter implements CharSequence {

  String string;
  int shifter;

  public Shifter(String string, int shifter){
    this.string = string;
    this.shifter = shifter;
  }

  @Override
  public int length() {
    return 0;
  }

  @Override
  public char charAt(int index) {
    return this.string.charAt(index + shifter);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return null;
  }

  @Override
  public IntStream chars() {
    return null;
  }

  @Override
  public IntStream codePoints() {
    return null;
  }
}
