package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TripServiceTest {

    @Test
    public void validate_not_logged_in_user (){
        TripService testeableTripService = new TesteableTripService();
        assertThrows(UserNotLoggedInException.class, ()->{testeableTripService.getTripsByUser(new User());});
    }

    private class TesteableTripService extends TripService {
        @Override
        protected User getLoggedUser() {
            return null;
        }
    }


    //does_not_return_any_trips_when_users_are_not_friends
    //return_trips_when_users_are_friends
}
