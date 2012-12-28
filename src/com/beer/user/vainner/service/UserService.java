package com.beer.user.vainner.service;

import java.util.List;

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
	
	
	@SuppressWarnings("unchecked")
	public String login(String username , String password)
	{
		List<User> users = userDAO.findByProperty("username", username);
		if(users.size() == 0)
			return "username-null";
		else if(!users.get(0).getPassword().equals(password))
			return "password-wa";
		return "success";
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name = "userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
}
