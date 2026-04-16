class StringUtils {

    // Reverse a string
    public String reverse(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }

    // Check palindrome
    public boolean isPalindrome(String str) {
        String rev = reverse(str);
        return str.equals(rev);
    }
}

// Test class
class StringUtilsTest {

    static StringUtils utils = new StringUtils();

    // assertEquals for String
    public static void assertEquals(String expected, String actual, String testName) {
        if (expected.equals(actual)) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + expected +
                    " | Got: " + actual);
        }
    }

    // assertEquals for boolean
    public static void assertEquals(boolean expected, boolean actual, String testName) {
        if (expected == actual) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + expected +
                    " | Got: " + actual);
        }
    }

    // -------- TEST CASES --------

    public static void testReverse() {
        System.out.println("\n--- Reverse String Tests ---");

        assertEquals("olleh", utils.reverse("hello"), "Reverse normal");
        assertEquals("a", utils.reverse("a"), "Single character");
        assertEquals("", utils.reverse(""), "Empty string");
        assertEquals("madam", utils.reverse("madam"), "Palindrome reverse");
    }

    public static void testPalindrome() {
        System.out.println("\n--- Palindrome Tests ---");

        assertEquals(true, utils.isPalindrome("madam"), "Valid palindrome");
        assertEquals(false, utils.isPalindrome("hello"), "Not palindrome");
        assertEquals(true, utils.isPalindrome("a"), "Single character");
        assertEquals(true, utils.isPalindrome(""), "Empty string");
    }
}

// Main class
public class Task4 {

    public static void main(String[] args) {
        System.out.println("Running String Utility Tests...\n");

        StringUtilsTest.testReverse();
        StringUtilsTest.testPalindrome();
    }
}