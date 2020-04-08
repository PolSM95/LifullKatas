package infraestructure;

import domain.ShoppingBasket;
import domain.UserID;

public interface ShoppingBasketRepository {

    void saveBasket(ShoppingBasket shoppingBasket);

    ShoppingBasket getBasketByUserId(UserID userId);
}
