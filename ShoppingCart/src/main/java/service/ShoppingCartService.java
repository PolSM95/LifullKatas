package service;

import domain.*;
import infraestructure.ProductRespository;
import infraestructure.ShoppingCartRepository;

public class ShoppingCartService {
    private ShoppingCartRepository shoppingCartRepository;
    private ProductRespository productRespository;


    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductRespository productRespository) {

        this.shoppingCartRepository = shoppingCartRepository;
        this.productRespository = productRespository;

    }

    public void addItem(UserID userID, ProductID productID, int quantity) {
        Product product = productRespository.getProductById(productID);
        //User user = userRepository.getUserById(userID);
        BasketItem basketItem = new BasketItem(product, quantity);

    }
}
