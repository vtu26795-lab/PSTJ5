import java.io.*;

class PrimeChecker {

    public boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

class CSVTest {

    static PrimeChecker checker = new PrimeChecker();

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

    // ✅ Create CSV automatically
    public static void createCSV(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            bw.write("2,true\n");
            bw.write("3,true\n");
            bw.write("4,false\n");
            bw.write("5,true\n");
            bw.write("6,false\n");
            bw.write("7,true\n");
            bw.write("8,false\n");

            bw.close();
            System.out.println("✅ CSV file created successfully\n");

        } catch (Exception e) {
            System.out.println("❌ Error creating CSV: " + e.getMessage());
        }
    }

    // Read CSV and test
    public static void runCSVTests(String fileName) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int input = Integer.parseInt(data[0].trim());
                boolean expected = Boolean.parseBoolean(data[1].trim());

                boolean result = checker.isPrime(input);

                assertEquals(expected, result, "Input: " + input);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}

// Main class
public class Task7 {

    public static void main(String[] args) {

        String fileName = "testdata.csv";

        System.out.println("Running CSV-Based Tests...\n");

        // Step 1: Create CSV file automatically
        CSVTest.createCSV(fileName);

        // Step 2: Run tests
        CSVTest.runCSVTests(fileName);
    }
}