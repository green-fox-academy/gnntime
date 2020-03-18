package domino;

import java.util.ArrayList;
import java.util.List;

public class Dominoes {
  public static void main(String[] args) {
    List<Domino> dominoes = initializeDominoes();
    // You have the list of Dominoes
    // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
    // eg: [2, 4], [4, 3], [3, 5] ...
    List<Domino> snake = new ArrayList<>();
    Domino initial = dominoes.get(4);
    snake.add(initial);

    for (int i = 0; i < dominoes.size()-1; i++) {
      Domino compareDomino = snake.get(i);
      for (int j = 0; j < dominoes.size(); j++) {
        if (compareDomino.getRightSide() == dominoes.get(j).getLeftSide()) {
          snake.add(dominoes.get(j));
        }
      }
    }

    System.out.println(dominoes);
    System.out.println(snake);
  }

  static List<Domino> initializeDominoes() {
    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));
    return dominoes;
  }
}