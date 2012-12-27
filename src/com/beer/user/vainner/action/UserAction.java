package com.beer.user.vainner.action;

import org.springframework.context.ApplicationContext;

import com.beer.user.vainner.model.User;
import com.beer.user.vainner.service.UserService;
import com.beer.utility.ApplicationContextHolder;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{


	private static final long serialVersionUID = 1L;
	public String userAdd()
	{
		ApplicationContext factory = ApplicationContextHolder.getApplicationContext();
		UserService userService = (UserService) factory.getBean("userService");
		User user = new User();
		user.setFirstName("1");
		user.setLastName("2");
		user.setGender("3");
		user.setPassword("4");
		user.setStudentId("5");
		user.setUsername("6");
		user.setPlayGameTimes(1);
		userService.add(user);
		return SUCCESS;
	}
}
