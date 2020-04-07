package unit;

import domain.ProductID;
import domain.ShoppingCartRepository;
import domain.UserID;
import infraestructure.ShoppingCartController;
import infraestructure.ShoppingCartService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class ShoppingCartControllerShould {

    @Test
    void check_add_item_to_shopping_cart_services_after_parsing_the_input(){
        ShoppingCartService shoppingCartService = mock(ShoppingCartService.class);
        ShoppingCartController shoppingCartController = new ShoppingCartController(shoppingCartService);

        String input = "30001\n2,10002\n5,20110";
        shoppingCartController.post(input);


        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);
        ProductID productID2 = new ProductID(20110);

        verify(shoppingCartService).addItem(userID, productID1, 2);
        verify(shoppingCartService).addItem(userID, productID2, 5);
    }

}
