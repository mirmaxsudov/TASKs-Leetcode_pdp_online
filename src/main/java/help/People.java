package help;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class People {
    private static final List<Person> people = new ArrayList<>();

    static {
        people.add(
                new Child(
                        "Abdurahmon", "Someoneov", 20, "Tashkent", "University", "2"
                )
        );
        people.add(
                new Child(
                        "Ali", "Aliyev", 15, "Tashkent", "School", "7-grade"
                )
        );
        people.add(
                new Child(
                        "Vali", "Valiyev", 16, "Andijan", "School", "8-grade"
                )
        );
        people.add(
                new Teacher(
                        "Naima", "Aliyeva", 30, "Tashkent", "123-school"
                )
        );
        people.add(
                new Teacher(
                        "G'ofur", "G'ofurova", 50, "Tashkent region", "123-school"
                )
        );
        people.add(
                new Teacher(
                        "Malika", "Valiyeva", 40, "Tashkent", "123-school"
                )
        );
        people.add(
                new Doctor(
                        "Faruh", "Farhodov", 60, "Fargona", 10000000d, "Dentist"
                )
        );
        people.add(
                new Doctor(
                        "Faruh", "Tohirov", 34, "Tashkent", 100000000d, "Dent"
                )
        );
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter name ");
            String name = new Scanner(System.in).nextLine();

            Person person = getPerson(name);
            System.out.println(person == null ? "There is no person with this name" : person);
        }

    }

    private static Person getPerson(String name) {
        return people.stream()
                .filter(person -> person.getName().equals(name)).findFirst().orElse(null);
    }
}

class Teacher extends Person {
    private String workingPlace;

    public Teacher(String name, String surname, int age, String livingPlace, String workingPlace) {
        super(name, surname, age, livingPlace);
        this.workingPlace = workingPlace;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("""
                Working place %s
                """, workingPlace);
    }
}

class Child extends Person {
    private String schoolName;
    private String grade;

    public Child(String name, String surname, int age, String livingPlace, String schoolName, String grade) {
        super(name, surname, age, livingPlace);
        this.schoolName = schoolName;
        this.grade = grade;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("""
                School name %s
                Grade %s
                """, schoolName, grade);
    }
}

class Doctor extends Person {
    private double price;
    private String specialization;

    public Doctor(String name, String surname, int age, String livingPlace,
                  double price, String specialization) {
        super(name, surname, age, livingPlace);
        this.specialization = specialization;
        this.price = price;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("""
                Price %s
                Specialization %s
                """, price, specialization);
    }
}

abstract class Person {
    private String name;
    private String surname;
    private int age;
    private String livingPlace;

    public Person(String name, String surname, int age, String livingPlace) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.livingPlace = livingPlace;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("""   
                Name: %s
                Surname: %s
                Age: %d
                Living place: %s""", name, surname, age, livingPlace);
    }
}