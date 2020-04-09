package ShoppingCart.infraestructure;

import ShoppingCart.domain.ProductID;
import ShoppingCart.domain.UserID;
import ShoppingCart.service.ShoppingBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ShoppingBasketWebController {
    @Autowired
    ProductRepositoryDBH2 productRepositoryDBH2;

    @GetMapping("product")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepositoryDBH2.getProductById(new ProductID(10002)).toString(), HttpStatus.OK);
    }
    @GetMapping("/hello")
    public ResponseEntity<Object> helloWorld (){
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

}
