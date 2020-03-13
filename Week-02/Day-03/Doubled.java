import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Doubled {
    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("Week-02/Day-03/files/duplicated-chars");
        String original = Files.readString(filePath);

        char[] ch = new char[original.length()];

        for (int i = 0; i < original.length(); i++) {
            ch[i] = original.charAt(i);
        }


    }

}
