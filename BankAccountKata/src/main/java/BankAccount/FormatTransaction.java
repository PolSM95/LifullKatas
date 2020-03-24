package BankAccount;

import java.util.List;

public class FormatTransaction {

    Console console;

    public FormatTransaction(Console console) {
        this.console = console;
    }

    public void printTransaction(Transaction transaction){
        if (transaction.getAmount() >= 0){
           console.printLine(transaction.getDate()+" || "+transaction.getAmount()+" ||  || "+transaction.getBalance());
        }
         console.printLine(transaction.getDate()+" ||  || "+ transaction.getAmount()+" || "+transaction.getBalance());

    }

    public void printListTransaction (List<Transaction> listTransaction){
        for (Transaction transaction:listTransaction) {
            printTransaction(transaction);
        }
    }

}
