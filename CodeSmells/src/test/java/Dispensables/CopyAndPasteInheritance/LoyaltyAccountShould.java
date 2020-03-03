package Dispensables.CopyAndPasteInheritance;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoyaltyAccountShould {
    @Test
    public void debitingAccountShouldDeductAmountFromBalanceRecordTransactionAndUpdateLastdebitDate()
    {
        LoyaltyAccount account = new LoyaltyAccount();
        account.credit(100);
        account.debit(50);
        assertEquals(50, account.getBalance());
        Transaction lastTransaction = account.getLastTransaction();
        assertEquals(-50, lastTransaction.getAmount());

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        assertEquals(now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR), account.getLastTransactionDate());
    }
}
