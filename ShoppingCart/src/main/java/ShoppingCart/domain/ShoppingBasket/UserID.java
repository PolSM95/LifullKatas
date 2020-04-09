package ShoppingCart.domain.ShoppingBasket;

import java.util.Objects;

public class UserID {
    private int userID;

    public UserID(int userID) {

        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserID userID1 = (UserID) o;
        return userID == userID1.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }

    public UserIDMemento createUserIdMemento() {
        UserIDMemento userIDMemento = new UserIDMemento();
        userIDMemento.userId = userID;
        return userIDMemento;
    }
}
