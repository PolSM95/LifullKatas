package BankAccount;

public class BankAccount {

    private Transactions transactions;
    private int currentBalance;
    private FormatTransaction formatTransaction;


    public BankAccount(Transactions transactions, FormatTransaction formatTransaction){
        this.currentBalance = 0;
        this.transactions = transactions;
        this.formatTransaction = formatTransaction;
    }

    public void printStatement() {


        formatTransaction.printListTransaction(transactions.getTransactionList());
    }

    public void deposit(int amount) {
        if(amount < 0){
            throw new NullPointerException();
        }
        currentBalance += amount;
        Transaction transactionDeposit = new Transaction(amount, currentBalance);
        transactions.addTransaction(transactionDeposit);
    }

    public void withdraw(int amount) {
        if((currentBalance - amount) < 0){
            Transaction transactionDeposit = new Transaction(-currentBalance, 0);
            transactions.addTransaction(transactionDeposit);
        }
        currentBalance -= amount;
        Transaction transactionDeposit = new Transaction(-amount, currentBalance);
        transactions.addTransaction(transactionDeposit);

    }
}
