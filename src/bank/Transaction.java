package bank;

import java.time.LocalDate;

public class Transaction {

    private String type;       // "Deposit" or "Withdrawal"
    private double amount;
    private LocalDate date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + " | " + type + " | Rs." + amount;
    }
}