package com.beer.game.vainner.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GameStartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	private Map<String, Object> session;
	private Map<String, Object> applicationData;

	public GameStartAction() {
		this.setSession(ActionContext.getContext().getSession());
		this.setApplicationData(ActionContext.getContext().getApplication());
	}

	public String execute() {
		String applicationDataKey = "room" + this.getId();

		Map<String, Object> gameInformation = (Map<String, Object>) this
				.getApplicationData().get(applicationDataKey); // 读出房间信息
		if(gameInformation != null)
			gameInformation.put("start", true);
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getApplicationData() {
		return applicationData;
	}

	public void setApplicationData(Map<String, Object> applicationData) {
		this.applicationData = applicationData;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
