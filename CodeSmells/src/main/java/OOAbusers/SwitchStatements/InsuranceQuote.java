package OOAbusers.SwitchStatements;

public class InsuranceQuote {
    private Motorist motorist;

    public InsuranceQuote(Motorist motorist)
    {
        this.motorist = motorist;
    }

    public RiskFactor calculateMotoristRisk()
    {
        if (motorist.getPointsOnLicense() > 3 || motorist.getAge() < 25)
        {
            return RiskFactor.HIGH_RISK;
        }

        if (motorist.getPointsOnLicense() > 0)
        {
            return RiskFactor.MODERATE_RISK;
        }

        return RiskFactor.LOW_RISK;
    }

    public double calculateInsurancePremium(double insuranceValue)
    {
        RiskFactor riskFactor = calculateMotoristRisk();

        return insuranceValue * riskFactor.factor;

    }
}
