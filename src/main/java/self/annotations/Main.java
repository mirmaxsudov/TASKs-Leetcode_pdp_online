package self.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getClass().isAnnotationPresent(FirstAnnotation.class));
    }
}

@FirstAnnotation
class Student {
    private String name;

    public void say() {
        System.out.println("Hello World!");
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface FirstAnnotation {

}