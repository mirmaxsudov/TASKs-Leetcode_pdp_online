package help.opp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class task1 {
    public static void main(String[] args) {

    }
}

interface PersonInterface {
    void sayHello();
    default void sayBye() {
        System.out.println("Bye");
    }

    static void sayHi() {
        System.out.println("Hi");
    }
}


@Getter
@Setter
@ToString
class Student implements PersonInterface {
    private String name;
    private String surname;
    private int age;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student() {
        this("Student name", "Student surname", 20);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public void sayBye() {
        PersonInterface.super.sayBye();
    }
}