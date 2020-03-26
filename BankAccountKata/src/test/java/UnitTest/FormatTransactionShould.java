package UnitTest;

import BankAccount.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class FormatTransactionShould {

    FormatTransaction formatTransaction;
    FormatDate date;
    Console console;
    List <Transaction> transactionsList;

    @BeforeEach
    public void init(){
        console = mock(Console.class);
        formatTransaction = new FormatTransaction(console);
        transactionsList = new ArrayList<>();
        date = new FormatDate();
    }


    @Test
    public void print_header_when_transaction_list_is_empty(){
        formatTransaction.printListTransaction(transactionsList);

        verify(console).printLine("date       || credit   || debit    || balance");
    }

    @Test
    public void print_transactions_when_there_are_one_transaction(){
        transactionsList.add(new Transaction(1000,0, date.formatDate()));

        formatTransaction.printListTransaction(transactionsList);

        verify(console).printLine("date       || credit   || debit    || balance");
        verify(console).printLine("26/03/2020 || 1000 ||          || 0" );

    }

    @Test
    public void print_transaction_when_there_is_a_deposit_and_a_withdraw(){
        transactionsList.add(new Transaction(1000,0, date.formatDate()));
        transactionsList.add(new Transaction(-500,500, date.formatDate()));

        formatTransaction.printListTransaction(transactionsList);

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("date       || credit   || debit    || balance");
        inOrder.verify(console).printLine("26/03/2020 ||          || 500 || 500" );
        inOrder.verify(console).printLine("26/03/2020 || 1000 ||          || 0" );

    }

}
