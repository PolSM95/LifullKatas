package UnitTest;

import BankAccount.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class BankAccountShould {

    @Test
    public void test(){
        Transactions transactions = mock(Transactions.class);
        BankAccount bankAccount = new BankAccount(transactions);
        bankAccount.deposit(1000);

        //verify(transactions).addTransaction();
}


}
