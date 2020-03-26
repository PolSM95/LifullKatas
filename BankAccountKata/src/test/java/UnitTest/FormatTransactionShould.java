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

    @BeforeEach
    public void init(){
        console = mock(Console.class);
        formatTransaction = new FormatTransaction(console);
    }


    @Test
    public void print_header_when_transaction_list_is_empty(){
        List <Transaction> transactionsList = new ArrayList<>();
        formatTransaction.printListTransaction(transactionsList);

        verify(console).printLine("date       || credit   || debit    || balance");
    }
}
