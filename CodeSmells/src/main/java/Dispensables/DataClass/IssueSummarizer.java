package Dispensables.DataClass;

public class IssueSummarizer {
    private Issue issue;

    public IssueSummarizer(Issue issue)
    {
        this.issue = issue;
    }

    public String getIssueSummary() {
        return issue.getSummary();
    }
}
