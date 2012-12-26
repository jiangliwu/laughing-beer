package com.beer.user.vainner.service;

import com.beer.user.vainner.dao.UserDAO;
import com.beer.user.vainner.dao.impl.UserDAOImpl;
import com.beer.user.vainner.model.User;

public class UserService {
	public void add(User u)
	{
		UserDAO userDAO = new UserDAOImpl();
		userDAO.save(u);
		System.out.println("add");
	}
}
