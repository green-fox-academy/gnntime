public class TodoPrint {
    public static void main(String[] args) {
        String todoText = " - Buy milk \n";

        StringBuilder myToDoText = new StringBuilder(todoText);
        myToDoText.insert(0, "My todo: \n");
        myToDoText.insert(23 , " - Download games \n");
        myToDoText.insert(41, "\n     - Diablo \n");
        todoText = myToDoText.toString();

        System.out.println(todoText);
    }
}
