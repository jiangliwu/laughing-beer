package com.vainner.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.beer.user.vainner.dao.UserDAO;
import com.beer.user.vainner.dao.UserDAOImpl;
import com.beer.user.vainner.model.User;
import com.beer.user.vainner.service.UserService;

public class userServiceTestWithoutSpring1 {

	@Test
	public void test() {
		UserService userService = new UserService();
		UserDAO userDAO = new UserDAOImpl();
		userService.setUserDAO(userDAO);
		userService.login("6", null);
		userDAO.delete(userDAO.findById(1));
	}

}
