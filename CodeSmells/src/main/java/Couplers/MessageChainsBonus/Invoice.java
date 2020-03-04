package Couplers.MessageChainsBonus;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    public final static double SHIPPING_COST_OUTSIDE_EU = 10;
    private final Customer customer;
    private final List<InvoiceItem> invoiceItems = new ArrayList<>();

    public Invoice(Customer customer)
    {
        this.customer = customer;
    }

    private double TotalPrice;

    public void addItem(InvoiceItem invoiceItem)
    {
        invoiceItems.add(invoiceItem);
    }

    public double getTotalPrice() {
        double invoiceTotal = 0;

        for(InvoiceItem invoiceItem : invoiceItems)
        {
            invoiceTotal += invoiceItem.getSubtotal();
        }

        Country country = customer.getCountry();

        if (!country.isInEurope())
        {
            invoiceTotal += SHIPPING_COST_OUTSIDE_EU;
        }
        return invoiceTotal;
    }

}
