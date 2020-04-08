package domain;

import exception.ProductDoesNotExistException;
import exception.ProductNegativeQuantityException;

import java.util.Objects;

public class ShoppingBasket
{
    private UserID userID;
    private String dateString;
    private BasketItemList basketItemList;


    public ShoppingBasket(UserID userID, String dateString) {

        this.userID = userID;
        this.dateString = dateString;
        this.basketItemList = new BasketItemList();
    }

    public void addProductToShoppingBasket(Product product, int quantity) {

        if (product == null){
            throw new ProductDoesNotExistException("Product does not exist");
        }
        if(quantity<=0){
            throw new ProductNegativeQuantityException("Quantity can not be negative");
        }

        BasketItem basketItem = new BasketItem(product, quantity);

        basketItemList.addBasketItemToAList(basketItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasket that = (ShoppingBasket) o;
        return Objects.equals(userID, that.userID) &&
                Objects.equals(dateString, that.dateString) &&
                Objects.equals(basketItemList, that.basketItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, dateString, basketItemList);
    }

    @Override
    public String toString() {
        return "ShoppingBasket{" +
                "userID=" + userID +
                ", dateString='" + dateString + '\'' +
                ", basketItemList=" + basketItemList +
                '}';
    }
}
