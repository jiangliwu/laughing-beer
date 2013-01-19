package com.beer.user.vainner.service;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.user.vainner.model.User;



public class UserServiceTest2 {

	@Test
	public void testAdd() {
		//ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
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
	}

}
