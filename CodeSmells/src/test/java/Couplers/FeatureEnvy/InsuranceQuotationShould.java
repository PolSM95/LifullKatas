package Couplers.FeatureEnvy;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsuranceQuotationShould {
    private RiskFactor calculateMotoristRisk(String dateOfBirth, int pointsOnLicense)
    {
        return buildInsuranceQuoteForMotorist(dateOfBirth, pointsOnLicense).motorist.CalculateMotoristRisk();
    }

    private InsuranceQuote buildInsuranceQuoteForMotorist(String dateOfBirth, int pointsOnLicense)
    {
        return new InsuranceQuote(new Motorist(parseDate(dateOfBirth), pointsOnLicense));
    }

    private Date parseDate(String dateOfBirth)
    {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Date();
        }
    }

    @Test
    public void anyMotoristUnderTwentyFiveIsHighRisk()
    {
        assertEquals(RiskFactor.HIGH_RISK, calculateMotoristRisk("1996-01-01", 0));
    }

    @Test
    public void highRiskMotoristsPayPremiumOfSixPercentOfInsuranceValue()
    {
        InsuranceQuote quote = buildInsuranceQuoteForMotorist("1990-01-01", 5);
        assertEquals(600, quote.CalculateInsurancePremium(10000));
    }

    @Test
    public void lowRiskMotoristsPayPremiumOfTwoPercentOfInsuranceValue()
    {
        InsuranceQuote quote = buildInsuranceQuoteForMotorist("1960-01-01", 0);
        assertEquals(200, quote.CalculateInsurancePremium(10000));
    }

    @Test
    public void moderateRiskMotoristsPayPremiumOfFourPercentOfInsuranceValue()
    {
        InsuranceQuote quote = buildInsuranceQuoteForMotorist("1960-01-01", 1);
        assertEquals(400, quote.CalculateInsurancePremium(10000));
    }

    @Test
    public void motoristWithMoreThanThreePointsOnLicenseOverTwentyFivePresentsHighRisk()
    {
        assertEquals(RiskFactor.HIGH_RISK, calculateMotoristRisk("1970-01-01", 4));
    }

    @Test
    public void motoristWithNoPointsOnLicenseAndOverTwentyFivePresentsLowRisk()
    {
        assertEquals(RiskFactor.LOW_RISK, calculateMotoristRisk("1970-01-01", 0));
    }

    @Test
    public void MotoristWithOneToThreePointsOnLicenseAndOverTwentyFivePresentsModerateRisk()
    {
        assertEquals(RiskFactor.MODERATE_RISK, calculateMotoristRisk("1970-01-01", 3));
    }

}
