package ShoppingCart.infraestructure;

import ShoppingCart.domain.Product.ProductID;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.service.ShoppingBasketService;

public class ShoppingBasketController {
    private ShoppingBasketService shoppingBasketService;

    public ShoppingBasketController(ShoppingBasketService shoppingBasketService) {
        this.shoppingBasketService = shoppingBasketService;
    }

    public void post(String input) {

        String[] splitInput = input.split("\n");
        UserID userID = new UserID(Integer.parseInt(splitInput[0]));

        for (int currentBasketItem = 1; currentBasketItem < splitInput.length; currentBasketItem++) {

            String[] splitBasketItem = splitInput[currentBasketItem].split(",");

            int quantity = Integer.parseInt(splitBasketItem[0]);
            ProductID productID = new ProductID(Integer.parseInt(splitBasketItem[1]));

            shoppingBasketService.addItem(userID, productID, quantity);
        }
    }
}
