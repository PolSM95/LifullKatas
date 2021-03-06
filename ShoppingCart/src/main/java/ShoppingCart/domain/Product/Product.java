package ShoppingCart.domain.Product;

import java.util.Objects;

public class Product {
    private final ProductID productID;
    private final String productName;
    private final double productPrice;

    public Product(ProductID productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public static Product createFromMemento(ProductMemento productMemento) {
        ProductID productID = new ProductID(productMemento.productIDMemento.productIDMemento);
        String productName = productMemento.productName;
        double productPrice = productMemento.productPrice;
        return new Product(productID, productName, productPrice);
    }

    public double calculateTotalByQuantity(int quantity) {
        return quantity * productPrice;
    }

    public ProductMemento createProductMemento() {
        ProductMemento productMemento = new ProductMemento();
        productMemento.productPrice = productPrice;
        productMemento.productName = productName;
        productMemento.productIDMemento = productID.createProductIdMemento();
        return productMemento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.productPrice, productPrice) == 0 &&
                Objects.equals(productID, product.productID) &&
                Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productName, productPrice);
    }

    public String itemDescription(int quantity) {

        return quantity + " x " + productName + " // " + quantity + " x " +
                productPrice + " = €" +calculateTotalByQuantity(quantity) + "\n";

    }


}
