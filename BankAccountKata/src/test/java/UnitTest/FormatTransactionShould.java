package UnitTest;

import BankAccount.Console;
import BankAccount.FormatTransaction;
import BankAccount.Transaction;
import BankAccount.Transactions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class FormatTransactionShould {

    FormatTransaction formatTransaction;
    Console console;
    List <Transaction> transactionsList;

    @BeforeEach
    public void init(){
        console = mock(Console.class);
        formatTransaction = new FormatTransaction(console);
        transactionsList = new ArrayList<>();
    }


    @Test
    public void print_header_when_transaction_list_is_empty(){
        formatTransaction.printListTransaction(transactionsList);

        verify(console).printLine("date       || credit   || debit    || balance");
    }

    @Test
    public void print_transactions_when_there_are_one_transaction(){
        transactionsList.add(new Transaction(1000,0));
        formatTransaction.printListTransaction(transactionsList);

        verify(console).printLine("date       || credit   || debit    || balance");
        verify(console).printLine("24/03/2020 || 1000 ||  || 0" );

    }

}
