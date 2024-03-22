import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[] countries = {"Uzbekistan", "USA", "Germany", "France", "Spain",
            "Russia", "Italy", "England", "Brazil", "Portugal"};
    public static String[] capitals = {"Tashkent", "Washington", "Berlin", "Paris", "Madrid",
            "Moscow", "Rome", "London", "Brasilia", "Lisbon"};

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int correctCount = 0;

        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(0, countries.length);
            String country = countries[randomIndex];

            System.out.println(country);
            System.out.print("Enter capital of this country ");
            String capital = scanner.nextLine();

            if (capital.equalsIgnoreCase(capitals[randomIndex])) {
                correctCount++;
                System.out.println("You found");
            } else
                System.out.println("You could not find");
        }

        System.out.print("You found " + correctCount + " answers");
    }
}