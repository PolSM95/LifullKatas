package Dispensables.CopyAndPasteInheritance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SettlementAccount {
    private final List<Transaction> transactions = new ArrayList<>();
    private float owing;
    private float Balance;
    private Transaction lastTransaction;
    private String LastTransactionDate;

    public void credit(float amount)
    {
        executeTransaction(amount);
    }

    public void debit(float amount)
    {
        executeTransaction(-amount);
    }

    public void borrow(float amount)
    {
        owing += amount;
    }

    public void settle()
    {
        this.Balance = this.getBalance() - owing;
    }

    private void executeTransaction(float amount)
    {
        this.Balance = this.getBalance() + amount;
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
        this.LastTransactionDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
    }

    public float getBalance() {
        return Balance;
    }

    public Transaction getLastTransaction() {
        return transactions.get(transactions.size() - 1);
    }

    public String getLastTransactionDate() {
        return LastTransactionDate;
    }
}
