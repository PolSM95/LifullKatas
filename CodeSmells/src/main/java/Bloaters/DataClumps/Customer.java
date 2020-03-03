package Bloaters.DataClumps;

public class Customer {
    private String title;
    private String firstName;
    private String lastName;
    Address address;

    public Customer(String title, String firstName, String lastName, String house, String street, String city, String postCode, String country) {
        address = new Address(house, street, city, postCode, country);
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;

    }

    public String getAddressSummary() {
        return address.GetAddressSummary();
    }
}
