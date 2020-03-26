package AcceptanceTest;

import BankAccount.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class BankAccountAcceptanceShould {

    @Test
    public void AcceptanceTest(){
        Console console = mock(Console.class);
        Transactions transactions = new Transactions();
        FormatTransaction formatTransaction = new FormatTransaction(console);
        FormatDate date = mock(FormatDate.class);
        BankAccount account = new BankAccount(transactions, formatTransaction, date);

        when(date.formatDate()).thenReturn("10/01/2012","13/01/2012", "14/01/2012");

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("date       || credit   || debit    || balance");
        inOrder.verify(console).printLine("14/01/2012 ||          || 500 || 2500");
        inOrder.verify(console).printLine("13/01/2012 || 2000 ||          || 3000");
        inOrder.verify(console).printLine("10/01/2012 || 1000 ||          || 1000");
    }
}
