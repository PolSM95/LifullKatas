package Dispensables.DupplicateCode;

import Dispensables.DuplicateCode.Issue;
import Dispensables.DuplicateCode.TechnicalDebt;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TechnicalDebtShould {

    @Test
    public void AddAmountFromBalanceRecordTransactionAndUpdateLastDebitDate()
    {
        TechnicalDebt account = new TechnicalDebt();
        account.register(50, "Some technical debt");
        assertEquals(50, account.getBalance());

        Issue lastTransaction = account.getLastTransaction();
        assertEquals(50, lastTransaction.getEffortManHours());

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        String expectedLastTransactionDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
        assertEquals(expectedLastTransactionDate, account.getLastTransactionDate());
    }

    @Test
    public void DeductAmountFromBalanceRecordTransactionAndUpdateLastdebitDate()
    {
        TechnicalDebt account = new TechnicalDebt();
        account.register(100, "Some technical debt");
        account.fix(50, "Fix technical debt");
        assertEquals(50, account.getBalance());
        Issue lastTransaction = account.getLastTransaction();
        assertEquals(-50, lastTransaction.getEffortManHours());

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        String expectedLastTransactionDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
        assertEquals(expectedLastTransactionDate, account.getLastTransactionDate());
    }
}
