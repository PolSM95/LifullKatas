package acceptance;

import domain.*;
import exception.ProductDoesNotExistException;
import infraestructure.ProductRespository;
import infraestructure.ShoppingBasketController;
import infraestructure.ShoppingBasketRepository;
import org.mockito.InOrder;
import service.BasketDate;
import service.ShoppingBasketService;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class ShoppingBasketAcceptanceTest {

    @Test
    public void AcceptanceTest(){
        ShoppingBasketRepository shoppingBasketRepository = mock(ShoppingBasketRepository.class);
        ProductRespository productRespository = mock(ProductRespository.class);
        BasketDate basketDate = mock(BasketDate.class);

        when(basketDate.getDate()).thenReturn("07/04/2020");

        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRespository, basketDate);
        ShoppingBasketController shoppingBasketController = new ShoppingBasketController(shoppingBasketService);

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

    //Añadir un producto que no existe, productID no existe
    //Añadir el mismo producto dos veces
    //Añadir un BasketItem con cantidad negativa
    //Añadir un producto vacío

    @Test
    public void raise_error_when_sending_a_product_Id_that_does_not_exist(){

        ShoppingBasketRepository shoppingBasketRepository = mock(ShoppingBasketRepository.class);
        ProductRespository productRespository = mock(ProductRespository.class);
        BasketDate basketDate = mock(BasketDate.class);

        when(basketDate.getDate()).thenReturn("07/04/2020");

        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRespository, basketDate);
        ShoppingBasketController shoppingBasketController = new ShoppingBasketController(shoppingBasketService);

        String input = "30001\n3,20040";

        UserID userID = new UserID(30001);

        when(productRespository.getProductById(any(ProductID.class))).thenReturn(null);

        ShoppingBasket shoppingBasket = new ShoppingBasket(userID, basketDate.getDate());

        when(shoppingBasketRepository.getBasketByUserId(any(UserID.class))).thenReturn(shoppingBasket);

        assertThrows(ProductDoesNotExistException.class, () -> shoppingBasketController.post(input));




    }


}
