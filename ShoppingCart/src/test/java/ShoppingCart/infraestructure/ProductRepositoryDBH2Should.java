package ShoppingCart.infraestructure;

import ShoppingCart.ShoppingBasketApp;
import ShoppingCart.domain.Product;
import ShoppingCart.domain.ProductID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductRepositoryDBH2Should {
    @Autowired
    private ProductRepositoryDBH2 productRepository;

    @Test
    public void retrieve_product_from_database_with_productId(){
        //ProductRepositoryDBH2 productRepository = new ProductRepositoryDBH2();
        ProductID productID = new ProductID(10001);
        Product productExpected = new Product(productID, "Lord of The Rings", 10.00);

        assertEquals(productExpected, productRepository.getProductById(productID));
    }

    @Test
    public void raise_error_when_try_to_retrieve_a_product_with_invalid_productId(){

        ProductID productID = new ProductID(10005);
        assertEquals(null, productRepository.getProductById(productID));
    }

}
