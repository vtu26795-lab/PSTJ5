import java.io.*;

// Logger class (console + file logging)
class Logger {

    static String logFile = "log.txt";

    public static void log(String level, String message) {
        String logMessage = "[" + level + "] " + message;

        // Print to console
        System.out.println(logMessage);

        // Write to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true))) {
            bw.write(logMessage);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("[ERROR] Failed to write log file");
        }
    }

    public static void info(String msg) {
        log("INFO", msg);
    }

    public static void debug(String msg) {
        log("DEBUG", msg);
    }

    public static void error(String msg) {
        log("ERROR", msg);
    }
}

// File processing system
class FileProcessor {

    public void processFile(String fileName) {

        Logger.info("Starting file processing: " + fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                count++;
                Logger.debug("Reading line " + count + ": " + line);
            }

            Logger.info("File processed successfully. Total lines: " + count);

        } catch (FileNotFoundException e) {
            Logger.error("File not found: " + fileName);

        } catch (Exception e) {
            Logger.error("Error processing file: " + e.getMessage());
        }
    }
}

// Main class
public class Task10 {

    public static void main(String[] args) {

        FileProcessor fp = new FileProcessor();

        // Case 1: Success (create file first)
        createSampleFile("input.txt");
        fp.processFile("input.txt");

        System.out.println();

        // Case 2: Failure (file not found)
        fp.processFile("missing.txt");
    }

    // Helper: create sample file
    public static void createSampleFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Hello");
            bw.newLine();
            bw.write("Testing file processing");
        } catch (Exception e) {
            System.out.println("Error creating sample file");
        }
    }
}