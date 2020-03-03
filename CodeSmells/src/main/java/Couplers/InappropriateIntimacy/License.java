package Couplers.InappropriateIntimacy;

public class License {
    private Motorist motorist;
    public int points;

    public String getSummary()
    {
            return motorist.getTitle() + " " + motorist.getFirstName() + " " + motorist.getSurname() + ", " + points + " points";
    }

    public void addPoints(int points)
    {
        this.points += points;
    }

    public RiskFactor getRiskFactor() {
        if (this.points > 3) {
            return RiskFactor.HIGH_RISK;
        }

        if (this.points > 0) {
            return RiskFactor.MODERATE_RISK;
        }

        return RiskFactor.LOW_RISK;
    }

    public void setMotorist(Motorist motorist) {
        this.motorist = motorist;
    }
}
