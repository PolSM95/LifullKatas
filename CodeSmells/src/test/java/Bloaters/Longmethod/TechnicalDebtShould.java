package Bloaters.Longmethod;

import Bloaters.Longmethods.Priority;
import Bloaters.Longmethods.TechnicalDebt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TechnicalDebtShould {
    private TechnicalDebt technicalDebt;

    @BeforeEach
    public void beforeEach()
    {
        technicalDebt = new TechnicalDebt();
    }

    @Test
    public void fixingIssueIssueDeductsEffortFromTotal()
    {
        technicalDebt.register(50, "Declared Issue class in same file as TechnicalDebt class");

        technicalDebt.fixed(50);
        assertEquals(0, technicalDebt.getTotal());
    }

    @Test
    public void registeringIssueIncreasesTotal()
    {
        technicalDebt.register(50, "Declared Issue class in same file as TechnicalDebt class");

        assertEquals(50, technicalDebt.getTotal());
    }

    @Test
    public void registeringIssueWithEffortBiggerThanFiveHundredMarksItAsCriticalPriority()
    {
        technicalDebt.register(501, "Declared Issue class in same file as TechnicalDebt class");

        assertEquals(Priority.Critical, technicalDebt.issues.getLastIssue().getPriority());
    }

    @Test
    public void registeringIssueWithEffortBiggerThanTwoHundredAndFiftyMarksItAsHighPriority()
    {
        technicalDebt.register(251, "Declared Issue class in same file as TechnicalDebt class");

        assertEquals(Priority.High, technicalDebt.issues.getLastIssue().getPriority());
    }

    @Test
    public void registeringIssueWithEffortBiggerThanOneHundredMarksItAsHighPriority()
    {
        technicalDebt.register(101, "Declared Issue class in same file as TechnicalDebt class");

        assertEquals(Priority.Medium, technicalDebt.issues.getLastIssue().getPriority());
    }

    @Test
    public void registeringIssueWithEffortEqualOrLowerThanOneHundredMarksItAsLowPriority()
    {
        technicalDebt.register(100, "Declared Issue class in same file as TechnicalDebt class");

        assertEquals(Priority.Low, technicalDebt.issues.getLastIssue().getPriority());
    }

    @Test
    public void registeringIssueUpdatesLastIssueDate()
    {
        technicalDebt.register(50, "Declared Issue class in same file as TechnicalDebt class");

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        String expectedDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
        assertEquals(expectedDate, technicalDebt.getLastIssueDate());
    }

    @Test
    public void registeringMoreThanMaxAllowedEffortThrowsException()
    {
        assertThrows(RuntimeException.class, () -> technicalDebt.register(1001, "The PM forced me to register this"));
    }

    @Test
    public void RegisteringLessThanMinAllowedEffortThrowsException()
    {
        assertThrows(RuntimeException.class, () -> technicalDebt.register(0, "The PM forced me to register this"));
    }
}
