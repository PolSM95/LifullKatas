package Dispensables.comments;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TechnicalDebt
{
    private List<Issue> issues = new ArrayList<Issue>();

    private float total;

    private Issue lastIssue;

    private String lastIssueDate;

    public void fixed(float amount)
    {
        total -= amount;
    }

    public void register(float effortManHours, String description)
    {
        // check effort does not exceed max allowed
        if (effortManHours > 1000)
        {
            throw new RuntimeException("Cannot register tech debt where effort is bigger than 1000 man hours to fix");
        }

        // deduct amount from total
        total += effortManHours;

        // record issue
        issues.add(new Issue(effortManHours, description));

        // update last issue date
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        lastIssueDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Issue getLastIssue() {
        return issues.get((issues.size() - 1));
    }

    public String getLastIssueDate() {
        return lastIssueDate;
    }
}