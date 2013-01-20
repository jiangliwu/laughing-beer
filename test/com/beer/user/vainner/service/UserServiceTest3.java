package com.beer.user.vainner.service;



import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.beer.common.utility.ApplicationContextHolder;



public class UserServiceTest3 {

	@Test
	public void testAdd() {
		//ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext factory = ApplicationContextHolder.getApplicationContext();
		UserService userService = (UserService) factory.getBean("userService");
		userService.login("6", null);
	}

}
