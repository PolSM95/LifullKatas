package infraestructure;

import domain.ShoppingBasket;

public interface ShoppingCartRepository {


    void saveBasket(ShoppingBasket shoppingBasket);
}
