package unit;

import ShoppingCart.domain.ShoppingBasket.ShoppingBasketMemento;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.infraestructure.ProductRepositoryDBH2;
import ShoppingCart.infraestructure.ShoppingBasketController;
import ShoppingCart.infraestructure.ShoppingBasketRepositoryDBH2;
import ShoppingCart.infraestructure.ShoppingBasketWebController;
import ShoppingCart.service.BasketDate;
import ShoppingCart.service.ShoppingBasketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShoppingBasketWebControllerShould {

    //GetBasket
    //PostItem
    BasketDate basketDate;
    ProductRepositoryDBH2 productRepositoryDBH2;
    ShoppingBasketRepositoryDBH2 shoppingBasketRepositoryDBH2;
    @InjectMocks
    ShoppingBasketWebController shoppingBasketWebController;

    @BeforeEach
    public void init(){
        basketDate = mock(BasketDate.class);
        productRepositoryDBH2 = mock(ProductRepositoryDBH2.class);
        shoppingBasketRepositoryDBH2 = mock(ShoppingBasketRepositoryDBH2.class);
    }

    @Test
    public void raise_http_message_not_found_when_there_is_no_basket_for_a_user(){
        MockitoAnnotations.initMocks(this);
        UserID userID = new UserID(30001);
        when(shoppingBasketRepositoryDBH2.getBasketByUserId(userID)).thenReturn(null);
        ResponseEntity<ShoppingBasketMemento> basketResponse = shoppingBasketWebController.getBasket(30001);
        assertEquals(HttpStatus.NOT_FOUND, basketResponse.getStatusCode());
        assertEquals(null, basketResponse.getBody());
    }

}
