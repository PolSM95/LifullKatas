package domain;

import java.util.List;

public class ShoppingBasket
{
    private UserID userID;
    private String dateString;


    public ShoppingBasket(UserID userID, String dateString) {

        this.userID = userID;

        this.dateString = dateString;
    }

    public void addBasketItem(BasketItem basketItem) {
        throw new UnsupportedOperationException();
    }
}
