package Couplers.InappropriateIntimacy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoristShould {
    private Motorist createMotoristWithPointsOnLicense(int points)
    {
        License license = new License();
        license.addPoints(points);
        Motorist motorist = new Motorist(license, "", "", "");
        return motorist;
    }

    @Test
    public void motoristWithMoreThanThreePointsOnLicenseIsHighRisk()
    {
        assertEquals(RiskFactor.HIGH_RISK, createMotoristWithPointsOnLicense(4).getLicense().getRiskFactor());
    }

    @Test
    public void motoristWithNoPointsOnLicenseIsLowRisk()
    {
        assertEquals(RiskFactor.LOW_RISK, createMotoristWithPointsOnLicense(0).getLicense().getRiskFactor());
    }

    @Test
    public void motoristWithOneToThreePointsOnLicenseIsModerateRisk()
    {
        assertEquals(RiskFactor.MODERATE_RISK, createMotoristWithPointsOnLicense(1).getLicense().getRiskFactor());
    }
}
