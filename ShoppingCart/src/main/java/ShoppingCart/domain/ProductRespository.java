package ShoppingCart.domain;

import ShoppingCart.domain.Product.Product;
import ShoppingCart.domain.Product.ProductID;

public interface ProductRespository {
     Product getProductById(ProductID productID);
}
