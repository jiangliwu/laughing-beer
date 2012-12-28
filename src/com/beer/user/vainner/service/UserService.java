package com.beer.user.vainner.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.beer.user.vainner.dao.UserDAO;
import com.beer.user.vainner.model.User;

@Component("userService")
public class UserService {

	private UserDAO userDAO;

	public void add(User u) {
		this.userDAO.save(u);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name = "userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
}
