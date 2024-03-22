package pdp_online.modul4.day6.task2;

import java.time.LocalDate;

public class Task2 {
    public static void main(String[] args) {
        String date = "2000-01-23";
        System.out.println(parseToLocalDate(date));
    }

    private static LocalDate parseToLocalDate(String date) {
        return LocalDate.parse(date);
    }
}
