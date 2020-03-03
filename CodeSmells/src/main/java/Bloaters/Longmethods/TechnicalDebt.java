package Bloaters.Longmethods;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TechnicalDebt {
    private List<Issue> issues = new ArrayList<Issue>();

    private float total;

    private Issue lastIssue;

    private String lastIssueDate;

    public void fixed(float amount)
    {
        setTotal(getTotal() - amount);
    }

    public void register(float effortManHours, String description)
    {
        if (effortManHours > 1000 || effortManHours <= 0)
        {
            throw new RuntimeException("Cannot register tech debt where effort is bigger than 1000 man hours to fix");
        }

        Priority priority = Priority.Low;

        if (effortManHours > 100)
        {
            priority = Priority.Medium;
        }

        if (effortManHours > 250)
        {
            priority = Priority.High;
        }

        if (effortManHours > 500)
        {
            priority = Priority.Critical;
        }

        setTotal(getTotal() + effortManHours);

        issues.add(new Issue(effortManHours, description, priority));

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        setLastIssueDate(now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR));
    }

    public Issue getLastIssue() {
        return issues.get((issues.size() - 1));
    }

    public String getLastIssueDate() {
        return lastIssueDate;
    }

    public void setLastIssueDate(String lastIssueDate) {
        this.lastIssueDate = lastIssueDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}