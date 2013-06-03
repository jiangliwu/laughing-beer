package com.beer.user.vainner.action;

import org.apache.log4j.Logger;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.user.vainner.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private boolean remember;

	private static Logger log = Logger.getLogger(UserAction.class);

	public String login() {
		UserService userService = (UserService) ApplicationContextHolder
				.getApplicationContext().getBean("userService");
		int result = userService.login(username, password);
		log.debug(remember);
		if (result > 0) {
			ActionContext.getContext().getSession().put("username", username);
			ActionContext.getContext().getSession().put("id", result);
			log.debug(username + " login where id = " + result);
			return SUCCESS;
		}
		this.addFieldError("loginError", "同户名不存在或密码错误!");
		return "error";
	}

	public String logout() {
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
