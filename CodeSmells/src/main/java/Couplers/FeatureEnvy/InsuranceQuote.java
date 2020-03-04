package Couplers.FeatureEnvy;

public class InsuranceQuote {
    Motorist motorist;

    public InsuranceQuote(Motorist motorist)
    {
        this.motorist = motorist;
    }

    public double CalculateInsurancePremium(double insuranceValue)
    {
        RiskFactor riskFactor = motorist.CalculateMotoristRisk();

        switch (riskFactor)
        {
            case LOW_RISK:
                return insuranceValue * 0.02;
            case MODERATE_RISK:
                return insuranceValue * 0.04;
            default:
                return insuranceValue * 0.06;
        }
    }
}
