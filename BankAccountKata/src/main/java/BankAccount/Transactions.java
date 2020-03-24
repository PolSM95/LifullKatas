package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Transactions {
    private List<Transaction> transactionList = new ArrayList<Transaction>();

    public void addTransaction(Transaction transaction){
        transactionList.add(transaction);
    }
}
