package Dispensables.CopyAndPasteInheritance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Transactions {
    final List<Transaction> transactions = new ArrayList<Transaction>();
    Transaction lastTransaction;
    String lastTransactionDate;

    public Transactions() {
    }

    void recordTransaction(float amount) {
        transactions.add(new Transaction(true, amount));
    }

    void updateLastTransactionDate() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        this.lastTransactionDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
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