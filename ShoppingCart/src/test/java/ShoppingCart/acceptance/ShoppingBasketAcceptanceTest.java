package ShoppingCart.acceptance;

import ShoppingCart.domain.Product.Product;
import ShoppingCart.domain.Product.ProductID;
import ShoppingCart.domain.ProductRespository;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasket;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasketMemento;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.domain.ShoppingBasketRepository;
import ShoppingCart.infraestructure.*;
import ShoppingCart.service.BasketDate;
import ShoppingCart.service.ShoppingBasketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest

public class ShoppingBasketAcceptanceTest {

    @Autowired
    ShoppingBasketRepository shoppingBasketRepository;
    @Autowired
    ProductRespository productRespository;
    @Autowired
    ShoppingBasketWebController shoppingBasketWebController;

    BasketDate basketDate;
    ShoppingBasketService shoppingBasketService;


    @BeforeEach
    public void init(){
        basketDate = mock(BasketDate.class);
        shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRespository, basketDate);
    }

    @Test
    void acceptanceTest(){
        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);
        ProductID productID2 = new ProductID(20110);
        Product hobbit = new Product(productID1, "The Hobbit", 5.00);
        Product breakingBad = new Product(productID2, "Breaking Bad", 7.00);

        when(basketDate.getDate()).thenReturn("14/04/2020");

        ShoppingBasket expectedShoppingBasket = new ShoppingBasket(userID,basketDate.getDate());

        expectedShoppingBasket.addProductToShoppingBasket(hobbit,5);
        expectedShoppingBasket.addProductToShoppingBasket(breakingBad,2);

        shoppingBasketWebController.postItem(new PostItemRequest(30001, 10002, 5));
        shoppingBasketWebController.postItem(new PostItemRequest(30001, 20110, 2));

        ResponseEntity<ShoppingBasketMemento> responseShoppingBasketMemento = shoppingBasketWebController.getBasket(30001);

        assertEquals(HttpStatus.OK, responseShoppingBasketMemento.getStatusCode());
        assertEquals(expectedShoppingBasket, ShoppingBasket.createFromMemento(responseShoppingBasketMemento.getBody()));
    }
}
