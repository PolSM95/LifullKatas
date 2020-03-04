package Couplers.MessageChains;

public class Customer {
    private Address address;

    public Customer(Address address)
    {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isInEurope() {
        return isAddressInEurope();
    }

    public boolean isAddressInEurope() {
        return address.isCountryInEurope();
    }

}
