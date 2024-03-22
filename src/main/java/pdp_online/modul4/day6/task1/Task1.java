package pdp_online.modul4.day6.task1;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(getCurrentTimeUsingDate());
    }

    private static String getCurrentTimeUsingDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    private static String getCurrentTime() {
        LocalDateTime date = LocalDateTime.now();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}