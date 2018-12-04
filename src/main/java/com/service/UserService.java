package com.service;

import java.util.ArrayList;
/**
 * Service Interface class to handle all services
 */
import java.util.List;

import com.model.Flight;
import com.model.Login;
import com.model.Seat;
import com.model.SecurityQue;
import com.model.User;

public interface UserService {

	int register(User user);

	User validateUser(Login login);

	int add(Flight flight);

	List<Flight> searchFlight(Flight flight);


	int verifyUser(SecurityQue sq);

	int book(String no,String flightnumber);

	List<Seat> retri();
}