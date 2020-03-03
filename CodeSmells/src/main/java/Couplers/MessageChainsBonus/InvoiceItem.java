package Couplers.MessageChainsBonus;

public class InvoiceItem {
    private final int quantity;
    private final double unitPrice;
    private String itemName;
    private double subtotal;

    public InvoiceItem(String itemName, int quantity, double unitPrice)
    {
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        return unitPrice * quantity;
    }
}
