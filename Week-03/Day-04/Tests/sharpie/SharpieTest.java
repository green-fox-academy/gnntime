package sharpie;

import static org.junit.Assert.*;


import org.junit.Test;

public class SharpieTest {

  @Test
  public void use() {
    Sharpie sharpie = new Sharpie("blue", 1);
    assertEquals(90, sharpie.inkAmount,10 );
  }

}