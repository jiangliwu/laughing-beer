package com.beer.user.vainner.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.beer.user.vainner.dao.UserDAO;
import com.beer.user.vainner.model.User;

@Component("userService")
public class UserService {

	private UserDAO userDAO;

	@SuppressWarnings("unchecked")
	public String login(String username, String password) {
		List<User> users = userDAO.findByProperty("username", username);
		if (users.size() == 0)
			return "username-null";
		
		else if (!users.get(0).getPassword().equals(password))
			return "password-wa";
		return "success";
	}

	public void add(User user) {

	}

	public Map<String, String> register(User user) {
		Map<String, String> result = new HashMap<String, String>();
		boolean flag = true;
		user.setFirstName("无");
		user.setLastName("名");

		if (this.userDAO.findByUsername(user.getUsername()).size() != 0) {
			result.put("registerErrorUser", "用户已经存在!");
			flag = false;
		}
		if (this.userDAO.findByProperty("studentId", user.getStudentId())
				.size() != 0) {
			result.put("registerErrorStudengId", "学号已经被使用!");
			flag = false;
		}
		if (flag) {
			this.userDAO.save(user);
		}
		return result;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name = "userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
