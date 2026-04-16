class LoginSystem {

    private String validUser = "admin";
    private String validPass = "1234";

    public String login(String username, String password) {

        if (username == null) return "Username cannot be null";
        if (password == null) return "Password cannot be null";

        if (username.isEmpty() && password.isEmpty()) {
            return "Both fields required";
        }

        if (username.isEmpty()) {
            return "Username cannot be empty";
        }

        if (password.isEmpty()) {
            return "Password cannot be empty";
        }

        if (username.equals(validUser) && password.equals(validPass)) {
            return "Login Success";
        } else {
            return "Invalid credentials";
        }
    }
}

// Test class
class LoginTest {

    static LoginSystem system = new LoginSystem();

    public static void assertEquals(String expected, String actual, String testName) {
        if (expected.equals(actual)) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + expected +
                    " | Got: " + actual);
        }
    }

    // -------- TEST CASES --------

    public static void testValidLogin() {
        assertEquals("Login Success", system.login("admin", "1234"), "Valid login");
    }

    public static void testInvalidLogin() {
        assertEquals("Invalid credentials", system.login("admin", "wrong"), "Wrong password");
        assertEquals("Invalid credentials", system.login("wrong", "1234"), "Wrong username");
    }

    public static void testBlankFields() {
        assertEquals("Username cannot be empty", system.login("", "1234"), "Empty username");
        assertEquals("Password cannot be empty", system.login("admin", ""), "Empty password");
        assertEquals("Both fields required", system.login("", ""), "Both empty");
    }

    public static void testNullInputs() {
        assertEquals("Username cannot be null", system.login(null, "1234"), "Null username");
        assertEquals("Password cannot be null", system.login("admin", null), "Null password");
    }
}

// Main class
public class Task10 {

    public static void main(String[] args) {
        System.out.println("Running Login System Tests...\n");

        LoginTest.testValidLogin();
        LoginTest.testInvalidLogin();
        LoginTest.testBlankFields();
        LoginTest.testNullInputs();
    }
}