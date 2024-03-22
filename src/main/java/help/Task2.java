package help;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws IOException {
        List<String> names = init();
        String s1 = "s1.txt";
        String s2 = "s2.txt";

        Path path2 = Path.of(s2);
        Path path1 = Path.of(s1);

        if (Files.exists(path1) || Files.exists(path2)) {
            Files.delete(path1);
            Files.delete(path2);
            Files.createFile(path1);
            Files.createFile(path2);
        }

        for (String name : names)
            writeLines(s1, s2, readLines(name));

        System.out.println("Done");
    }

    private static void writeLines(String name1, String name2, List<String> lines) throws IOException {
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(name1, true));
             BufferedWriter writer2 = new BufferedWriter(new FileWriter(name2, true))) {
            for (String line : lines) {
                writer1.write(line.charAt(0) + " ");
                writer2.write(line.charAt(line.length() - 1) + " ");
            }
        }
    }


    private static List<String> readLines(String name) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ignored) {
        }
        return lines;
    }


    private static List<String> init() throws IOException {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String name = "name" + i + ".txt";
            names.add(name);
            Path path = Path.of(name);
            Files.write(path, """
                    package help;                                  import java.io.IOException;
                    import java.nio.file.Filesadsf;
                    gaimport java.nio.file.Path;sadsf
                    gasimsport java.util.Arrays;DSfa
                    gasimport java.util.Collections;314r1e
                    import java.util.Comparator;sadgf24
                    """.getBytes());
        }
        return names;
    }
}