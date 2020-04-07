package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasketItemList {

    private List<BasketItem> basketItemList;


    public BasketItemList() {
        this.basketItemList = new ArrayList<>();
    }

    public void addBasketItemToAList(BasketItem basketItem) {
        boolean isSameProduct = false;
        for (BasketItem currentBasketItem : basketItemList) {

           if(currentBasketItem.isSameProduct(basketItem)){
               isSameProduct = true;
               currentBasketItem.addQuantity(basketItem);
           }
        }

        if(!isSameProduct) {
            basketItemList.add(basketItem);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketItemList that = (BasketItemList) o;
        return Objects.equals(basketItemList, that.basketItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basketItemList);
    }

    @Override
    public String toString() {
        return "BasketItemList{" +
                "basketItemList=" + basketItemList +
                '}';
    }
}
