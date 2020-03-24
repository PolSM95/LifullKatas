package UnitTest;

import BankAccount.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class BankAccountShould {

    @Test
    public void add_deposit_to_transactions_in_repository(){
        Transactions transactions = mock(Transactions.class);
        BankAccount bankAccount = new BankAccount(transactions);
        bankAccount.deposit(1000);

        Transaction transactionExpected = new Transaction(1000, 0);
        verify(transactions).addTransaction(transactionExpected);
}


}
