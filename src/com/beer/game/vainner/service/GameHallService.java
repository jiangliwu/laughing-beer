package com.beer.game.vainner.service;

import java.util.List;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.beer.game.vainner.dao.GameDAO;

@Component("gameHallService")
public class GameHallService {

	private GameDAO gameDAO;
	private static Logger log = Logger.getLogger(GameHallService.class);
	
	public List get() {
		this.getGameDAO();
		List result = this.getGameDAO().findByProperty(GameDAO.GAME_STAUTS, 0);
		log.debug(result.size());
		return result;
	}

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	@Resource(name = "gameDAO")
	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}
}
