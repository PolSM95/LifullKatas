package Bloaters.DataClumps;

public class Address {

    public String House;

    public String Street;

    public String City;

    public String Postcode;

    public String Country;

    public String GetAddressSummary()
    {
        return House + ", " + Street + ", " + City + ", " + Postcode + ", "
                + Country;
    }
}
