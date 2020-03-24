package BankAccount;

public class BankAccount {

    private Console console;
    private Transactions transactions;
    //balance total
    //base de datos

    public BankAccount(Console console) {

        this.console = console;
    }

    public BankAccount(Transactions transactions){

        this.transactions = transactions;
    }

    public void printStatement() {
        throw new UnsupportedOperationException();

    }

    public void deposit(int amount) {

        throw new UnsupportedOperationException();

    }

    public void withdraw(int amount) {

        throw new UnsupportedOperationException();

    }
}
