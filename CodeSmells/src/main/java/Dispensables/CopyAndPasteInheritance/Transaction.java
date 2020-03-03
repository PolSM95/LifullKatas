package Dispensables.CopyAndPasteInheritance;

public class Transaction {
    private float amount;
    private boolean isDebit;

    public Transaction(boolean isDebit, float amount)
    {
        this.isDebit = isDebit;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public boolean isDebit() {
        return isDebit;
    }
}
