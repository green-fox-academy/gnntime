public class SecondsInADay {
  public static void main(String[] args) {
    int currentHours = 15;
    int currentMinutes = 55;
    int currentSeconds = 30;

    int currentTime = (currentHours * 3600) + (currentMinutes * 60) + currentSeconds;
    int remainingSeconds = 86400 - currentTime;

    System.out.println(remainingSeconds);
  }
}
