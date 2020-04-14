package acceptance;

import ShoppingCart.domain.Product.Product;
import ShoppingCart.domain.Product.ProductID;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasket;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.exception.ProductDoesNotExistException;
import ShoppingCart.exception.ProductNegativeQuantityException;
import ShoppingCart.domain.ProductRespository;
import ShoppingCart.infraestructure.ShoppingBasketController;
import ShoppingCart.domain.ShoppingBasketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InOrder;
import ShoppingCart.service.BasketDate;
import ShoppingCart.service.ShoppingBasketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class ShoppingBasketAcceptanceTest {

    @Autowired
    ShoppingBasketRepository shoppingBasketRepository;
    @Autowired
    ProductRespository productRespository;

    BasketDate basketDate;
    ShoppingBasketService shoppingBasketService;
    ShoppingBasketController shoppingBasketController;


    @BeforeEach
    public void Init(){
        basketDate = mock(BasketDate.class);
        shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRespository, basketDate);
        shoppingBasketController = new ShoppingBasketController(shoppingBasketService);
    }

    void acceptanceTest(){

    }



}
