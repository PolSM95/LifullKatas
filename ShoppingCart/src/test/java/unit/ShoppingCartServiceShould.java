package unit;

import domain.*;
import infraestructure.ProductRespository;
import infraestructure.ShoppingCartRepository;
import service.ShoppingCartService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;



public class ShoppingCartServiceShould {

    @Test
    public void  test(){
        ShoppingCartRepository shoppingCartRepository = mock(ShoppingCartRepository.class);
        ProductRespository productRespository = mock(ProductRespository.class);
        UserRepository userRepository = mock(UserRepository.class);
        ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartRepository, productRespository);

        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);

        Product hobbit = new Product(productID1, "The Hobbit", 5.00);

        when(productRespository.getProductById(any(ProductID.class))).thenReturn(hobbit);

        shoppingCartService.addItem(userID, productID1, 2);

        BasketItem basketItemHobbit = new BasketItem(hobbit,2);
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.addBasketItem(basketItemHobbit);

        verify(shoppingCartRepository).saveBasket(shoppingBasket);
    }



}
