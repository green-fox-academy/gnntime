import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        String copyFrom = "files/my-file.txt";
        String copyTo = "files/my-file2.txt";

        copyFile(copyFrom, copyTo);

        if (copyFile(copyFrom, copyTo)) {
            System.out.println("It worked");
        } else {
            System.out.println("Fail");
        }
    }

    private static boolean copyFile(String origin, String target) throws IOException {
        Path filePath = Paths.get(origin);
        List<String> content = Files.readAllLines(filePath);
        Path filePath2 = Paths.get(target);
        Files.write(filePath2, content);
        return true;
    }
}
