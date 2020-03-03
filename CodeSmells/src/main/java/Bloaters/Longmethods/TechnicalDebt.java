package Bloaters.Longmethods;

import java.util.Calendar;
import java.util.Date;

public class TechnicalDebt {
    public final Issues issues = new Issues();
    private final AssignPriority assignPriority = new AssignPriority();

    private float total;

    private Issue lastIssue;

    private String lastIssueDate;

    public void fixed(float amount)
    {
        this.total -= amount;
    }

    public void register(float effortManHours, String description) {
        assignPriority.throw_exception_when_effort_is_bigger_than_maximum_hours_to_fix(effortManHours);
        Priority priority = Priority.Low;
        priority = assignPriority.set_priority_to_medium(effortManHours, priority);
        priority = assignPriority.set_priority_to_high(effortManHours, priority);
        priority = assignPriority.set_priority_to_critical(effortManHours, priority);
        this.total += effortManHours;
        issues.addIssue(effortManHours, description, priority, this);
        setActualDateInCalendarFormat();
    }

    private void setActualDateInCalendarFormat() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        setLastIssueDate(now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR));
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

}