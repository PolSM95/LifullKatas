package ShoppingCart.infraestructure;

import ShoppingCart.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
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

        jdbcTemplate.update("DELETE FROM SHOPPINGBASKET WHERE userID = ?",userID);

        jdbcTemplate.update("INSERT INTO SHOPPINGBASKET (userId,creationDate) VALUES (?,?)",userID,date);

        BasketItemListMemento basketItemListMemento =  shoppingBasketMemento.basketItemList;

        List<BasketItemMemento> basketItemMementoList = basketItemListMemento.basketItemMementoList;

        int IDShoppingBasket = jdbcTemplate.queryForObject("SELECT * FROM SHOPPINGBASKET WHERE userId = ?",
                new Object[]{userID},((resultSet, i) -> resultSet.getInt("idShoppingBasket")));

        for (BasketItemMemento basketItemMemento : basketItemMementoList) {
            int productID = basketItemMemento.productMemento.productIDMemento.productIDMemento;
            int quantity = basketItemMemento.quantity;
            jdbcTemplate.update("INSERT INTO BASKETITEM (idproduct,idShoppingBasket,quantity) VALUES (?,?,?)",
                    productID,IDShoppingBasket,quantity);
        }
    }

    @Override
    public ShoppingBasket getBasketByUserId(UserID userId) {

        UserIDMemento userIDMemento = userId.createUserIdMemento();
        int userID = userIDMemento.userId;

        ShoppingBasketMemento shoppingBasketMemento = jdbcTemplate.queryForObject("SELECT * FROM SHOPPINGBASKET WHERE userId = ? ",
                new Object[userID],((resultSet, i) -> {
                    ShoppingBasketMemento shoppingBasketMementoQuery = new ShoppingBasketMemento();
                    shoppingBasketMementoQuery.dateString = resultSet.getString("creationDate");
                    UserIDMemento userIDMementoQuery = new UserIDMemento();
                    userIDMementoQuery.userId = resultSet.getInt("userId");
                    shoppingBasketMementoQuery.userID = userIDMementoQuery;
                    shoppingBasketMementoQuery.idShoppingBasket = resultSet.getInt("idShoppingBasket");

                    return shoppingBasketMementoQuery;

                } ));

        return null;
    }
    }
