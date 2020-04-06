package infraestructure;

import domain.ShoppingCartRepository;

public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;

    public ShoppingCartController() {

    }

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public void post(String input) {


    }
}
