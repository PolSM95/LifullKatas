package service;

import domain.*;
import infraestructure.ProductRespository;
import infraestructure.ShoppingBasketRepository;


public class ShoppingBasketService {

    private ShoppingBasketRepository shoppingBasketRepository;
    private ProductRespository productRespository;
    private BasketDate basketDate;


    public ShoppingBasketService(ShoppingBasketRepository shoppingBasketRepository, ProductRespository productRespository, BasketDate basketDate) {

        this.shoppingBasketRepository = shoppingBasketRepository;
        this.productRespository = productRespository;
        this.basketDate = basketDate;
    }

    public void addItem(UserID userID, ProductID productID, int quantity) {

        ShoppingBasket  shoppingBasket = shoppingBasketRepository.getBasketByUserId(userID);

        if(shoppingBasket == null){
            shoppingBasket = new ShoppingBasket(userID, basketDate.getDate());
        }

        Product product = productRespository.getProductById(productID);


        shoppingBasket.addProductToShoppingBasket(product, quantity );



        shoppingBasketRepository.saveBasket(shoppingBasket);

    }

    public ShoppingBasket basketFor(UserID userID) {
      throw new UnsupportedOperationException();
    }
}
