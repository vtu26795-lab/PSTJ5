import java.util.concurrent.*;

// 🔹 Account Service (Thread-safe)
class AccountService {

    private double balance;

    public AccountService(double initialBalance) {
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

    public synchronized double getBalance() {
        return balance;
    }
}

// 🔹 Main Class (Testing Concurrency)
public class Task9 {

    public static void main(String[] args) throws InterruptedException {

        AccountService account = new AccountService(1000);

        int totalThreads = 120; // 100+ threads
        ExecutorService executor = Executors.newFixedThreadPool(20);

        // 🔹 Concurrent Deposits
        for (int i = 0; i < 50; i++) {
            executor.execute(() -> {
                account.deposit(100);
            });
        }

        // 🔹 Concurrent Withdrawals
        for (int i = 0; i < 50; i++) {
            executor.execute(() -> {
                account.withdraw(50);
            });
        }

        // 🔹 Mixed Operations
        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                account.deposit(200);
                account.withdraw(100);
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // 🔹 Final Balance
        System.out.println("Final Balance = " + account.getBalance());
    }
}