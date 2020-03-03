package Bloaters.DataClumps;

public class Address {

    public String House;

    public String Street;

    public String City;

    public String Postcode;

    public String Country;

    public Address(String house, String street, String city, String postcode, String country) {
        House = house;
        Street = street;
        City = city;
        Postcode = postcode;
        Country = country;
    }

    public String GetAddressSummary()
    {
        return House + ", " + Street + ", " + City + ", " + Postcode + ", "
                + Country;
    }
}
