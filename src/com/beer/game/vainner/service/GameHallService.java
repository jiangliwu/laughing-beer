package com.beer.game.vainner.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.beer.game.vainner.dao.GameDAO;
import com.beer.game.vainner.model.Game;
import com.opensymphony.xwork2.ActionContext;

@Component("gameHallService")
public class GameHallService {

	private GameDAO gameDAO;
	private static Logger log = Logger.getLogger(GameHallService.class);

	public GameHallService() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List get() {
		this.getGameDAO();
		List<?> result = this.getGameDAO().findByProperty(GameDAO.GAME_STAUTS,
				0);
		
		Map<String, Object> applicationData = ActionContext.getContext()
				.getApplication();
		
		Iterator it = result.iterator();
		List buffer = new LinkedList();
		while (it.hasNext()) {
			Game game = (Game) it.next();
			String key = "room" + game.getGameId();
			Object roomInformation = applicationData.get(key);
			if (roomInformation == null) {
				buffer.add(game);
			}
		}
		log.debug("需要删除的房间有 " + buffer.size() );
		it = buffer.iterator();	//	删除
		while (it.hasNext()) {
			Game game = (Game) it.next();
			result.remove(game);
			this.gameDAO.delete(game);
		}
		
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
