package exercises;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CowsAndBulls {

  static int goal;
  int counter = 10;
  boolean state;
  int cows = 0;
  int bulls = 0;

  public CowsAndBulls() {
  }

  public static void main(String[] args) {

    CowsAndBulls one = new CowsAndBulls();
    one.start();
  }

  public static void randomizeGoal() {
    Random randomGenerator = new Random();
    goal = randomGenerator.nextInt(10000);
  }

  public static ArrayList<Integer> intoArrayList(Integer input) {
    ArrayList<Integer> digits = new ArrayList<>();
    char[] holder = String.valueOf(input).toCharArray();
    for (int i = 0; i < holder.length; i++) {
      digits.add(Integer.parseInt(String.valueOf(holder[i])));
    }
    return digits;
  }

  public Boolean isGuessValid(int number) {
    if ((number >= 10000) || (number < 1000)) {
      return false;
    }
    return true;
  }

  public boolean isGameRunning() {
    if (cows == 4) {
      return false;
    } else if (counter == 0) {
      return false;
    }
    return true;
  }

  public String start() {
    randomizeGoal();
    Scanner scanner = new Scanner(System.in);
    int userInput;
    do {
      System.out.println("Welcome to Cows and Bulls!");
      System.out.println("Can you guess the randomly generated 4 digit number?");
      System.out.println("You have " + counter + " tries");
      System.out.println(goal);
      userInput = scanner.nextInt();
      System.out.println(guess(userInput));
      guess(userInput);
      counter--;
    } while (isGameRunning());
    return guess(userInput);
  }

  public String guess(Integer guess) {
    if (!isGuessValid(guess)) {
      state = false;
      return "Number is two big or too small";
    }
    ArrayList<Integer> guessArray = intoArrayList(guess);
    ArrayList<Integer> goalArray = intoArrayList(goal);
    for (int i = 0; i < goalArray.size(); i++) {
      if (guessArray.get(i).equals(goalArray.get(i))) {
        cows++;
      } else if ((!guessArray.get(i).equals(goalArray.get(i))) && (goalArray.contains(guessArray.get(i)))) {
        bulls++;
      }
    }
    return cows + " cow, " + bulls + " bull";
  }
}





