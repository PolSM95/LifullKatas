package infraestructure;

import domain.Product;
import domain.ProductID;

public interface ProductRespository {

     Product getProductById(ProductID productID);
}
