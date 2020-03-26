package BankAccount;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FormatTransaction {

    private static final String HEADER = "date       || credit   || debit    || balance";
    Console console;

    public FormatTransaction(Console console) {
        this.console = console;
    }

    private void printTransaction(Transaction transaction){
        if (transaction.getAmount() >= 0){
            console.printLine(transaction.getDate()+" || "+transaction.getAmount()+" ||          || "+transaction.getBalance());
        }
        if (transaction.getAmount()<0) {
            console.printLine(transaction.getDate() + " ||          || " + (-transaction.getAmount()) + " || " + transaction.getBalance());
        }
    }

    public void printListTransaction (List<Transaction> listTransaction){
        Collections.reverse(listTransaction);
        console.printLine(HEADER);
        for (Transaction transaction:listTransaction) {
            printTransaction(transaction);
        }
    }


}
