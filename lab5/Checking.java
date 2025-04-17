package lab5;

public class Checking extends Account {
    public Checking() {
        super(0.0);
    }

    public Checking(double bal) {
        super(bal);
    }

    @Override
    public double withdraw(double amount) {
        // first perform the normal withdrawal
        double newBal = super.withdraw(amount);

        // if we went below 0, charge the $20 overdraft fee
        if (newBal < 0) {
            System.out.println("Charging an overdraft fee of $20 because account is below $0");
            newBal = super.withdraw(20.0);
        }

        return newBal;
    }

    @Override
    public String toString() {
        // “Checking Account #X, balance $Y”
        return "Checking Account #" + getAccountNumber() + ", balance $" + getAccountBalance();
    }
}