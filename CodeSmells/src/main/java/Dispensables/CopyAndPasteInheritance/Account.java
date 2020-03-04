package Dispensables.CopyAndPasteInheritance;

public class Account {
    protected final Transactions transactions = new Transactions();
    protected float balance;

    protected void executeTransaction(float amount)
    {
        this.balance = this.balance + amount;
        transactions.recordTransaction(amount);
        transactions.updateLastTransactionDate();
    }
}
