package unit;

import domain.*;
import exception.ProductDoesNotExistException;
import exception.ProductNegativeQuantityException;
import infraestructure.ProductRespository;
import infraestructure.ShoppingBasketRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InOrder;
import service.BasketDate;
import service.ShoppingBasketService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ShoppingBasketServiceShould {
    ShoppingBasketRepository shoppingBasketRepository;
    ProductRespository productRespository;
    BasketDate basketDate;
    ShoppingBasketService shoppingBasketService;
    InOrder inOrder;

    @BeforeEach
    public void init() {
        shoppingBasketRepository = mock(ShoppingBasketRepository.class);
        productRespository = mock(ProductRespository.class);
        basketDate = mock(BasketDate.class);
        shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository,
                productRespository,
                basketDate);
        inOrder = inOrder(shoppingBasketRepository);
    }

    @Test
    public void raise_error_when_trying_to_add_an_item_that_does_not_exist() {

        when(basketDate.getDate()).thenReturn("07/04/2020");

        UserID userID = new UserID(30001);
        ProductID productID = new ProductID(20040);

        when(productRespository.getProductById(productID)).thenReturn(null);

        assertThrows(ProductDoesNotExistException.class, () -> shoppingBasketService.addItem(userID, productID, 2));
    }

    @Test
    public void adding_items_to_a_user_basket_and_saving_the_basket() {

        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);
        Product hobbit = new Product(productID1, "The Hobbit", 5.00);

        when(basketDate.getDate()).thenReturn("07/04/2020");
        when(productRespository.getProductById(productID1)).thenReturn(hobbit);

        shoppingBasketService.addItem(userID, productID1, 2);

        ShoppingBasket shoppingBasket = new ShoppingBasket(userID, basketDate.getDate());
        shoppingBasket.addProductToShoppingBasket(hobbit, 2);

        verify(shoppingBasketRepository).saveBasket(shoppingBasket);
    }

    @Test
    public void adding_quantity_when_introducing_the_same_product_into_the_basket_multiple_times() {
        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);
        Product hobbit = new Product(productID1, "The Hobbit", 5.00);

        when(basketDate.getDate()).thenReturn("07/04/2020");
        when(productRespository.getProductById(productID1)).thenReturn(hobbit, hobbit);

        ShoppingBasket shoppingBasketAuxiliar = new ShoppingBasket(userID, basketDate.getDate());
        shoppingBasketAuxiliar.addProductToShoppingBasket(hobbit, 2);

        when(shoppingBasketRepository.getBasketByUserId(any())).thenReturn(null, shoppingBasketAuxiliar);

        shoppingBasketService.addItem(userID, productID1, 2);
        shoppingBasketService.addItem(userID, productID1, 3);

        ShoppingBasket shoppingBasket = new ShoppingBasket(userID, basketDate.getDate());
        shoppingBasket.addProductToShoppingBasket(hobbit, 5);

        inOrder.verify(shoppingBasketRepository).saveBasket(any());
        inOrder.verify(shoppingBasketRepository).saveBasket(shoppingBasket);
    }

    @Test
    public void raise_error_when_trying_to_add_item_with_negative_quantity() {
        UserID userID = new UserID(30001);
        ProductID productID = new ProductID(10002);
        Product hobbit = new Product(productID, "The Hobbit", 5.00);

        when(basketDate.getDate()).thenReturn("07/04/2020");
        when(productRespository.getProductById(productID)).thenReturn(hobbit);

        assertThrows(ProductNegativeQuantityException.class,
                () -> shoppingBasketService.addItem(userID, productID, -1));
    }
}
