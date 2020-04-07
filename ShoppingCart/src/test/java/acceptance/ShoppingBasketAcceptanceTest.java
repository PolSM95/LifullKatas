package acceptance;

import domain.*;
import infraestructure.ProductRespository;
import infraestructure.ShoppingBasketController;
import infraestructure.ShoppingBasketRepository;
import org.mockito.InOrder;
import service.BasketDate;
import service.ShoppingBasketService;
import org.junit.jupiter.api.Test;

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

        BasketItem basketItemHobbit = new BasketItem(hobbit,2);
        BasketItem basketItemBreakingBad = new BasketItem(breakingBad,5);

        ShoppingBasket shoppingBasket = new ShoppingBasket(userID,basketDate.getDate());
        shoppingBasket.addBasketItem(basketItemHobbit);

        when(shoppingBasketRepository.getBasketByUserId(any(UserID.class))).thenReturn(shoppingBasket);
        shoppingBasket.addBasketItem(basketItemBreakingBad);

        shoppingBasketController.post(input);

        InOrder inOrder = inOrder(shoppingBasketRepository);
        inOrder.verify(shoppingBasketRepository).saveBasket(any());
        inOrder.verify(shoppingBasketRepository).saveBasket(shoppingBasket);
    }


}
