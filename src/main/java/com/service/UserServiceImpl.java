package com.service;

import java.util.ArrayList;
/**
 * The implementation class of user service class 
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.Flight;
import com.model.Login;
import com.model.Seat;
import com.model.SecurityQue;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	public int register(User user) {
		return userDao.register(user);
	}

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

	public int add(Flight flight) {
		return userDao.add(flight);
	}

	public List<Flight> searchFlight(Flight flight) {
		return userDao.searchFlight(flight);
	}

	
	public int verifyUser(SecurityQue sq) {
		return userDao.verify(sq);
		
	}

	public int book(String no,String flightnumber) {
		return userDao.book(no, flightnumber);
	}

	public List<Seat> retri() {
		// TODO Auto-generated method stub
		return userDao.retri();
	}
}