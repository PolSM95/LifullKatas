package acceptance;

import domain.*;
import infraestructure.ProductRespository;
import infraestructure.ShoppingCartController;
import infraestructure.ShoppingCartRepository;
import service.ShoppingCartService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class ShoppingCartAcceptanceTest {

    @Test
    public void AcceptanceTest(){
        ShoppingCartRepository shoppingCartRepository = mock(ShoppingCartRepository.class);
        ProductRespository productRespository = mock(ProductRespository.class);
        UserRepository userRepository = mock(UserRepository.class);
        ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartRepository, productRespository);
        ShoppingCartController shoppingCartController = new ShoppingCartController(shoppingCartService);

        String input = "30001\n2,10002\n5,20110";

        shoppingCartController.post(input);

        Product hobbit = new Product(new ProductID(10002), "The Hobbit", 5.00);
        Product breakingBad = new Product(new ProductID(20110), "Breaking Bad", 7.00);

        BasketItem basketItemHobbit = new BasketItem(hobbit,2);
        BasketItem basketItemBreakingBad = new BasketItem(breakingBad,5);

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.addBasketItem(basketItemHobbit);
        shoppingBasket.addBasketItem(basketItemBreakingBad);

        verify(shoppingCartRepository).saveBasket(shoppingBasket);
    }


}
