/**
 * com.beer.game.vainner.service
 * 2013Jun 3, 2013
 * @author Jiangliwu-Vainner
 */
package com.beer.game.vainner.service;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.common.utility.SessionFactoryHolder;
import com.beer.game.vainner.dao.GameDAO;
import com.beer.game.vainner.dao.GameProducerRecordDAO;
import com.beer.game.vainner.dao.GameRetailRecordDAO;
import com.beer.game.vainner.dao.GameWholesalerRecordDAO;
import com.beer.game.vainner.dao.UserGameDAO;
import com.beer.game.vainner.model.Game;
import com.beer.game.vainner.model.GameProducerParameter;
import com.beer.game.vainner.model.GameProducerRecord;
import com.beer.game.vainner.model.GameRetailParameter;
import com.beer.game.vainner.model.GameRetailRecord;
import com.beer.game.vainner.model.GameWholesaleParameter;
import com.beer.game.vainner.model.GameWholesalerRecord;
import com.beer.game.vainner.model.UserGame;
import com.beer.user.vainner.dao.UserDAO;
import com.beer.user.vainner.model.User;

/**
 * 
 */

@Component("gameStartAndEndProcessService")
public class GameStartAndEndProcessService {
	private UserDAO userDAO;
	private UserGameDAO userGameDAO;
	private GameDAO gameDAO;
	private static Logger log = Logger
			.getLogger(GameStartAndEndProcessService.class);

	public void gameStartProcess(String username, Game game, int identify,
			boolean isHolder) {
		List<?> users = this.getUserDAO().findByUsername(username);
		if (users.size() == 0)
			return;
		User user = (User) users.get(0);
		user.setInGame(1);
		user.setGameRoomId(game.getGameId());

		UserGame userGame = new UserGame();
		userGame.setGame(game);
		userGame.setUser(user);
		userGame.setGameRole(identify);
		userGame.setGameHolder(isHolder ? 1 : 0);
		try {
			SessionFactoryHolder.getSession().beginTransaction();
			this.userDAO.save(user);
			this.getUserGameDAO().save(userGame);
			SessionFactoryHolder.getSession().getTransaction().commit();
		} catch (Exception e) {
			SessionFactoryHolder.getSession().getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public void gameEndProcess(Map<String, Object> application, int gameId) {

		String applicationDataKey = "room" + gameId;

		Map<String, Object> room = (Map<String, Object>) application
				.get(applicationDataKey); // read room

		List<String> retail = (List<String>) room.get("retail");
		List<String> wholesale = (List<String>) room.get("wholesale");
		List<String> producer = (List<String>) room.get("producer");
		GameRetailParameter retailPara = (GameRetailParameter) room
				.get("retailConfig");
		GameWholesaleParameter wholesalePara = (GameWholesaleParameter) room
				.get("wholesaleConfig");
		GameProducerParameter producerPara = (GameProducerParameter) room
				.get("producerConfig");
		Game game = (Game) room.get("game");
		List<GameRetailRecord> gameRetailRecordList = (List<GameRetailRecord>) room
				.get("retailRecordList");
		List<GameWholesalerRecord> gameWholesalerRecordList = (List<GameWholesalerRecord>) room
				.get("wholesaleRecordList");
		List<GameProducerRecord> gameProducerRecordList = (List<GameProducerRecord>) room
				.get("producerRecordList");
		List<Integer> games = (List<Integer>) application.get("games");
		this.modifyUserInformation(retail, wholesale, producer);
		this.saveGameConfig(game, retailPara, wholesalePara, producerPara);
		this.saveRecords(gameRetailRecordList, gameWholesalerRecordList,
				gameProducerRecordList);
		this.removeRoomFromList(games, gameId);
		room.clear();
		application.put(applicationDataKey, null);
		SessionFactoryHolder.getSession().flush();

	}

	private void removeRoomFromList(List<Integer> games, int gameId) {
		Integer needRemove = null;
		Iterator<Integer> it = games.iterator();
		while (it.hasNext()) {
			Integer tmp = it.next();
			if (tmp.equals(gameId)) {
				needRemove = tmp;
				break;
			}
		}
		if (needRemove != null)
			games.remove(needRemove);

		log.debug("remove from list success!");
	}

	private void saveRecords(List<GameRetailRecord> gameRetailRecordList,
			List<GameWholesalerRecord> gameWholesalerRecordList,
			List<GameProducerRecord> gameProducerRecordList) {

		SessionFactoryHolder.getSession().beginTransaction();
		Iterator<GameRetailRecord> it1 = gameRetailRecordList.iterator();
		while (it1.hasNext())
			new GameRetailRecordDAO().save(it1.next());
		Iterator<GameWholesalerRecord> it2 = gameWholesalerRecordList
				.iterator();
		while (it2.hasNext())
			new GameWholesalerRecordDAO().save(it2.next());
		Iterator<GameProducerRecord> it3 = gameProducerRecordList.iterator();
		while (it3.hasNext())
			new GameProducerRecordDAO().save(it3.next());
		SessionFactoryHolder.getSession().getTransaction().commit();

		log.debug("record save success!");
	}

	private void saveGameConfig(Game game, GameRetailParameter retailPara,
			GameWholesaleParameter wholesalePara,
			GameProducerParameter producerPara) {
		Game updateGame = new GameDAO().findById(game.getGameId());
		updateGame.setEndTime(new Timestamp(System.currentTimeMillis()));
		updateGame.setStartTime(game.getStartTime());
		updateGame.setGameStauts(2);
		GameRoomStatusService gameStatus = (GameRoomStatusService) ApplicationContextHolder
				.getApplicationContext().getBean("gameRoomStatusService");
		gameStatus.add(updateGame, retailPara, wholesalePara, producerPara);

		log.debug("game para save success !!");
	}

	private void modifyUserInformation(List<String> a, List<String> b,
			List<String> c) {
		User retail = (User) this.userDAO.findByUsername(a.get(0)).get(0);
		User wholesale = (User) this.userDAO.findByUsername(b.get(0)).get(0);
		User producer = (User) this.userDAO.findByUsername(c.get(0)).get(0);

		retail.setInGame(0);
		wholesale.setInGame(0);
		producer.setInGame(0);
		SessionFactoryHolder.getSession().beginTransaction();
		this.userDAO.save(retail);
		this.userDAO.save(wholesale);
		this.userDAO.save(producer);
		SessionFactoryHolder.getSession().getTransaction().commit();
		log.debug("user in game where status chang success !!");
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
