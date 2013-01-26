package com.beer.game.vainner.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.beer.game.vainner.dao.GameDAO;
import com.beer.game.vainner.model.Game;


@Component("gameWaitService")
public class GameWaitService {
	private GameDAO gameDAO;
	private static Logger log = Logger.getLogger(GameWaitService.class);
	
	public Game getGameById(int id)
	{
		log.debug("从id " + id  + "  开始读取记录!" );
		return this.getGameDAO().findById(id);
	}
	public GameDAO getGameDAO() {
		return gameDAO;
	}

	
	@Resource(name="gameDAO")
	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}
	
	
}
