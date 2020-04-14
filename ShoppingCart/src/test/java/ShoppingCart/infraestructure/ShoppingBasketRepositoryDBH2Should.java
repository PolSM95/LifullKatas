package ShoppingCart.infraestructure;

import ShoppingCart.domain.Product.Product;
import ShoppingCart.domain.Product.ProductID;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasket;
import ShoppingCart.domain.ShoppingBasket.UserID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShoppingBasketRepositoryDBH2Should {

    @Autowired
    private ShoppingBasketRepositoryDBH2 shoppingBasketRepository;
    @Autowired
    private ProductRepositoryDBH2 productRepositoryDBH2;

    @Test
    public void retrieve_basket_from_database_when_introducing_userID(){
        UserID userId = new UserID(30002);
        ShoppingBasket shoppingBasket = new ShoppingBasket(userId,"09/04/2020");
        Product theHobbit = productRepositoryDBH2.getProductById(new ProductID(10002));
        Product theLordofTheRings = productRepositoryDBH2.getProductById(new ProductID(10001));

        shoppingBasket.addProductToShoppingBasket(theHobbit, 2);
        shoppingBasket.addProductToShoppingBasket(theLordofTheRings, 3);

        shoppingBasketRepository.saveBasket(shoppingBasket);

        assertEquals(shoppingBasket, shoppingBasketRepository.getBasketByUserId(userId));
    }






}
