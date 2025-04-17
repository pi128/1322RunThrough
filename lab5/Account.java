package lab5;

public class Account {
    private static int nextNumber = 10001;
    private final int accountNumber;
    private double accountBalance;

    /** no‑arg constructor: balance starts at 0 */
    public Account() {
        this.accountNumber  = nextNumber++;
        this.accountBalance = 0.0;
    }

    /** initialize with a starting balance */
    public Account(double bal) {
        this.accountNumber  = nextNumber++;
        this.accountBalance = bal;
    }

    /** withdraw and return new balance */
    public double withdraw(double amount) {
        accountBalance -= amount;
        return accountBalance;
    }

    /** deposit and return new balance */
    public double deposit(double amount) {
        accountBalance += amount;
        return accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account #" + accountNumber + ", balance $" + accountBalance;
    }
}