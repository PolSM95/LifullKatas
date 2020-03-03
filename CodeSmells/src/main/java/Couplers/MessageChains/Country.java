package Couplers.MessageChains;

public class Country {
    private boolean isInEurope;

    public Country(boolean inEurope)
    {
        this.isInEurope = inEurope;
    }

    public boolean isInEurope() {
        return isInEurope;
    }
}
