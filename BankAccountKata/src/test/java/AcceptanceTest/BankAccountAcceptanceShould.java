package AcceptanceTest;

import BankAccount.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BankAccountAcceptanceShould {

    @Test
    public void AcceptanceTest(){

        Console console = mock(Console.class);
        Transactions transactions = new Transactions();
        FormatTransaction formatTransaction = new FormatTransaction(console);
        FormatDate date = new FormatDate();
        BankAccount account = new BankAccount(transactions, formatTransaction,date);
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement(); //TODO

        verify(console).printLine("date       || credit   || debit    || balance");
        verify(console).printLine("26/03/2020 ||          || 500 || 2500");
        verify(console).printLine("26/03/2020 || 2000 ||          || 3000");
        verify(console).printLine("26/03/2020 || 1000 ||          || 1000");


    }
}
