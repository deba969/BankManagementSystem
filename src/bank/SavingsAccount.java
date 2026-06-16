package bank;

public class SavingsAccount extends BankAccount {

    private double minimumBalance;

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolderName,
                          double initialBalance, double minimumBalance) {
        super(accountNumber, accountHolderName, initialBalance);
        this.minimumBalance = minimumBalance;
    }

    // Override withdraw to enforce minimum balance rule
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }
        if (getBalance() - amount < minimumBalance) {
            throw new InsufficientFundsException(
                    "Cannot withdraw! Minimum balance of Rs." + minimumBalance + " must be maintained."
            );
        }
        super.withdraw(amount);
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }
}