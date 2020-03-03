package Dispensables.DataClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueSummaryViewShould {

    @Test
     public void customerSummaryIncludesFullNameWithTitleAndCityPostCodeAndCountry()
    {
        Issue issue = new Issue(10, "Some critical issue", Priority.Critical);
        String summary = new IssueSummarizer(issue).getIssueSummary();

        assertEquals("Description:'Some critical issue' Effort:'10.0' Priority:'Critical'", summary);
    }
}
