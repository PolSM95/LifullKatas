package Dispensables.CopyAndPasteInheritance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LoyaltyAccount {
    private final List<Transaction> transactions = new ArrayList<>();
    private int loyaltypoints;
    private float balance;
    private Transaction lastTransaction;
    private String lastTransactionDate;

    public void credit(float amount)
    {
        executeTransaction(amount);
        loyaltypoints++;
    }

    public void debit(float amount)
    {
        executeTransaction(-amount);
    }

    private void executeTransaction(float amount)
    {
        this.balance = this.getBalance() + amount;
        recordTransaction(amount);
        updateLastTransactionDate();
    }

    private void recordTransaction(float amount)
    {
        transactions.add(new Transaction(true, amount));
    }

    private void updateLastTransactionDate()
    {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        this.lastTransactionDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
    }

    public float getBalance() {
        return balance;
    }

    public Transaction getLastTransaction() {
        return transactions.get(transactions.size() - 1);
    }

    public void setLastTransaction(Transaction lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    public String getLastTransactionDate() {
        return lastTransactionDate;
    }
}
