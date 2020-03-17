package sharpie;

public class Main {
  public static void main(String[] args) {
  Sharpie stabilo = new Sharpie("red", 2.0f);

  stabilo.use();
    System.out.println(stabilo.inkAmount);
  }
}
