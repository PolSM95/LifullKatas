package ShoppingCart.infraestructure;

import ShoppingCart.domain.Product.ProductID;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.service.BasketDate;
import ShoppingCart.service.ShoppingBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ShoppingBasketWebController {
    @Autowired
    ProductRepositoryDBH2 productRepositoryDBH2;
    @Autowired
    ShoppingBasketRepositoryDBH2 shoppingBasketRepositoryDBH2;
    ShoppingBasketService shoppingBasketService;

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable int id) {
        return new ResponseEntity<>(productRepositoryDBH2.getProductById(new ProductID(id)).toString(), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<Object> helloWorld (){
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Object> getBasket(@PathVariable int id) {
        shoppingBasketService = new ShoppingBasketService(shoppingBasketRepositoryDBH2,productRepositoryDBH2,new BasketDate());
        return new ResponseEntity<>(shoppingBasketService.basketFor(new UserID(id)), HttpStatus.OK);
    }


}
