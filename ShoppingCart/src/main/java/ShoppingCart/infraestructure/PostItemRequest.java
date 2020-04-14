package ShoppingCart.infraestructure;

public class PostItemRequest {
    public int userID;
    public int productID;
    public int quantity;

    public PostItemRequest(int userID, int productID, int quantity) {
        this.userID = userID;
        this.productID = productID;
        this.quantity = quantity;
    }
}

