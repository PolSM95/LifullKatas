package ShoppingCart.infraestructure;

import ShoppingCart.domain.ProductID;
import ShoppingCart.domain.UserID;
import ShoppingCart.service.ShoppingBasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ShoppingBasketWebController {

    @GetMapping("/hello")
    public ResponseEntity<Object> helloWorld (){
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

}
