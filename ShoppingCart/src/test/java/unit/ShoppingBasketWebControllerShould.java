package unit;

import ShoppingCart.domain.ShoppingBasket.ShoppingBasketMemento;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.infraestructure.ShoppingBasketController;
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
    @Mock
    ShoppingBasketService shoppingBasketService;
    ShoppingBasketController shoppingBasketController;
    @InjectMocks
    ShoppingBasketWebController shoppingBasketWebController;


    @BeforeEach
    public void init(){
        basketDate = mock(BasketDate.class);
        //shoppingBasketService = mock(ShoppingBasketService.class);
        shoppingBasketWebController = new ShoppingBasketWebController();
        shoppingBasketController = new ShoppingBasketController(shoppingBasketService);

    }

    @Test
    public void test(){
        MockitoAnnotations.initMocks(this);
        UserID userID = new UserID(30001);
        when(shoppingBasketService.basketFor(userID)).thenReturn(null);
        ResponseEntity<ShoppingBasketMemento> basketResponse = shoppingBasketWebController.getBasket(30001);

        assertEquals(HttpStatus.NOT_FOUND, basketResponse.getStatusCode());
        assertEquals(null, basketResponse.getBody());
    }

}
