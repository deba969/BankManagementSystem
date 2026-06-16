package bank;

import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList<Transaction> transactions;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        System.out.println("Rs." + amount + " deposited successfully.");
    }

    // Withdraw method
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance! Available balance: Rs." + balance);
        }
        balance -= amount;
        transactions.add(new Transaction("Withdrawal", amount));
        System.out.println("Rs." + amount + " withdrawn successfully.");
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: Rs." + balance);
    }

    // Mini statement - last 5 transactions
    public void miniStatement() {
        System.out.println("===== MINI STATEMENT =====");
        int size = transactions.size();
        if (size == 0) {
            System.out.println("No transactions found.");
            return;
        }
        int start = Math.max(0, size - 5);
        for (int i = start; i < size; i++) {
            System.out.println(transactions.get(i));
        }
        System.out.println("==========================");
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
}