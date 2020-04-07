package service;

import domain.*;
import infraestructure.ProductRespository;
import infraestructure.ShoppingBasketRepository;

public class ShoppingBasketService {

    private ShoppingBasketRepository shoppingBasketRepository;
    private ProductRespository productRespository;


    public ShoppingBasketService(ShoppingBasketRepository shoppingBasketRepository, ProductRespository productRespository) {

        this.shoppingBasketRepository = shoppingBasketRepository;
        this.productRespository = productRespository;

    }

    public void addItem(UserID userID, ProductID productID, int quantity) {

        ShoppingBasket  shoppingBasket = shoppingBasketRepository.getBasketByUserId(userID);

        if(shoppingBasket == null){
            shoppingBasket = new ShoppingBasket(userID,"07/04/2020");
        }

        Product product = productRespository.getProductById(productID);
        BasketItem basketItem = new BasketItem(product, quantity);

        shoppingBasket.addBasketItem(basketItem);

        shoppingBasketRepository.saveBasket(shoppingBasket);

    }

    public ShoppingBasket basketFor(UserID userID) {
      throw new UnsupportedOperationException();
    }
}
