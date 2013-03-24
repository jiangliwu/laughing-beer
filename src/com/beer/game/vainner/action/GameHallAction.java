package com.beer.game.vainner.action;

import java.util.List;

import org.jboss.logging.Logger;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.game.vainner.model.Game;
import com.beer.game.vainner.service.GameHallService;
import com.opensymphony.xwork2.ActionSupport;

public class GameHallAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(GameHallAction.class);
	private List games;

	public String execute() {
		GameHallService gameHallService = (GameHallService) ApplicationContextHolder
				.getApplicationContext().getBean("gameHallService");
		this.setGames(gameHallService.get());
		return "success";
	}

	public List getGames() {
		return games;
	}

	public void setGames(List games) {
		this.games = games;
	}

}
