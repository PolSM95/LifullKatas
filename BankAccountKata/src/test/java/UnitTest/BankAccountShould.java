package UnitTest;

import BankAccount.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BankAccountShould {

    @Test
    public void add_deposit_transaction_to_transactions_in_repository(){
        Console console = mock(Console.class);
        Transactions transactions = mock(Transactions.class);
        BankAccount bankAccount = new BankAccount(console, transactions);
        bankAccount.deposit(1000);

        Transaction transactionExpected = new Transaction(1000, 1000);
        verify(transactions).addTransaction(transactionExpected);
    }
    @Test
    public void add_withdraw_transaction_to_transactions_in_repository(){
        Console console = mock(Console.class);
        Transactions transactions = mock(Transactions.class);
        BankAccount bankAccount = new BankAccount(console, transactions);
        bankAccount.withdraw(500);

        Transaction transactionExpected = new Transaction(-500, -500);
        verify(transactions).addTransaction(transactionExpected);
    }
    @Test
    public void add_deposit_and_withdraw_transaction_to_transactions_in_repository(){
        Console console = mock(Console.class);
        Transactions transactions = mock(Transactions.class);
        BankAccount bankAccount = new BankAccount(console, transactions);

        bankAccount.deposit(500);

        Transaction transactionExpected = new Transaction(500, 500);
        verify(transactions).addTransaction(transactionExpected);

        bankAccount.withdraw(200);
        transactionExpected = new Transaction(-200, 300);
        verify(transactions).addTransaction(transactionExpected);

    }
    @Test
    public void add_withdraw_transaction_to_transactions_in_repository_when_balance_is_lower(){
        Console console = mock(Console.class);
        Transactions transactions = mock(Transactions.class);
        BankAccount bankAccount = new BankAccount(console, transactions);

        bankAccount.deposit(500);

        Transaction transactionExpected = new Transaction(500, 500);
        verify(transactions).addTransaction(transactionExpected);

        bankAccount.withdraw(600);
        transactionExpected = new Transaction(-500, 0);
        verify(transactions).addTransaction(transactionExpected);

    }

    @Test
    public void throw_exception_when_depositing_any_negative_amount(){
        Console console = mock(Console.class);
        Transactions transactions = mock(Transactions.class);
        BankAccount bankAccount = new BankAccount(console, transactions);


        assertThrows(NullPointerException.class, () -> bankAccount.deposit(-500));
        verify(transactions, never()).addTransaction(any());

    }



}
