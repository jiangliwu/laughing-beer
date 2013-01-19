package com.beer.user.vainner.service;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.user.vainner.model.User;



public class UserServiceTest3 {

	@Test
	public void testAdd() {
		//ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext factory = ApplicationContextHolder.getApplicationContext();
		UserService userService = (UserService) factory.getBean("userService");
		userService.login("6", null);
	}

}
