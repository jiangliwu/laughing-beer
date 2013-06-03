package com.beer.game.vainner.action;

import java.util.List;
import java.util.Map;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.game.vainner.service.GameHallService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GameHallAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<?> games;
	private Map<String, Object> session;
	private Map<String, Object> applicationData;

	public GameHallAction() {
		this.session = ActionContext.getContext().getSession();
		this.applicationData = ActionContext.getContext().getApplication();
	}

	public String execute() {
		GameHallService gameHallService = (GameHallService) ApplicationContextHolder
				.getApplicationContext().getBean("gameHallService");
		this.setGames(gameHallService.get(this.getApplicationData()));
		return "success";
	}

	public String runing() {
		GameHallService gameHallService = (GameHallService) ApplicationContextHolder
				.getApplicationContext().getBean("gameHallService");
		this.setGames(gameHallService.get(this.getApplicationData()));
		return "run";
	}

	public String mygame() {
		GameHallService gameHallService = (GameHallService) ApplicationContextHolder
				.getApplicationContext().getBean("gameHallService");
		this.setGames(gameHallService.getMyGame((Integer) (this.getSession()
				.get("id"))));
		return "mygame";
	}

	public List<?> getGames() {
		return games;
	}

	public void setGames(List<?> games) {
		this.games = games;
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
