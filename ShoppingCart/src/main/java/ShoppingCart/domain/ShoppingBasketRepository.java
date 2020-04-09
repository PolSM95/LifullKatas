package ShoppingCart.domain;

import ShoppingCart.domain.ShoppingBasket.ShoppingBasket;
import ShoppingCart.domain.ShoppingBasket.UserID;

public interface ShoppingBasketRepository {
    void saveBasket(ShoppingBasket shoppingBasket);

    ShoppingBasket getBasketByUserId(UserID userId);
}
