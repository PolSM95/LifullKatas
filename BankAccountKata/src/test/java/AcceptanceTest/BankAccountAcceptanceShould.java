package AcceptanceTest;

import BankAccount.BankAccount;
import BankAccount.Console;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BankAccountAcceptanceShould {

    @Test
    public void AcceptanceTest(){

        Console console = mock(Console.class);
        BankAccount account = new BankAccount(console);
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();

        verify(console).printLine("date       || credit   || debit    || balance");
        verify(console).printLine("14/01/2012 ||          || 500.00   || 2500.00");
        verify(console).printLine("13/01/2012 || 2000.00  ||          || 3000.00");
        verify(console).printLine("10/01/2012 || 1000.00  ||          || 1000.00");


    }
}
