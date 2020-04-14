package unit;

import ShoppingCart.domain.Product.Product;
import ShoppingCart.domain.Product.ProductID;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasket;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasketMemento;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.infraestructure.*;
import ShoppingCart.service.BasketDate;
import ShoppingCart.service.ShoppingBasketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    public void return_an_existing_basket(){
        MockitoAnnotations.initMocks(this);
        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);
        ProductID productID2 = new ProductID(20110);
        Product hobbit = new Product(productID1, "The Hobbit", 5.00);
        Product breakingBad = new Product(productID2, "Breaking Bad", 7.00);

        when(basketDate.getDate()).thenReturn("14/04/2020");

        ShoppingBasket expectedShoppingBasket = new ShoppingBasket(userID,basketDate.getDate());

        expectedShoppingBasket.addProductToShoppingBasket(hobbit,5);
        expectedShoppingBasket.addProductToShoppingBasket(breakingBad,2);

        when(shoppingBasketRepositoryDBH2.getBasketByUserId(userID)).thenReturn(expectedShoppingBasket);

        ResponseEntity<ShoppingBasketMemento> responseEntity = shoppingBasketWebController.getBasket(30001);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedShoppingBasket, ShoppingBasket.createFromMemento(responseEntity.getBody()));

    }

    @Test
    public void post_item_to_shoppingBasketRepository(){
        MockitoAnnotations.initMocks(this);
        PostItemRequest postItemRequest = new PostItemRequest(30001, 10002, 2);
        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);
        Product hobbit = new Product(productID1, "The Hobbit", 5.00);


        when(productRepositoryDBH2.getProductById(productID1)).thenReturn(hobbit);
        when(basketDate.getDate()).thenReturn("14/04/2020");
        when(shoppingBasketRepositoryDBH2.getBasketByUserId(userID)).thenReturn(null);

        ShoppingBasket shoppingBasketExpected = new ShoppingBasket(userID,basketDate.getDate());
        shoppingBasketExpected.addProductToShoppingBasket(hobbit,2);

        ResponseEntity<Object> responseEntity = shoppingBasketWebController.postItem(postItemRequest);

        verify(shoppingBasketRepositoryDBH2).saveBasket(shoppingBasketExpected);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

    }

    @Test
    public void raise_http_message_BAD_REQUEST_when_quantity_is_negative(){
        MockitoAnnotations.initMocks(this);
        PostItemRequest postItemRequest = new PostItemRequest(30001, 10002, -2);
        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);
        Product hobbit = new Product(productID1, "The Hobbit", 5.00);


        when(productRepositoryDBH2.getProductById(productID1)).thenReturn(hobbit);
        when(basketDate.getDate()).thenReturn("14/04/2020");
        when(shoppingBasketRepositoryDBH2.getBasketByUserId(userID)).thenReturn(null);



        ResponseEntity<Object> responseEntity = shoppingBasketWebController.postItem(postItemRequest);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Quantity cannot be negative", responseEntity.getBody());

    }

    @Test
    public void raise_http_message_bad_request_when_product_does_not_exist(){
        MockitoAnnotations.initMocks(this);
        PostItemRequest postItemRequest = new PostItemRequest(30001, 324535, -2);
        ProductID productID = new ProductID(324535);
        UserID userID = new UserID(30001);
        when(productRepositoryDBH2.getProductById(productID)).thenReturn(null);
        when(basketDate.getDate()).thenReturn("14/04/2020");
        when(shoppingBasketRepositoryDBH2.getBasketByUserId(userID)).thenReturn(null);

        ResponseEntity<Object> responseEntity = shoppingBasketWebController.postItem(postItemRequest);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Product not found", responseEntity.getBody());
    }

}
