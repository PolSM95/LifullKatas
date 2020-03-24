package AcceptanceTest;

import BankAccount.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BankAccountAcceptanceShould {

    @Test
    public void AcceptanceTest(){

        Console console = mock(Console.class);
        Transactions transactions = new Transactions();
        BankAccount account = new BankAccount(console, transactions);
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement(); //TODO

        verify(console).printLine("date       || credit   || debit    || balance");
        verify(console).printLine("14/01/2012 ||          || 500      || 2500");
        verify(console).printLine("13/01/2012 || 2000     ||          || 3000");
        verify(console).printLine("10/01/2012 || 1000     ||          || 1000");


    }
}
