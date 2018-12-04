package com.dao;

import java.util.ArrayList;
/**
 *  DAO interface class to handle all function calls
 */
import java.util.List;

import com.model.Flight;
import com.model.Login;
import com.model.Seat;
import com.model.SecurityQue;
import com.model.User;

public interface UserDao {
	int register(User user);

	User validateUser(Login login);

	int add(Flight flight);

	public List<Flight> list();

	List<Flight> searchFlight(Flight flight);


	int verify(SecurityQue sq);

	int book(String no,String flightnumber);

	List<Seat> retri();
	
}
