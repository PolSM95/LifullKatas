package Bloaters.LongParameterList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestsShould {

    @Test
    public void customerSummaryIncludesFullNameWithTitleAndCityPostCodeAndCountry()
    {
        Customer customer = new Customer();
        customer.setFirstName("Jason");
        customer.setLastName("Gorman");
        customer.setTitle("Mr");
        Address address = new Address();
        address.setCity("London");
        address.setPostcode("SW23 9YY");
        address.setCountry("United Kingdom");
        customer.setAddress(address);
        assertEquals("Mr Jason Gorman, London, SW23 9YY, United Kingdom", customer.getSummary());
    }

}
