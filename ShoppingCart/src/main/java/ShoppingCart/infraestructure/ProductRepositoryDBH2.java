package ShoppingCart.infraestructure;

import ShoppingCart.domain.Product;
import ShoppingCart.domain.ProductID;
import ShoppingCart.domain.ProductRespository;

import java.sql.*;

public class ProductRepositoryDBH2 implements ProductRespository {

    @Override
    public Product getProductById(ProductID productID) {
        try{

            Connection connection = DriverManager.getConnection("jdbc:h2:~/data", "sa", "");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE idProduct = ?");
            statement.setString(1, productID.toString());

            ResultSet resultSet = statement.executeQuery();

            Product product = new Product(new ProductID(resultSet.getInt("idProduct")),
                    resultSet.getString("product_name"),
                    resultSet.getDouble("product_value"));

            connection.close();
            return product;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
