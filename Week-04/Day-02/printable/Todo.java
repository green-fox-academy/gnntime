package printable;

public class Todo implements Printable {

  private String task;
  private String priority;
  private boolean done;

  public Todo(String task, String priority, boolean done) {
    this.task = task;
    this.priority = priority;
    this.done = done;
  }

  @Override
  public void printAllFields() {
    System.out.println("Task " + this.task + " | " + " Priority " + this.priority + " | " + "Done: " + this.done);
  }
}
