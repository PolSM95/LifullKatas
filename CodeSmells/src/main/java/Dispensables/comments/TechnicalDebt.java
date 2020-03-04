package Dispensables.comments;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TechnicalDebt
{
    public static final int MAX_EFFORT = 1000;
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

        check_effort_does_not_exceed_max_allowed(effortManHours);

        total += effortManHours;

        recordIssue(effortManHours, description);

        update_last_issue_date();
    }

    private void update_last_issue_date() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        lastIssueDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
    }

    private void recordIssue(float effortManHours, String description) {
        issues.add(new Issue(effortManHours, description));
    }

    private void check_effort_does_not_exceed_max_allowed(float effortManHours) {
        if (effortManHours > MAX_EFFORT)
        {
            throw new RuntimeException("Cannot register tech debt where effort is bigger than 1000 man hours to fix");
        }
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