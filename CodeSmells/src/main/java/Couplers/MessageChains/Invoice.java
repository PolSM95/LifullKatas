package Couplers.MessageChains;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    public static final double SHIPPING_COST_OUTSIDE_EU = 10;
    private double totalPrice;
    private final Customer customer;
    private final List<InvoiceItem> invoiceItems = new ArrayList<>();

    public Invoice(Customer customer)
    {
        this.customer = customer;
    }

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

        if (!customer.isInEurope())
        {
            invoiceTotal += SHIPPING_COST_OUTSIDE_EU;
        }
        return invoiceTotal;
    }

}
