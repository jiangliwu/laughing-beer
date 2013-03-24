package com.beer.game.vainner.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.beer.game.vainner.dao.GameDAO;
import com.beer.game.vainner.model.Game;

@Component("gameDeleteService")
public class GameDeleteService {

	private GameDAO gameDAO;

	public boolean deleteGameById(int id) {
		this.gameDAO.delete(this.gameDAO.findById(id));
		return true;
	}

	public boolean deleteGameByInstance(Game game) {
		this.gameDAO.delete(game);
		return true;
	}

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	@Resource(name = "gameDAO")
	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}

}
