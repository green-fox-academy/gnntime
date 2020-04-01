package printable;

import java.util.ArrayList;
import java.util.List;

public class Main {

 public static void main(String[] args) {

  Domino domino = new Domino(3, 2);
  Todo todo = new Todo("Buy milk", "high", true);
   List<Todo> todos = new ArrayList<>();
   List<Domino> dominoes = new ArrayList<>();
   todos.add(todo);
   dominoes.add(domino);

   for (Domino d : dominoes ) {
     d.printAllFields();
   }
   for (Todo t : todos) {
     t.printAllFields();
   }

  }
}
