package pdp_online.modul4.day7.task5;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        reader(new FileReader(file));
        writer(new FileWriter(file, true), "Add new text");
        reader(new FileReader(file));
    }

    private static void writer(FileWriter fileWriter, String text) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(text);
        bufferedWriter.write("\n");
        bufferedWriter.close();
    }

    private static void reader(FileReader fileReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.lines()
                .forEach(System.out::println);

        bufferedReader.close();
    }
}
