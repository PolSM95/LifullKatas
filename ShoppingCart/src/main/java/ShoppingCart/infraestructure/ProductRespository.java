package ShoppingCart.infraestructure;

import ShoppingCart.domain.Product;
import ShoppingCart.domain.ProductID;

public interface ProductRespository {

     Product getProductById(ProductID productID);
}
