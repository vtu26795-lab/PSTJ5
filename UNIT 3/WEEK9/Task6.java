import java.util.*;

// Account Class
class Account {
    int accountNumber;
    String holderName;
    double balance;

    Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
}

// Bank Class
class Bank {
    Map<Integer, Account> accounts = new HashMap<>();

    void addAccount(Account acc) {
        accounts.put(acc.accountNumber, acc);
    }

    void deposit(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        acc.balance += amount;
        System.out.println("Deposited " + (int)amount + " to " + acc.holderName);
    }

    void withdraw(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }

        if (acc.balance < amount) {
            System.out.println("Insufficient balance");
        } else {
            acc.balance -= amount;
            System.out.println("Withdrawn " + (int)amount + " from " + acc.holderName);
        }
    }

    void transfer(int fromAcc, int toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Account not found");
            return;
        }

        if (sender.balance < amount) {
            System.out.println("Insufficient balance");
        } else {
            sender.balance -= amount;
            receiver.balance += amount;
            System.out.println("Transferred " + (int)amount + " from " 
                    + sender.holderName + " to " + receiver.holderName);
        }
    }
}

// Main Class
public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        int n = sc.nextInt();

        // Read Accounts
        for(int i = 0; i < n; i++) {
            int accNo = sc.nextInt();
            String name = sc.next();
            double balance = sc.nextDouble();
            bank.addAccount(new Account(accNo, name, balance));
        }

        int operations = sc.nextInt();

        for(int i = 0; i < operations; i++) {
            String op = sc.next();

            if(op.equals("DEPOSIT")) {
                int acc = sc.nextInt();
                double amt = sc.nextDouble();
                bank.deposit(acc, amt);
            }
            else if(op.equals("WITHDRAW")) {
                int acc = sc.nextInt();
                double amt = sc.nextDouble();
                bank.withdraw(acc, amt);
            }
            else if(op.equals("TRANSFER")) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                double amt = sc.nextDouble();
                bank.transfer(from, to, amt);
            }
        }

        sc.close();
    }
}