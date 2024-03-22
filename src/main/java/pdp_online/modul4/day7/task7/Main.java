package pdp_online.modul4.day7.task7;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.print("Enter first file name -> ");
        String name = in.nextLine();

        File firstFile = buildFile(name);
        writeToFile(firstFile);
        System.out.println("File is built successfully");

        System.out.print("Enter second file name -> ");
        String secondName = in.nextLine();

        File secondFile = buildFile(secondName);
        transfer(firstFile, secondFile);
        System.out.println("Successfully");
    }

    private static void transfer(File firstFile, File secondFile) throws IOException {
        FileReader fileReader = new FileReader(firstFile);
        FileWriter fileWriter = new FileWriter(secondFile);
        fileReader.transferTo(fileWriter);

        fileReader.close();
        fileWriter.close();
    }

    private static void writeToFile(File file) throws IOException {

        try (FileWriter writer = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            for (int i = 1; i <= 100_000; i++) {
                for (int j = 1; j <= 10; j++) {
                    bufferedWriter.append(String.valueOf(i))
                            .append(" * ")
                            .append(String.valueOf(j))
                            .append(" = ")
                            .append(String.valueOf(i * j));
                }
                bufferedWriter.append("\n");
            }
        }
    }

    private static File buildFile(String name) throws IOException {
        File file = new File("modul4\\day7\\task7\\", name);

        if (!file.exists())
            file.createNewFile();

        return file;
    }
}