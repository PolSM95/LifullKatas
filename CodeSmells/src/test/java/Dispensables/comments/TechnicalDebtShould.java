package Dispensables.comments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TechnicalDebtShould {

    private TechnicalDebt technicalDebt;

    @BeforeEach
    public void initialSetUp() {
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
    public void registeringIssueUpdatesLastIssueDate()
    {
        technicalDebt.register(50, "Declared Issue class in same file as TechnicalDebt class");

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        String expectedLastIssueDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);

        assertEquals(expectedLastIssueDate, technicalDebt.getLastIssueDate());
    }

    @Test
    public void registeringMoreThanMaxAllowedEffortThrowsException()
    {
        assertThrows(RuntimeException.class, () -> {
            technicalDebt.register(1001, "The PM forced me to register this");
        });
    }
}