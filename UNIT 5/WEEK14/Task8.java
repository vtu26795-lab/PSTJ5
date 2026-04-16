import java.util.*;

// Complex object
class Person {
    String name;
    int age;
    boolean expectedResult;

    public Person(String name, int age, boolean expectedResult) {
        this.name = name;
        this.age = age;
        this.expectedResult = expectedResult;
    }
}

// Logic class
class PersonValidator {

    // Rule: valid if age >= 18
    public boolean isAdult(Person p) {
        return p.age >= 18;
    }
}

// Test class
class PersonTest {

    static PersonValidator validator = new PersonValidator();

    // assertEquals
    public static void assertEquals(boolean expected, boolean actual, String testName) {
        if (expected == actual) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + expected +
                    " | Got: " + actual);
        }
    }

    // 🔹 MethodSource (simulated)
    public static List<Person> personData() {
        List<Person> list = new ArrayList<>();

        list.add(new Person("Alice", 20, true));
        list.add(new Person("Bob", 17, false));
        list.add(new Person("Charlie", 18, true));
        list.add(new Person("David", 15, false));

        return list;
    }

    // Test using MethodSource
    public static void testPersons() {

        List<Person> data = personData();

        for (Person p : data) {
            boolean result = validator.isAdult(p);

            assertEquals(p.expectedResult, result,
                    "Person: " + p.name + " (Age: " + p.age + ")");
        }
    }
}

// Main class
public class Task8 {

    public static void main(String[] args) {
        System.out.println("Running MethodSource-like Tests...\n");

        PersonTest.testPersons();
    }
}