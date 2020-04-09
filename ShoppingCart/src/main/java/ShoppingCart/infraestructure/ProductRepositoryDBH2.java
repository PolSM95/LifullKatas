package ShoppingCart.infraestructure;

import ShoppingCart.domain.Product;
import ShoppingCart.domain.ProductID;
import ShoppingCart.domain.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

public class ProductRepositoryDBH2 implements ProductRespository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Product getProductById(ProductID productID) {
        try {

            Product product = jdbcTemplate.queryForObject("SELECT * FROM PRODUCT WHERE idProduct = ?",
                    new Object[]{productID.toString()},
                    (resultSet, rowNumber) -> new Product(new ProductID(
                            resultSet.getInt("idProduct")),
                            resultSet.getString("product_name"),
                            resultSet.getDouble("product_value")));
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
