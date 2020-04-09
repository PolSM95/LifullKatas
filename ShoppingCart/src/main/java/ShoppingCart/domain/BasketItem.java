package ShoppingCart.domain;

import java.util.Objects;

public class BasketItem {
    private Product product;
    private int quantity;

    public BasketItem(Product product, int quantity) {

        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketItem that = (BasketItem) o;
        return quantity == that.quantity &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    @Override
    public String toString() {

        return product.itemDescription(quantity);
    }



    public void addQuantity(BasketItem basketItem) {
        this.quantity += basketItem.quantity;
    }

    public boolean isSameProduct(BasketItem basketItem) {
        return this.product == basketItem.product;
    }

    public double totalPrice() {
        return product.calculateTotalByQuantity(quantity);
    }

    public BasketItemMemento createBasketItemMemento() {
        BasketItemMemento basketItemMemento = new BasketItemMemento();
        basketItemMemento.quantity = quantity;
        basketItemMemento.productMemento = product.createProductMemento();
        return basketItemMemento;
    }
}
