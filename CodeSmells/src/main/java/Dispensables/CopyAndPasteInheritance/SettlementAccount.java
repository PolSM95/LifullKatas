package Dispensables.CopyAndPasteInheritance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SettlementAccount extends Account {
    private float owing;
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
        balance = balance - owing;
    }

    private void recordTransaction(float amount)
    {
        transactions.recordTransaction(amount);
    }

    private void updateLastTransactionDate()
    {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        this.LastTransactionDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
    }

    public float getBalance() {
        return balance;
    }

    public Transaction getLastTransaction() {
        return transactions.getLastTransaction();
    }

    public String getLastTransactionDate() {
        return LastTransactionDate;
    }
}
