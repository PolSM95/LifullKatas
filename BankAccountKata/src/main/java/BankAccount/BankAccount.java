package BankAccount;

public class BankAccount {

    private Console console;
    private Transactions transactions;
    private int currentBalance;


    public BankAccount(Console console, Transactions transactions){
        this.currentBalance = 0;
        this.console = console;
        this.transactions = transactions;
    }

    public void printStatement() {
        throw new UnsupportedOperationException();
    }

    public void deposit(int amount) {
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
