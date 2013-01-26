package com.beer.game.vainner.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GameExitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Map<String, Object> session;
	private Map<String, Object> applicationData;

	public GameExitAction() {
		this.setSession(ActionContext.getContext().getSession());
		this.setApplicationData(ActionContext.getContext().getApplication());
	}

	@SuppressWarnings("unchecked")
	public String execute() {
		String applicationDataKey = "room" + this.getId();

		Map<String, Object> gameInformation = (Map<String, Object>) this
				.getApplicationData().get(applicationDataKey); // 读出房间信息

		List<String> retail = (List<String>) gameInformation.get("retail");
		List<String> wholesale = (List<String>) gameInformation
				.get("wholesale");
		List<String> producer = (List<String>) gameInformation.get("producer");
		List<String> message = (List<String>) gameInformation.get("message");
		String username = (String) this.getSession().get("username");

		
		retail.remove(username);
		wholesale.remove(username);
		producer.remove(username);
		gameInformation.remove(username);
		message.add(username + "离开了房间!");
		if (username.equals(gameInformation.get("holder"))) // 房主离开了
		{
			
			String flagName = "";
			if (retail.size() != 0) {
				gameInformation.put("holder", retail.get(0));
				flagName = retail.get(0);
			} else if (wholesale.size() != 0) {
				gameInformation.put("holder", wholesale.get(0));
				flagName = wholesale.get(0);
			} else if (producer.size() != 0) {
				gameInformation.put("holder", producer.get(0));
				flagName = producer.get(0);
			}
			message.add(flagName + "成为了新的房主!");
		}
		
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getApplicationData() {
		return applicationData;
	}

	public void setApplicationData(Map<String, Object> applicationData) {
		this.applicationData = applicationData;
	}

}
