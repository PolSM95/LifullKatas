package infraestructure;

import domain.ProductID;
import domain.ShoppingCartRepository;
import domain.UserID;

public class ShoppingCartService {
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {

        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void addItem(UserID userID, ProductID productID, int quantity) {

    }
}
