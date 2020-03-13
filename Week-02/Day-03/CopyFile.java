import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {
    public static void main(String[] args)  {
        String copyFrom = "/Week-02/Day-03/files/my-file.txt";
        String copyTo = "/Week-02/Day-03/files/my-file2.txt";
        try {
            copyFile(copyFrom, copyTo);
            System.out.println("It worked");
        } catch ( Exception e ) {
            System.out.println("fail");
        }
    }

    private static void copyFile(String origin, String target) throws IOException {
        Path filePath = Paths.get(origin);
        List<String> content = Files.readAllLines(filePath);
        Path filePath2 = Paths.get(target);
        Files.write(filePath2, content);
    }
}
