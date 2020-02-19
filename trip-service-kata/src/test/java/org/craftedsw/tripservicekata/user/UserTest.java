package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    public void return_true_if_users_are_friends() {
        User userLoggin = new User();
        User userFriend = new User();
        userFriend.addFriend(userLoggin);
        assertEquals(true, userFriend.isFriend(userLoggin));
    }

    @Test
    public void return_false_if_users_are_not_friends() {
        User userLoggin = new User();
        User userFriend = new User();
        assertEquals(false, userFriend.isFriend(userLoggin));
    }
}
