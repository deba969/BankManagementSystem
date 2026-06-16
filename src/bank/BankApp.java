package bank;

import java.util.HashMap;
import java.util.Scanner;

public class BankApp {

    static HashMap<String, BankAccount> accounts = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    //Main method
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Mini Statement");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: checkBalance(); break;
                case 5: miniStatement(); break;
                case 6: System.out.println("Thank you for using Bank Management System!"); break;
                default: System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);
    }
    //Create Account Method
    static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.next();

        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.next();

        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        System.out.print("Enter Minimum Balance (for Savings Account): ");
        double minBalance = scanner.nextDouble();

        SavingsAccount account = new SavingsAccount(accNo, name, balance, minBalance);
        accounts.put(accNo, account);

        System.out.println("Account created successfully for " + name + "!");
    }
    //Deposit Method
    static void deposit() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.next();

        BankAccount account = accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        account.deposit(amount);
    }
    //Withdraw Method
    static void withdraw() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.next();

        BankAccount account = accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        try {
            account.withdraw(amount);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //Check balance and mini statement method
    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.next();

        BankAccount account = accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        account.checkBalance();
    }

    static void miniStatement() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.next();

        BankAccount account = accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        account.miniStatement();
    }

}

