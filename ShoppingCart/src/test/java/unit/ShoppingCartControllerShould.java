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
    void test(){
        ShoppingCartService shoppingCartService = mock(ShoppingCartService.class);
        ShoppingCartController shoppingCartController = new ShoppingCartController(shoppingCartService);

        String input = "2,10002\n5,20110";
        shoppingCartController.post(input);



        ProductID productID1 = new ProductID(10002);
        ProductID productID2 = new ProductID(20110);

        verify(shoppingCartService).addItem(any(UserID.class), productID1, 2);
        verify(shoppingCartService).addItem(any(UserID.class), productID2, 5);


    }

}
