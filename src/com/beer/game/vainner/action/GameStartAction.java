package com.beer.game.vainner.action;

import com.opensymphony.xwork2.ActionSupport;

public class GameStartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String applicationDataKey;
	
	public GameStartAction() {
	}

	public String execute() {
		return "success";
	}
}
