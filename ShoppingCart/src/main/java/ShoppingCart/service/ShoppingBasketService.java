package ShoppingCart.service;

import ShoppingCart.domain.Product.Product;
import ShoppingCart.domain.Product.ProductID;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasket;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.exception.BasketNotExistsException;
import ShoppingCart.domain.ProductRespository;
import ShoppingCart.domain.ShoppingBasketRepository;


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

        shoppingBasket.addProductToShoppingBasket(product, quantity);
        shoppingBasketRepository.saveBasket(shoppingBasket);
    }

    public ShoppingBasket basketFor(UserID userID) {

        ShoppingBasket shoppingBasket = shoppingBasketRepository.getBasketByUserId(userID);
        if(shoppingBasket == null){
            throw new BasketNotExistsException("There is no basket for that user");
        }
       return shoppingBasket;

    }
}
