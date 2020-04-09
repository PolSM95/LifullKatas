package acceptance;

import ShoppingCart.domain.*;
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


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class ShoppingBasketAcceptanceTest {
    ShoppingBasketRepository shoppingBasketRepository;
    ProductRespository productRespository;
    BasketDate basketDate;
    ShoppingBasketService shoppingBasketService;
    ShoppingBasketController shoppingBasketController;


    @BeforeEach
    public void Init(){
        shoppingBasketRepository = mock(ShoppingBasketRepository.class);
        productRespository = mock(ProductRespository.class);
        basketDate = mock(BasketDate.class);
        shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRespository, basketDate);
        shoppingBasketController = new ShoppingBasketController(shoppingBasketService);

    }

    @Test
    public void AcceptanceTest(){
        when(basketDate.getDate()).thenReturn("07/04/2020");

        String input = "30001\n2,10002\n5,20110";

        UserID userID = new UserID(30001);

        Product hobbit = new Product(new ProductID(10002), "The Hobbit", 5.00);
        Product breakingBad = new Product(new ProductID(20110), "Breaking Bad", 7.00);

        when(productRespository.getProductById(any(ProductID.class))).thenReturn(hobbit,breakingBad);

        ShoppingBasket shoppingBasket = new ShoppingBasket(userID,basketDate.getDate());
        shoppingBasket.addProductToShoppingBasket(hobbit, 2 );

        when(shoppingBasketRepository.getBasketByUserId(any(UserID.class))).thenReturn(shoppingBasket);
        shoppingBasket.addProductToShoppingBasket(breakingBad, 5 );

        shoppingBasketController.post(input);

        InOrder inOrder = inOrder(shoppingBasketRepository);
        inOrder.verify(shoppingBasketRepository).saveBasket(any());
        inOrder.verify(shoppingBasketRepository).saveBasket(shoppingBasket);
    }



    @Test
    public void raise_error_when_sending_a_product_Id_that_does_not_exist(){

        when(basketDate.getDate()).thenReturn("07/04/2020");

        String input = "30001\n3,20040";

        UserID userID = new UserID(30001);

        when(productRespository.getProductById(any(ProductID.class))).thenReturn(null);

        ShoppingBasket shoppingBasket = new ShoppingBasket(userID, basketDate.getDate());

        when(shoppingBasketRepository.getBasketByUserId(any(UserID.class))).thenReturn(shoppingBasket);

        assertThrows(ProductDoesNotExistException.class, () -> shoppingBasketController.post(input));
    }

    @Test
    public void raise_error_when_sending_a_product_with_negative_quantity(){
        when(basketDate.getDate()).thenReturn("07/04/2020");
        String input = "30001\n-1,10002";

        Product hobbit = new Product(new ProductID(10002), "The Hobbit", 5.00);

        when(productRespository.getProductById(any(ProductID.class))).thenReturn(hobbit);

        when(shoppingBasketRepository.getBasketByUserId(any(UserID.class))).thenReturn(null);

        assertThrows(ProductNegativeQuantityException.class, () -> shoppingBasketController.post(input));

    }

    @Test
    public void test(){
        //Tenemos un input de un numero de User ID que Si existe esa Basket
        String input = "30001";
        //LLamamos a basket for con este USer ID para que nos de LA BASKETShopping
        //El controlador debera traducir esta BasketShopping

        //coger el carrito del usuario para que nos imprima todo esto :
        /*Creation date : 01/03/2020
        2 x The Hobbit // 2 x 5.00 = €10.00
        5 x Breaking Bad // 5 x 7.00 = €35.00
        Total: €45.00*/


        //verificar

    }

    //Tenemos un input de un numero de User ID que NO existe
}