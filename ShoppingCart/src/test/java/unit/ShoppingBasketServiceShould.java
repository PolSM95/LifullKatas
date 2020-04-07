package unit;

import domain.*;
import exception.ProductDoesNotExistException;
import infraestructure.ProductRespository;
import infraestructure.ShoppingBasketRepository;
import service.BasketDate;
import service.ShoppingBasketService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;



public class ShoppingBasketServiceShould {

    @Test
    public void  adding_items_to_a_user_basket_and_saving_the_basket(){
        ShoppingBasketRepository shoppingBasketRepository = mock(ShoppingBasketRepository.class);
        ProductRespository productRespository = mock(ProductRespository.class);

        BasketDate basketDate = mock(BasketDate.class);

        when(basketDate.getDate()).thenReturn("07/04/2020");

        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRespository, basketDate);

        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);

        Product hobbit = new Product(productID1, "The Hobbit", 5.00);

        when(productRespository.getProductById(productID1)).thenReturn(hobbit);

        shoppingBasketService.addItem(userID, productID1, 2);

        ShoppingBasket shoppingBasket = new ShoppingBasket(userID,basketDate.getDate());
        shoppingBasket.addProductToShoppingBasket(hobbit, 2 );

        verify(shoppingBasketRepository).saveBasket(shoppingBasket);
    }


    @Test
    public void raise_error_when_trying_to_add_an_item_that_does_not_exist(){
        ShoppingBasketRepository shoppingBasketRepository = mock(ShoppingBasketRepository.class);
        ProductRespository productRespository = mock(ProductRespository.class);
        BasketDate basketDate = mock(BasketDate.class);

        when(basketDate.getDate()).thenReturn("07/04/2020");

        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRespository, basketDate);
        UserID userID = new UserID(30001);
        ProductID productID = new ProductID(20040);

        when(productRespository.getProductById(productID)).thenReturn(null);

        assertThrows(ProductDoesNotExistException.class, () -> shoppingBasketService.addItem(userID, productID, 2));

    }

}
