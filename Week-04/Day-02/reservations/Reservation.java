package reservations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Reservation implements Reservationy {

  Random random = new Random();

  @Override
  public String getDowBooking() {
    List<String> listOfDays = new ArrayList<>(Arrays.asList("MON", "TUE", "WEN", "THU", "FRI", "SAT", "SUN"));
    int randomDayNumber = random.nextInt(listOfDays.size()-1);
    return listOfDays.get(randomDayNumber);
  }

  @Override
  public String getCodeBooking() {
    String letters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String code ="";
    int randomIndex;
    for (int i = 0; i < 8 ; i++) {
      randomIndex = random.nextInt(letters.length() -1);
      code += letters.charAt(randomIndex);
    }
    return code;
  }
}
