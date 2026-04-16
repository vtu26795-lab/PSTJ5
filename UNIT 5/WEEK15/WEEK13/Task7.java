import java.util.*;

// Simulated Database (Mock)
class MockDatabase {

    private Map<Integer, String> data;

    // Setup method (reusable)
    public void setUp() {
        data = new HashMap<>();
        data.put(1, "Alice");
        data.put(2, "Bob");
        data.put(3, "Charlie");
    }

    public String getUser(int id) {
        return data.get(id);
    }

    public void addUser(int id, String name) {
        data.put(id, name);
    }
}

// Service class (uses database)
class UserService {

    private MockDatabase db;

    public UserService(MockDatabase db) {
        this.db = db;
    }

    public String fetchUser(int id) {
        return db.getUser(id);
    }
}

// Test class
class UserServiceTest {

    static MockDatabase db;
    static UserService service;

    // Reusable setup (like @BeforeEach)
    public static void setUp() {
        db = new MockDatabase();
        db.setUp();   // initialize data
        service = new UserService(db);
    }

    // assertEquals
    public static void assertEquals(String expected, String actual, String testName) {
        if (Objects.equals(expected, actual)) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + expected +
                    " | Got: " + actual);
        }
    }

    // -------- TEST CASES --------

    public static void testFetchExistingUser() {
        setUp(); // reusable setup
        assertEquals("Alice", service.fetchUser(1), "Fetch existing user");
    }

    public static void testFetchNonExistingUser() {
        setUp();
        assertEquals(null, service.fetchUser(99), "Fetch non-existing user");
    }

    public static void testAddUser() {
        setUp();
        db.addUser(4, "David");
        assertEquals("David", service.fetchUser(4), "Add new user");
    }
}

// Main class
public class Task7 {

    public static void main(String[] args) {
        System.out.println("Running Mock Database Tests...\n");

        UserServiceTest.testFetchExistingUser();
        UserServiceTest.testFetchNonExistingUser();
        UserServiceTest.testAddUser();
    }
}