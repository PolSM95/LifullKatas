package Dispensables.DuplicateCode;

import Dispensables.DuplicateCode.Issue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TechnicalDebt {
    private List<Issue> transactions = new ArrayList<Issue>();

    private float balance;

    private Issue lastTransaction;

    private String lastTransactionDate;

    public void register(float effortManHours, String description)
    {
        float effortManHours1 = -effortManHours;
        fix(effortManHours1, description);
    }

    public void fix(float effortManHours, String description)
    {
        this.balance -= effortManHours;
        transactions.add(new Issue(-effortManHours, description));
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        lastTransactionDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Issue getLastTransaction() {
        return transactions.get((transactions.size() - 1));
    }

    public String getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(String lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }
}
