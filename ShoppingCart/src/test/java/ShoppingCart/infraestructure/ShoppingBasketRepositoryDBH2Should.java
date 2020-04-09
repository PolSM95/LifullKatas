package ShoppingCart.infraestructure;

import ShoppingCart.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShoppingBasketRepositoryDBH2Should {

    @Autowired
    private ShoppingBasketRepositoryDBH2 shoppingBasketRepository;

    @Test
    public void test(){

        UserID userId = new UserID(30002);
        ShoppingBasket shoppingBasket = new ShoppingBasket(userId,"09/04/2020");

        assertEquals(null, null);
    }


}
