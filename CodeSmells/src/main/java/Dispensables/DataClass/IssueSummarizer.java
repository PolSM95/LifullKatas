package Dispensables.DataClass;

public class IssueSummarizer {
    private Issue issue;

    public IssueSummarizer(Issue issue)
    {
        this.issue = issue;
    }

    public String getIssueSummary() {
        return "Description:'" + issue.getDescription() + "' Effort:'" + issue.getEffortManHours() + "' Priority:'" + issue.getPriority() + "'";
    }
}
