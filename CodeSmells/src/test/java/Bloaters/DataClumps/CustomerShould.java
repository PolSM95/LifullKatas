package Bloaters.DataClumps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerShould {

    @Test
    public void customerAddressSummaryIncludesHouseStreetCityPostCodeAndCountry()
    {
        Customer customer = new Customer("Dr", "Joseph", "Bloggs", "43", "Rankin Road", "London", "SW23 9YY", "United Kingdom");

        assertEquals("43, Rankin Road, London, SW23 9YY, United Kingdom", customer.getAddressSummary());
    }

}
