package com.beer.game.vainner.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.beer.common.utility.SessionFactoryHolder;
import com.beer.game.vainner.dao.GameDAO;
import com.beer.game.vainner.dao.GameProducerParameterDAO;
import com.beer.game.vainner.dao.GameRetailParameterDAO;
import com.beer.game.vainner.dao.GameWholesaleParameterDAO;
import com.beer.game.vainner.model.Game;
import com.beer.game.vainner.model.GameProducerParameter;
import com.beer.game.vainner.model.GameRetailParameter;
import com.beer.game.vainner.model.GameWholesaleParameter;

@Component("gameCreateService")
public class GameCreateService {
	private GameProducerParameterDAO gameProducerParameterDAO;
	private GameRetailParameterDAO gameRetailParameterDAO;
	private GameWholesaleParameterDAO gameWholesaleParameterDAO;
	private GameDAO gameDAO;

	public GameProducerParameterDAO getGameProducerParameterDAO() {
		return gameProducerParameterDAO;
	}

	public Map<String, String> add(Game game,
			GameRetailParameter gameRetailParameter,
			GameWholesaleParameter gameWholesaleParameter,
			GameProducerParameter gameProducerParameter) {
			
		Map<String, String> result = new HashMap<String, String>();

		try {
			SessionFactoryHolder.getSession().beginTransaction();
			this.getGameDAO().save(game);
			SessionFactoryHolder.getSession().flush();
			gameRetailParameter.setGameId(game.getGameId());
			gameWholesaleParameter.setGameId(game.getGameId());
			gameProducerParameter.setGameId(game.getGameId());
			this.getGameRetailParameterDAO().save(gameRetailParameter);
			this.getGameWholesaleParameterDAO().save(gameWholesaleParameter);
			this.getGameProducerParameterDAO().save(gameProducerParameter);
			SessionFactoryHolder.getSession().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			SessionFactoryHolder.getSession().getTransaction().rollback();
			result.put("error", "未知错误，无法创建房间!");
		}
		return result;
	}

	@Resource(name = "gameProducerParameterDAO")
	public void setGameProducerParameterDAO(
			GameProducerParameterDAO gameProducerParameterDAO) {
		this.gameProducerParameterDAO = gameProducerParameterDAO;
	}

	public GameRetailParameterDAO getGameRetailParameterDAO() {
		return gameRetailParameterDAO;
	}

	@Resource(name = "gameRetailParameterDAO")
	public void setGameRetailParameterDAO(
			GameRetailParameterDAO gameRetailParameterDAO) {
		this.gameRetailParameterDAO = gameRetailParameterDAO;
	}

	public GameWholesaleParameterDAO getGameWholesaleParameterDAO() {
		return gameWholesaleParameterDAO;
	}

	@Resource(name = "gameWholesaleParameterDAO")
	public void setGameWholesaleParameterDAO(
			GameWholesaleParameterDAO gameWholesaleParameterDAO) {
		this.gameWholesaleParameterDAO = gameWholesaleParameterDAO;
	}

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	@Resource(name = "gameDAO")
	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}

}
