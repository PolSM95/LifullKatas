package ShoppingCart.domain;

import ShoppingCart.domain.ShoppingBasket;
import ShoppingCart.domain.UserID;

public interface ShoppingBasketRepository {

    void saveBasket(ShoppingBasket shoppingBasket);

    ShoppingBasket getBasketByUserId(UserID userId);
}
