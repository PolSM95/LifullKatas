package unit;

import ShoppingCart.domain.Product.Product;
import ShoppingCart.domain.Product.ProductID;
import ShoppingCart.domain.ProductRespository;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasket;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.domain.ShoppingBasketRepository;
import ShoppingCart.exception.ProductDoesNotExistException;
import ShoppingCart.exception.ProductNegativeQuantityException;
import ShoppingCart.infraestructure.ShoppingBasketController;
import ShoppingCart.service.BasketDate;
import ShoppingCart.service.ShoppingBasketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class ShoppingBasketControllerShould {

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
    public void check_if_basket_is_added_to_the_repository(){
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
    void check_add_item_to_shopping_cart_services_after_parsing_the_input(){
        ShoppingBasketService shoppingBasketServiceMock = mock(ShoppingBasketService.class);
        ShoppingBasketController shoppingBasketController = new ShoppingBasketController(shoppingBasketServiceMock);

        String input = "30001\n2,10002\n5,20110";
        shoppingBasketController.post(input);

        UserID userID = new UserID(30001);
        ProductID productID1 = new ProductID(10002);
        ProductID productID2 = new ProductID(20110);


        verify(shoppingBasketServiceMock).addItem(userID, productID1, 2);
        verify(shoppingBasketServiceMock).addItem(userID, productID2, 5);
    }

}
