package unit;

import domain.*;
import infraestructure.ProductRespository;
import infraestructure.ShoppingBasketRepository;
import service.ShoppingBasketService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;



public class ShoppingBasketServiceShould {

    @Test
    public void  adding_items_to_a_user_basket_and_saving_the_basket(){
        ShoppingBasketRepository shoppingBasketRepository = mock(ShoppingBasketRepository.class);
        ProductRespository productRespository = mock(ProductRespository.class);

        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRespository);

        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);

        Product hobbit = new Product(productID1, "The Hobbit", 5.00);

        when(productRespository.getProductById(any(ProductID.class))).thenReturn(hobbit);

        shoppingBasketService.addItem(userID, productID1, 2);

        BasketItem basketItemHobbit = new BasketItem(hobbit,2);
        ShoppingBasket shoppingBasket = new ShoppingBasket(userID,"07/04/2020");
        shoppingBasket.addBasketItem(basketItemHobbit);

        verify(shoppingBasketRepository).saveBasket(shoppingBasket);
    }



}
