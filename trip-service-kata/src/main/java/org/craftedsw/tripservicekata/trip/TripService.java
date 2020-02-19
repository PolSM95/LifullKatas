package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = getLoggedUser();
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
		if (user.isFriend(loggedUser)) {
			return findTripsByUser(user);
		}
		return getEmptyTripList();
	}

	private ArrayList<Trip> getEmptyTripList() {
		return new ArrayList<Trip>();
	}


	protected List<Trip> findTripsByUser(User user) {
		return TripDAO.findTripsByUser(user);
	}

	protected User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}

}
