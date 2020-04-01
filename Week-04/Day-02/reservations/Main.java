package reservations;

public class Main {

  public static void main(String[] args) {
    
    Reservation rev = new Reservation();

    for (int i = 0; i < 6 ; i++) {
      System.out.println("Booking #" + rev.getCodeBooking() + " for " + rev.getDowBooking());
    }
    
  }

}
