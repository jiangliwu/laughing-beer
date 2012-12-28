package com.beer.user.vainner.action;

import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.beer.user.vainner.model.User;
import com.beer.user.vainner.service.UserService;
import com.beer.utility.ApplicationContextHolder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private boolean remember;

	public String register_index() {
		return SUCCESS;
	}

	public String register_process() {
		if (ActionContext.getContext().getSession().get("username") != null) {
			return "error";
		}
		ApplicationContext factory = ApplicationContextHolder
				.getApplicationContext();
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

		ActionContext.getContext().getSession()
				.put("username", user.getUsername());

		return SUCCESS;
	}

	public String login_index() {
		return SUCCESS;
	}

	public String login_process() {
		System.out.println(this.username + " " + this.password);
		System.out.println(this.remember);
		UserService userService = (UserService) ApplicationContextHolder
				.getApplicationContext().getBean("userService");
		return userService.login(username, password);
	}

	public String logout_index() {
		if (ActionContext.getContext().getSession().get("username") != null)
			ActionContext.getContext().getSession().remove("username");
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

}
