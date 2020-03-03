package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TripServiceTest {

    @Test
    public void validate_not_logged_in_user (){
        TripService testeableTripService = new TripService();
        assertThrows(UserNotLoggedInException.class, ()->{testeableTripService.getTripsByUser(new User(), null);});
    }

    @Test
    public void does_not_return_any_trips_when_users_are_not_friends(){
        TripService testeableTripService = new TripService();
        assertEquals(
                new ArrayList<Trip>(),
                testeableTripService.getTripsByUser(new User(), new User())
        );
    }

    @Test
    public void  return_trips_when_users_are_friends(){
        User loggedUser = new User();
        TripService testeableTripService = new TesteableTripService(loggedUser);
        List<Trip> tripList = new ArrayList<>();
        Trip trip1 = new Trip();
        Trip trip2 = new Trip();
        tripList.add(trip1);
        tripList.add(trip2);
        User userFriend = new User();
        userFriend.addFriend(loggedUser);
        userFriend.addTrip(trip1);
        userFriend.addTrip(trip2);
        assertEquals(tripList, testeableTripService.getTripsByUser(userFriend, loggedUser));
    }


    private class TesteableTripService extends TripService {

        private final User userLogged;

        public TesteableTripService(User userLogged){
            this.userLogged = userLogged;
        }

        @Override
        protected List<Trip> findTripsByUser(User user) {
            return user.trips();
        }
    }



}
