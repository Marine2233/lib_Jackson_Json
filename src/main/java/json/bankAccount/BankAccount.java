package json.bankAccount;

import java.math.BigDecimal;

public class BankAccount {
    private String owner;
    private String number;
    private Double  balance;
    private String currency;
    private boolean blocked;


    public BankAccount() {
    }
    public BankAccount(double balance, boolean blocked, String currency, String number, String owner) {
        this.balance = balance;
        this.blocked = blocked;
        this.currency = currency;
        this.number = number;
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance='" + balance + '\'' +
                ", owner='" + owner + '\'' +
                ", number='" + number + '\'' +
                ", currency='" + currency + '\'' +
                ", blocked=" + blocked +
                '}';
    }
}
