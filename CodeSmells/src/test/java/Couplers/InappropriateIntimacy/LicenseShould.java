package Couplers.InappropriateIntimacy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LicenseShould {
    @Test
    public void LicenseSummaryShouldIncludeLicenseHolderFullNameAndPoints()
    {
        License license = new License();
        license.addPoints(3);
        Motorist motorist = new Motorist(license, "Gorman", "Jason", "Mr");
        assertEquals("Mr Jason Gorman, 3 points", license.getSummary());
    }
}
