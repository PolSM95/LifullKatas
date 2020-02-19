package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TripServiceTest {

    @Test
    public void validate_not_logged_in_user (){
        TripService testeableTripService = new TesteableTripService(false);
        assertThrows(UserNotLoggedInException.class, ()->{testeableTripService.getTripsByUser(new User());});
    }

    @Test
    public void does_not_return_any_trips_when_users_are_not_friends(){
        TripService testeableTripService = new TesteableTripService(true);
        assertEquals(new ArrayList<Trip>(), testeableTripService.getTripsByUser(new User()));
    }



    private class TesteableTripService extends TripService {
        private final boolean userLogged;

        public TesteableTripService(boolean userLogged){
            this.userLogged = userLogged;
        }

        @Override
        protected User getLoggedUser() {
            if (userLogged){
                return new User();
            }
            return null;
        }
    }

}
