package ShoppingCart.infraestructure;

import ShoppingCart.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

        jdbcTemplate.update("INSERT INTO SHOPPINGBASKET (userId,creationDate) VALUES (?,?)",userID,date);

        BasketItemListMemento basketItemListMemento =  shoppingBasketMemento.basketItemList;
    }

    @Override
    public ShoppingBasket getBasketByUserId(UserID userId) {
        return null;
    }
    }
