package com.beer.user.vainner.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.user.vainner.model.User;
import com.beer.user.vainner.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserRegisterAction extends ActionSupport {

	/**
	 * 
	 */

	private User user;
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserRegisterAction.class);

	public String execute() {
		return "success";
	}

	public String registerIndex() {
		return "index";
	}

	public String register() {

		log.debug(user.getUsername() + " " + user.getPassword() + " "
				+ user.getStudentId() + " " + user.getGender());
		UserService userService = (UserService) ApplicationContextHolder
				.getApplicationContext().getBean("userService");
		Map<String, String> result = userService.register(user);
		if (result.size() == 0) {
			ActionContext.getContext().getSession()
					.put("username", user.getUsername());
		} else {
			for (String key : result.keySet()) {
				this.addFieldError(key, result.get(key));
			}
			return "error";
		}
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
