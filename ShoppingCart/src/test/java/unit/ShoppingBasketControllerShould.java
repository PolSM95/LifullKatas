package unit;

import domain.ProductID;
import domain.UserID;
import infraestructure.ShoppingBasketController;
import service.ShoppingBasketService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class ShoppingBasketControllerShould {

    @Test
    void check_add_item_to_shopping_cart_services_after_parsing_the_input(){
        ShoppingBasketService shoppingBasketService = mock(ShoppingBasketService.class);
        ShoppingBasketController shoppingBasketController = new ShoppingBasketController(shoppingBasketService);

        String input = "30001\n2,10002\n5,20110";
        shoppingBasketController.post(input);

        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);
        ProductID productID2 = new ProductID(20110);


        verify(shoppingBasketService).addItem(userID, productID1, 2);
        verify(shoppingBasketService).addItem(userID, productID2, 5);
    }



}
