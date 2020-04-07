package infraestructure;

import domain.ProductID;
import domain.UserID;
import service.ShoppingCartService;

public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public void post(String input) {

        String[] splitInput = input.split("\n");
        UserID userID = new UserID(Integer.parseInt(splitInput[0]));

        for (int currentBasketItem = 1; currentBasketItem < splitInput.length; currentBasketItem++) {

            String[] splitBasketItem = splitInput[currentBasketItem].split(",");

            int quantity = Integer.parseInt(splitBasketItem[0]);
            ProductID productID = new ProductID(Integer.parseInt(splitBasketItem[1]));

            shoppingCartService.addItem(userID, productID, quantity);
        }
    }
}
