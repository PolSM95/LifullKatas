package ShoppingCart.infraestructure;

import ShoppingCart.domain.Product.ProductID;
import ShoppingCart.domain.ShoppingBasket.ShoppingBasketMemento;
import ShoppingCart.domain.ShoppingBasket.UserID;
import ShoppingCart.exception.BasketNotExistsException;
import ShoppingCart.exception.ProductDoesNotExistException;
import ShoppingCart.exception.ProductNegativeQuantityException;
import ShoppingCart.service.BasketDate;
import ShoppingCart.service.ShoppingBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ShoppingBasketWebController {
    @Autowired
    ProductRepositoryDBH2 productRepositoryDBH2;
    @Autowired
    ShoppingBasketRepositoryDBH2 shoppingBasketRepositoryDBH2;
    @Autowired
    ShoppingBasketService shoppingBasketService;
    @Autowired
    BasketDate basketDate;

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable int id) {
        return new ResponseEntity<>(productRepositoryDBH2.getProductById(new ProductID(id)).toString(), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<Object> helloWorld (){
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<ShoppingBasketMemento> getBasket(@PathVariable int id) {
        shoppingBasketService = new ShoppingBasketService(shoppingBasketRepositoryDBH2, productRepositoryDBH2, new BasketDate());
        try{
            return new ResponseEntity<ShoppingBasketMemento>(shoppingBasketService.basketFor(new UserID(id)).createShoppingBasketMemento(), HttpStatus.OK);
        }catch (BasketNotExistsException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/cart", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> postItem(@RequestBody PostItemRequest itemRequest) {
        shoppingBasketService = new ShoppingBasketService(shoppingBasketRepositoryDBH2, productRepositoryDBH2, basketDate);
        UserID userID = new UserID(itemRequest.userID);
        ProductID productID = new ProductID(itemRequest.productID);
        try{
            shoppingBasketService.addItem(userID,productID, itemRequest.quantity);
            return new ResponseEntity<Object>("Item succesfully added.", HttpStatus.CREATED);
        }catch (ProductNegativeQuantityException e){
            return new ResponseEntity<Object>("Quantity cannot be negative",HttpStatus.BAD_REQUEST);
        } catch (ProductDoesNotExistException e){
            return new ResponseEntity<Object>("Product not found", HttpStatus.BAD_REQUEST);
        }
        //throw new UnsupportedOperationException();
    }
}
