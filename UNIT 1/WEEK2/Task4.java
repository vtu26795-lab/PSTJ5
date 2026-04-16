import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Static method for filtering
    public static boolean isOlderThanLimit(Person p, int ageLimit) {
        return p.getAge() > ageLimit;
    }
}

public class Task4 {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("David", 35)
        );

        int ageLimit = 25;

        people.stream()
                .filter(p -> Person.isOlderThanLimit(p, ageLimit))
                .forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
    }
}