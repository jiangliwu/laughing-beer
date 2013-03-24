package com.beer.game.vainner.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.game.vainner.service.GameDeleteService;
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
	private static Logger log = Logger.getLogger(GameExitAction.class);

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
		log.debug(username + " " + applicationDataKey + " " + "退出房间!");

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

		if (retail.size() + wholesale.size() + producer.size() == 0) {
			gameInformation.put(applicationDataKey, null);
			GameDeleteService gameDeleteService = (GameDeleteService) ApplicationContextHolder
					.getApplicationContext().getBean("gameDeleteService");
			gameDeleteService.deleteGameById(this.getId());
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
