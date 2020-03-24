package BankAccount;

import java.util.Date;
import java.util.Objects;

public class Transaction {

    private String date;
    private int amount;
    private int balance;

    public Transaction ( int amount, int currentBalance){

        //this.date = new Date().toString();
        this.amount = amount;
        this.balance = currentBalance + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                balance == that.balance &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, balance);
    }
}
