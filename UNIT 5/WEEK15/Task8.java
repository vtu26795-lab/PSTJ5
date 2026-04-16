import java.util.*;
import java.util.concurrent.*;

// 🔹 Event Class
class Event {
    String type; // play, pause, skip

    public Event(String type) {
        this.type = type;
    }
}

// 🔹 Logging Service (Log4j-style simulation)
class LoggingService {

    private Map<String, Integer> eventCount = new HashMap<>();

    public void logEvent(Event event) {

        if (event == null) {
            System.out.println("[ERROR] Null event received!");
            return;
        }

        eventCount.put(event.type, eventCount.getOrDefault(event.type, 0) + 1);

        if (eventCount.get(event.type) > 3) {
            System.out.println("[WARN] Too many '" + event.type + "' events");
        } else {
            System.out.println("[INFO] Event: " + event.type);
        }
    }
}

// 🔹 Thread-safe Account Service
class AccountService {

    private float balance;

    public AccountService(float initialBalance) {
        this.balance = initialBalance;
    }

    // synchronized deposit
    public synchronized boolean deposit(int amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    // synchronized withdraw
    public synchronized boolean withdraw(int amount) {
        if (amount <= 0 || balance < amount) return false;
        balance -= amount;
        return true;
    }

    public synchronized float getBalance() {
        return balance;
    }
}

// 🔹 Main Class (Testing)
public class Task8 {

    public static void main(String[] args) throws InterruptedException {

        // =========================
        // 🔹 Logging Test
        // =========================
        LoggingService logger = new LoggingService();

        logger.logEvent(new Event("play"));
        logger.logEvent(new Event("play"));
        logger.logEvent(new Event("play"));
        logger.logEvent(new Event("play")); // WARN
        logger.logEvent(null); // ERROR

        // =========================
        // 🔹 Account Service Test
        // =========================
        AccountService account = new AccountService(1000);

        int threads = 100;
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        // 🔹 Concurrent Deposits
        for (int i = 0; i < 50; i++) {
            executor.execute(() -> account.deposit(100));
        }

        // 🔹 Concurrent Withdrawals
        for (int i = 0; i < 50; i++) {
            executor.execute(() -> account.withdraw(50));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // Final Balance
        System.out.println("\nFinal Balance = " + account.getBalance());
    }
}