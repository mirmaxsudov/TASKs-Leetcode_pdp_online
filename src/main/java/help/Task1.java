package help;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Task1 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = getBytes();

        Path path = Path.of("result.txt");

        if (!Files.exists(path))
            Files.createFile(path);


        byte[] result = new byte[bytes.length - countSpace(bytes)];

        for (int i = 0, count = 0; i < bytes.length; i++)
            if (!(bytes[i] == ' ' || bytes[i] == 39 || bytes[i] == '\n'))
                result[count++] = bytes[i];

        getSortedBytes(result);
        Files.write(path, result);
    }

    private static int countSpace(byte[] bytes) {
        int count = 0;
        for (byte aByte : bytes)
            if ((aByte == ' ' || aByte == 39 || aByte == '\n'))
                count++;

        return count;
    }

    private static void getSortedBytes(byte[] bytes) {
        Byte[] byteArray = new Byte[bytes.length];
        for (int i = 0; i < bytes.length; i++)
            byteArray[i] = bytes[i];

        Arrays.sort(byteArray, Comparator.reverseOrder());

        for (int i = 0; i < bytes.length; i++)
            bytes[i] = byteArray[i];
    }

    private static byte[] getBytes() throws IOException {
        return Files.readAllBytes(Path.of("file.txt"));
    }
}