package Bloaters.DataClumps;

public class Customer {
    public Customer(String title, String firstName, String lastName, String house, String street, String city, String postCode, String country)
    {
        setHouse(house);
        setStreet(street);
        setCity(city);
        setPostCode(postCode);
        setCountry(country);
        setFirstName(firstName);
        setLastName(lastName);
        setTitle(title);
    }

    private String title;
    private String firstName;
    private String lastName;
    private String house;
    private String street;
    private String city;
    private String postCode;
    private String country;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressSummary() {
        return house + ", " + street + ", " + city + ", " + postCode + ", " + country;
    }
}
