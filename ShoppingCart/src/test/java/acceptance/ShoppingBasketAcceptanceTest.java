package acceptance;

import domain.*;
import infraestructure.ProductRespository;
import infraestructure.ShoppingBasketController;
import infraestructure.ShoppingBasketRepository;
import service.ShoppingBasketService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class ShoppingBasketAcceptanceTest {

    @Test
    public void AcceptanceTest(){
        ShoppingBasketRepository shoppingBasketRepository = mock(ShoppingBasketRepository.class);
        ProductRespository productRespository = mock(ProductRespository.class);

        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRespository);
        ShoppingBasketController shoppingBasketController = new ShoppingBasketController(shoppingBasketService);

        String input = "30001\n2,10002\n5,20110";

        shoppingBasketController.post(input);

        UserID userID = new UserID(30001);

        Product hobbit = new Product(new ProductID(10002), "The Hobbit", 5.00);
        Product breakingBad = new Product(new ProductID(20110), "Breaking Bad", 7.00);

        BasketItem basketItemHobbit = new BasketItem(hobbit,2);
        BasketItem basketItemBreakingBad = new BasketItem(breakingBad,5);

        ShoppingBasket shoppingBasket = new ShoppingBasket(userID, "07/04/2020");
        shoppingBasket.addBasketItem(basketItemHobbit);
        shoppingBasket.addBasketItem(basketItemBreakingBad);

        verify(shoppingBasketRepository).saveBasket(shoppingBasket);
    }


}
