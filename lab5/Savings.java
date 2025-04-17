package lab5;

public class Savings extends Account {
    private int numberOfDeposits = 0;

    /** 
     * This is the Savings(double) constructor from your spec:
     * it “passes the argument to its superclass overloaded constructor.”
     */
    public Savings(double startingBalance) {
        super(startingBalance);   // ← calls Account(double) to set accountNumber & balance
        // numberOfDeposits is already initialized to 0 above
    }

    // … your overrides of withdraw, deposit, addInterest, toString, etc.
}