package OOAbusers.SwitchStatements;

public enum RiskFactor {
    LOW_RISK (0.02),
    MODERATE_RISK (0.04),
    HIGH_RISK (0.06);
    public final double factor;

    RiskFactor(double factor){
        this.factor = factor;
    }
}
