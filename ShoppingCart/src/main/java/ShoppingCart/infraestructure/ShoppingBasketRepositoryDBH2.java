package ShoppingCart.infraestructure;

import ShoppingCart.domain.*;
import ShoppingCart.domain.BasketItem.BasketItemListMemento;
import ShoppingCart.domain.BasketItem.BasketItemMemento;
import ShoppingCart.domain.Product.ProductIDMemento;
import ShoppingCart.domain.Product.ProductMemento;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasket;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasketMemento;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.domain.ShoppingBasket.UserIDMemento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component


public class ShoppingBasketRepositoryDBH2 implements ShoppingBasketRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveBasket(ShoppingBasket shoppingBasket) {

        ShoppingBasketMemento shoppingBasketMemento = shoppingBasket.createShoppingBasketMemento();

        UserIDMemento userIDMemento = shoppingBasketMemento.userID;
        int userID = userIDMemento.userId;

        String date = shoppingBasketMemento.dateString;

        jdbcTemplate.update("DELETE FROM SHOPPINGBASKET WHERE userID = ?", userID);

        jdbcTemplate.update("INSERT INTO SHOPPINGBASKET (userId,creationDate) VALUES (?,?)", userID, date);

        BasketItemListMemento basketItemListMemento = shoppingBasketMemento.basketItemList;

        List<BasketItemMemento> basketItemMementoList = basketItemListMemento.basketItemMementoList;

        int IDShoppingBasket = jdbcTemplate.queryForObject("SELECT * FROM SHOPPINGBASKET WHERE userId = ?",
                new Object[]{userID}, ((resultSet, i) -> resultSet.getInt("idShoppingBasket")));

        for (BasketItemMemento basketItemMemento : basketItemMementoList) {
            int productID = basketItemMemento.productMemento.productIDMemento.productIDMemento;
            int quantity = basketItemMemento.quantity;
            jdbcTemplate.update("INSERT INTO BASKETITEM (idproduct,idShoppingBasket,quantity) VALUES (?,?,?)",
                    productID, IDShoppingBasket, quantity);
        }
    }

    @Override
    public ShoppingBasket getBasketByUserId(UserID userId) {

        UserIDMemento userIDMemento = userId.createUserIdMemento();
        int userID = userIDMemento.userId;
        ShoppingBasketMemento shoppingBasketMemento;

        try {
             shoppingBasketMemento = jdbcTemplate.queryForObject("SELECT * FROM SHOPPINGBASKET WHERE userId = ? ",
                    new Object[]{userID}, ((resultSet, rowNumber) -> {

                        ShoppingBasketMemento shoppingBasketMementoQuery = new ShoppingBasketMemento();
                        shoppingBasketMementoQuery.dateString = resultSet.getString("creationDate");
                        UserIDMemento userIDMementoQuery = new UserIDMemento();
                        userIDMementoQuery.userId = resultSet.getInt("userId");
                        shoppingBasketMementoQuery.userID = userIDMementoQuery;
                        shoppingBasketMementoQuery.idShoppingBasket = resultSet.getInt("idShoppingBasket");

                        return shoppingBasketMementoQuery;


                    }));

        }catch (Exception e){

            return null;
        }

        BasketItemListMemento basketItemListMemento = new BasketItemListMemento();
        jdbcTemplate.query("SELECT * FROM BASKETITEM b, PRODUCT p WHERE idShoppingBasket = ? AND b.idproduct = p.idproduct",
                new Object[]{shoppingBasketMemento.idShoppingBasket}, (resultSet, rowNumber) -> {

                    BasketItemMemento basketItemMemento = new BasketItemMemento();
                    ProductMemento productMemento = new ProductMemento();
                    ProductIDMemento productIDMemento = new ProductIDMemento();

                    productIDMemento.productIDMemento = resultSet.getInt("idProduct");

                    productMemento.productIDMemento = productIDMemento;
                    productMemento.productName = resultSet.getString("product_name");
                    productMemento.productPrice = resultSet.getDouble("product_price");

                    basketItemMemento.productMemento = productMemento;
                    basketItemMemento.quantity = resultSet.getInt("quantity");

                    basketItemListMemento.basketItemMementoList.add(basketItemMemento);

                    return null;
                });
        shoppingBasketMemento.basketItemList = basketItemListMemento;

        ShoppingBasket shoppingBasket = ShoppingBasket.createFromMemento(shoppingBasketMemento);

        return shoppingBasket;
    }
}
