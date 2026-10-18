import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAnalyzer {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java FileAnalyzer <text-file>");
            return;
        }

        Path file = Path.of(args[0]);
        if (!Files.isRegularFile(file)) {
            System.out.println("File not found: " + file);
            return;
        }

        String text = Files.readString(file);
        long lines = text.lines().count();
        long words = text.isBlank() ? 0 : text.trim().split("\\s+").length;
        System.out.println("Characters: " + text.length());
        System.out.println("Words: " + words);
        System.out.println("Lines: " + lines);
    }
}
