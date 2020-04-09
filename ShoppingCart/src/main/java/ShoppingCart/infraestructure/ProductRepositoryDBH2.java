package ShoppingCart.infraestructure;

import ShoppingCart.domain.Product;
import ShoppingCart.domain.ProductID;
import ShoppingCart.domain.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class ProductRepositoryDBH2 implements ProductRespository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Product getProductById(ProductID productID) {
        try{

            Product product = jdbcTemplate.queryForObject("SELECT * FROM PRODUCT WHERE idProduct = ?",
                    new Object[]{productID.toString()}, (resultSet, i) ->
                     new Product(
                            new ProductID(resultSet.getInt("idProduct")),
                            resultSet.getString("product_name"),
                             resultSet.getDouble("product_price")
                     ));
            return product;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
