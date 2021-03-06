package ShoppingCart.domain.ShoppingBasket;

import ShoppingCart.domain.BasketItem.BasketItem;
import ShoppingCart.domain.BasketItem.BasketItemList;
import ShoppingCart.domain.BasketItem.BasketItemMemento;
import ShoppingCart.domain.Product.Product;
import ShoppingCart.exception.ProductDoesNotExistException;
import ShoppingCart.exception.ProductNegativeQuantityException;

import java.util.Objects;

public class ShoppingBasket
{
    private UserID userID;
    private String dateString;
    private BasketItemList basketItemList;


    public ShoppingBasket(UserID userID, String dateString) {

        this.userID = userID;
        this.dateString = dateString;
        this.basketItemList = new BasketItemList();
    }

    public static ShoppingBasket createFromMemento(ShoppingBasketMemento shoppingBasketMemento) {
        int userIDNumber = shoppingBasketMemento.userID.userId;
        UserID userID = new UserID(userIDNumber);
        ShoppingBasket shoppingBasket = new ShoppingBasket(userID, shoppingBasketMemento.dateString);
        for (BasketItemMemento basketItemMemento : shoppingBasketMemento.basketItemList.basketItemMementoList){
            Product currentProduct = Product.createFromMemento(basketItemMemento.productMemento);
            int quantity = basketItemMemento.quantity;
            shoppingBasket.addProductToShoppingBasket(currentProduct, quantity);
        }
        return shoppingBasket;

    }

    public void addProductToShoppingBasket(Product product, int quantity) {

        if (product == null){
            throw new ProductDoesNotExistException("Product does not exist");
        }
        if(quantity<=0){
            throw new ProductNegativeQuantityException("Quantity can not be negative");
        }

        BasketItem basketItem = new BasketItem(product, quantity);

        basketItemList.addBasketItemToAList(basketItem);
    }

    public ShoppingBasketMemento createShoppingBasketMemento(){
        ShoppingBasketMemento shoppingBasketMemento = new ShoppingBasketMemento();
        shoppingBasketMemento.userID = userID.createUserIdMemento();
        shoppingBasketMemento.dateString = dateString;
        shoppingBasketMemento.basketItemList = basketItemList.createBasketItemListMemento();
        return shoppingBasketMemento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasket that = (ShoppingBasket) o;
        return Objects.equals(userID, that.userID) &&
                Objects.equals(dateString, that.dateString) &&
                Objects.equals(basketItemList, that.basketItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, dateString, basketItemList);
    }

    @Override
    public String toString() {
        return "Creation date : " +dateString +"\n"+
                basketItemList.toString()+
                "Total: €"+basketItemList.totalPrice();
    }
}
