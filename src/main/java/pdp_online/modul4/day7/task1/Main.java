package pdp_online.modul4.day7.task1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("readme.txt");

        reader(file);
        writer(file, "New text");
        reader(file);
    }

    private static void writer(File file, String newText) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        writer.write(newText);
        writer.close();
    }

    private static void reader(File file) throws IOException {
        FileReader fileReader = new FileReader(file);

        while (true) {
            int read = fileReader.read();
            if (read == -1) break;

            System.out.print((char) read);
        }
        fileReader.close();
    }
}