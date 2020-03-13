import java.io.FileWriter;


public class WriteMultipleLines {

    public static void main(String[] args) {
        String path = "Week-02\\Day-03\\files\\my-file.txt";
        String word = "apple";
        int numberOfLines = 5;

        try {
            FileWriter ml = new FileWriter(path);
            for (int i = 0; i < numberOfLines ; i++) {
                ml.write(word);
                ml.write(System.getProperty("line.separator"));
            }
            ml.close();

        } catch ( Exception e) {
            System.out.println();
        }

    }
}
