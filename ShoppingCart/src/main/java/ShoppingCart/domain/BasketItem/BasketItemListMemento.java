package ShoppingCart.domain.BasketItem;

import java.util.ArrayList;
import java.util.List;

public class BasketItemListMemento {

    public List<BasketItemMemento> basketItemMementoList;

    public BasketItemListMemento() {
        this.basketItemMementoList = new ArrayList<>();
    }


}
