class LifecycleTest {

    // Simulate @BeforeAll (runs once before all tests)
    public static void beforeAll() {
        System.out.println("🔵 Before All Tests");
    }

    // Simulate @AfterAll (runs once after all tests)
    public static void afterAll() {
        System.out.println("🔴 After All Tests");
    }

    // Simulate @BeforeEach (runs before every test)
    public static void beforeEach() {
        System.out.println("   🟢 Before Each Test");
    }

    // Simulate @AfterEach (runs after every test)
    public static void afterEach() {
        System.out.println("   🟠 After Each Test");
    }

    // -------- TEST METHODS --------

    public static void test1() {
        System.out.println("      ✅ Running Test 1");
    }

    public static void test2() {
        System.out.println("      ✅ Running Test 2");
    }

    public static void test3() {
        System.out.println("      ✅ Running Test 3");
    }
}

// Main class
public class Task8 {

    public static void main(String[] args) {

        // Before all tests
        LifecycleTest.beforeAll();

        // Test 1
        LifecycleTest.beforeEach();
        LifecycleTest.test1();
        LifecycleTest.afterEach();

        // Test 2
        LifecycleTest.beforeEach();
        LifecycleTest.test2();
        LifecycleTest.afterEach();

        // Test 3
        LifecycleTest.beforeEach();
        LifecycleTest.test3();
        LifecycleTest.afterEach();

        // After all tests
        LifecycleTest.afterAll();
    }
}