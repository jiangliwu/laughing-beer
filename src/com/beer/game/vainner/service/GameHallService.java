package com.beer.game.vainner.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.beer.game.vainner.dao.GameDAO;
import com.beer.game.vainner.dao.UserGameDAO;
import com.beer.game.vainner.model.Game;
import com.beer.game.vainner.model.UserGame;

@Component("gameHallService")
public class GameHallService {

	private GameDAO gameDAO;

	public GameHallService() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List get(Map<String, Object> application) {
		List<Integer> games = (List<Integer>) application.get("games");
		List<Game> ret = new LinkedList<Game>();
		for (int i = 0; i < games.size(); i++) {
			HashMap<String, Object> gameInformation = (HashMap<String, Object>) application
					.get("room" + games.get(i));
			Game game = (Game) gameInformation.get("game");

			if (game.getGameStauts() == 0)
				ret.add(game);
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Game> getRun() {
		List<Game> games = (List<Game>) new GameDAO().findByProperty(
				GameDAO.GAME_STAUTS, 1);
		return games;
	}

	public List<Game> getMyGame(int userId) {
		List<UserGame> gameIds = (List<UserGame>) new UserGameDAO().findAll();
		Iterator<UserGame> it = gameIds.iterator();
		LinkedList<Game> ret = new LinkedList<Game>();
		while (it.hasNext()) {
			UserGame tmp = it.next();
			if (tmp.getUser().getId() == userId)
			{
				ret.add(tmp.getGame());
			}
		}
		return ret;
	}

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	@Resource(name = "gameDAO")
	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}
}
