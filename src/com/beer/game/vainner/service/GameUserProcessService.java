/**
 * com.beer.game.vainner.service
 * 2013Jun 3, 2013
 * @author Jiangliwu-Vainner
 */
package com.beer.game.vainner.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.beer.common.utility.SessionFactoryHolder;
import com.beer.game.vainner.dao.GameDAO;
import com.beer.game.vainner.dao.UserGameDAO;
import com.beer.game.vainner.model.UserGame;
import com.beer.user.vainner.dao.UserDAO;
import com.beer.user.vainner.model.User;

/**
 * 
 */

@Component("gameUserProcessService")
public class GameUserProcessService {
	private UserDAO userDAO;
	private UserGameDAO userGameDAO;
	private GameDAO gameDAO;

	public void gameStartProcess(int userId, int gameId, int identify) {
		User user = this.getUserDAO().findById(userId);
		if(user.equals(null))
			return;
		
		user.setInGame(1);
		user.setGameRoomId(gameId);

		UserGame userGame = new UserGame();
		userGame.setGame(this.getGameDAO().findById(gameId));
		userGame.setUser(user);
		userGame.setGameRole(identify);

		try {
			SessionFactoryHolder.getSession().beginTransaction();
			this.userDAO.save(user);
			this.getUserGameDAO().save(userGame);
			SessionFactoryHolder.getSession().getTransaction().commit();
		} catch (Exception e) {
			SessionFactoryHolder.getSession().getTransaction().rollback();
		}
	}

	public void gameEndProcess(int userId) {
		User user = this.getUserDAO().findById(userId);
		user.setInGame(0);
		SessionFactoryHolder.getSession().beginTransaction();
		this.userDAO.save(user);
		SessionFactoryHolder.getSession().getTransaction().commit();
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name = "userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserGameDAO getUserGameDAO() {
		return userGameDAO;
	}

	@Resource(name = "userGameDAO")
	public void setUserGameDAO(UserGameDAO userGameDAO) {
		this.userGameDAO = userGameDAO;
	}

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	@Resource(name = "gameDAO")
	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}

}
