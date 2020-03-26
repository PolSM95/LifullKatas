package UnitTest;

import BankAccount.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BankAccountShould {

    Console console;
    Transactions transactions;
    FormatTransaction formatTransaction;
    BankAccount bankAccount;

    @BeforeEach
    public void testInit(){
       console = mock(Console.class);
       transactions = mock(Transactions.class);
       formatTransaction = mock(FormatTransaction.class);
       bankAccount = new BankAccount(transactions, formatTransaction);
    }

    @Test
    public void add_deposit_transaction_to_transactions_in_repository(){

        bankAccount.deposit(1000);

        Transaction transactionExpected = new Transaction(1000, 1000);
        verify(transactions).addTransaction(transactionExpected);
    }
    @Test
    public void add_withdraw_transaction_to_transactions_in_repository(){

        bankAccount.withdraw(500);

        Transaction transactionExpected = new Transaction(-500, -500);
        verify(transactions).addTransaction(transactionExpected);
    }
    @Test
    public void add_deposit_and_withdraw_transaction_to_transactions_in_repository(){

        bankAccount.deposit(500);

        Transaction transactionExpected = new Transaction(500, 500);
        verify(transactions).addTransaction(transactionExpected);

        bankAccount.withdraw(200);
        transactionExpected = new Transaction(-200, 300);
        verify(transactions).addTransaction(transactionExpected);

    }
    @Test
    public void add_withdraw_transaction_to_transactions_in_repository_when_balance_is_lower(){

        bankAccount.deposit(500);

        Transaction transactionExpected = new Transaction(500, 500);
        verify(transactions).addTransaction(transactionExpected);

        bankAccount.withdraw(600);
        transactionExpected = new Transaction(-500, 0);
        verify(transactions).addTransaction(transactionExpected);

    }

    @Test
    public void throw_exception_when_depositing_any_negative_amount(){

        assertThrows(NullPointerException.class, () -> bankAccount.deposit(-500));
        verify(transactions, never()).addTransaction(any());

    }

    @Test
    public void check_that_transactionList_is_showed_correctly(){

        List<Transaction> transactionsList = new ArrayList<>();

        transactionsList.add(new Transaction(1000,0));
        transactionsList.add(new Transaction(500,1000));

        when(transactions.getTransactionList()).thenReturn(transactionsList);

        bankAccount.printStatement();

        verify(formatTransaction).printListTransaction(transactionsList);

    }



}
