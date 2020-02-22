package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class FileUtils {

    public static List<String> read(String path) {

        // read file into stream, try-with-resources
        try {
            return Files.lines(Paths.get(path))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

}
