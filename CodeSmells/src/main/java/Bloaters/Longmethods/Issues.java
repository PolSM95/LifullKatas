package Bloaters.Longmethods;

import java.util.ArrayList;
import java.util.List;

public class Issues {
    List<Issue> issues = new ArrayList<Issue>();

    public Issues() {
    }

    public Issue getLastIssue() {
        return issues.get((issues.size() - 1));
    }

    void addIssue(float effortManHours, String description, Priority priority, TechnicalDebt technicalDebt) {
        this.issues.add(new Issue(effortManHours, description, priority));
    }
}