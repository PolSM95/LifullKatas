package Dispensables.CopyAndPasteInheritance;

public class LoyaltyAccount extends Account {
    private int loyaltypoints;

    public void credit(float amount)
    {
        executeTransaction(amount);
        loyaltypoints++;
    }

    public void debit(float amount)
    {
        executeTransaction(-amount);
    }

    private void recordTransaction(float amount)
    {
        transactions.recordTransaction(amount);
    }

    private void updateLastTransactionDate()
    {
        transactions.updateLastTransactionDate();
    }

    public float getBalance() {
        return balance;
    }

    public Transaction getLastTransaction() {
        return transactions.getLastTransaction();
    }

    public void setLastTransaction(Transaction lastTransaction) {
        transactions.setLastTransaction(lastTransaction);
    }

    public String getLastTransactionDate() {
        return transactions.getLastTransactionDate();
    }
}
