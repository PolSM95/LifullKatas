package unit;

import ShoppingCart.domain.Product;
import ShoppingCart.domain.ProductID;
import ShoppingCart.infraestructure.ProductRepositoryDBH2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryDBH2Should {
    @Test
    public void test(){
        ProductRepositoryDBH2 productRepository = new ProductRepositoryDBH2();
        ProductID productID = new ProductID(10001);
        Product productExpected = new Product(productID, "Lord of The Rings", 10.00);

        assertEquals(productExpected, productRepository.getProductById(productID));
    }

}
