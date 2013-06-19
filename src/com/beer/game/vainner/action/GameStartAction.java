package com.beer.game.vainner.action;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.game.vainner.model.Game;
import com.beer.game.vainner.model.GameProducerRecord;
import com.beer.game.vainner.model.GameRetailRecord;
import com.beer.game.vainner.model.GameWholesalerRecord;
import com.beer.game.vainner.model.UserStatusInTurn;
import com.beer.game.vainner.service.GameRecordInitService;
import com.beer.game.vainner.service.GameStartAndEndProcessService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GameStartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	private Map<String, Object> session;
	private Map<String, Object> applicationData;
	private Logger logger = Logger.getLogger(GameStartAction.class);

	public GameStartAction() {
		this.setSession(ActionContext.getContext().getSession());
		this.setApplicationData(ActionContext.getContext().getApplication());
	}

	@SuppressWarnings("unchecked")
	public String execute() {

		String applicationDataKey = "room" + this.getId();

		// add record

		Map<String, Object> gameInformation = (Map<String, Object>) this
				.getApplicationData().get(applicationDataKey); // read room
																// information

		String username = (String) this.getSession().get("username");
		if (gameInformation == null) {
			logger.debug("room " + this.getId() + "not exist!");
			return "un_kown_room";
		}

		List<String> retail = (List<String>) gameInformation.get("retail");
		Game game = (Game) gameInformation.get("game");
		game.setStartTime(new Timestamp(System.currentTimeMillis()));
		game.setGameStauts(1);

		List<String> wholesale = (List<String>) gameInformation
				.get("wholesale");
		List<String> producer = (List<String>) gameInformation.get("producer");

		String holderName = (String) gameInformation.get("holder");
		if (userIsInRoom(retail, wholesale, producer, username).equals("")) {
			return "not_in_room";
		}

		// Integer total = (Integer) gameInformation.get("total"); // 读出角色信息

		Boolean isStart = (Boolean) gameInformation.get("start");

		if (!isStart) // init turns
		{
			Integer nowTurns = 0;
			gameInformation.put("nowTurns", nowTurns);

			List<UserStatusInTurn> command = new LinkedList<UserStatusInTurn>();
			Iterator<String> it = retail.iterator();
			while (it.hasNext()) {
				String name = it.next();
				UserStatusInTurn user = new UserStatusInTurn();
				user.setUsername(name);
				user.setOrder(5);
				user.setOp("order,send,book");
				command.add(user);
			}

			it = wholesale.iterator();
			while (it.hasNext()) {
				String name = it.next();
				UserStatusInTurn user = new UserStatusInTurn();
				user.setUsername(name);
				user.setOp("book");
				//user.setDone(true);
				command.add(user);
			}
			it = producer.iterator();
			while (it.hasNext()) {
				String name = it.next();
				UserStatusInTurn user = new UserStatusInTurn();
				user.setUsername(name);
				user.setOp("book");
				user.setOther(0);
				command.add(user);
			}

			GameRecordInitService gameRecordInitService = (GameRecordInitService) ApplicationContextHolder
					.getApplicationContext().getBean("gameRecordInitService");

			// add record
			gameInformation.put("retailRecord", gameRecordInitService
					.getFirstRetailRecord(this.getId(), gameInformation));
			gameInformation.put("retailRecordList",
					new LinkedList<GameRetailRecord>());

			gameInformation.put("wholesaleRecord", gameRecordInitService
					.getFirstWholeRecord(this.getId(), gameInformation));
			gameInformation.put("wholesaleRecordList",
					new LinkedList<GameWholesalerRecord>());

			gameInformation.put("producerRecord", gameRecordInitService
					.getFirstProducerRecord(this.getId(), gameInformation));
			gameInformation.put("producerRecordList",
					new LinkedList<GameProducerRecord>());

			gameInformation.put("command", command);
			gameInformation.put("start", true);

			this.saveUserGameInformation(retail, wholesale, producer,
					holderName, game);
			logger.debug("room  " + this.getId()
					+ " init Done , start success !");
		}

		return "success";
	}

	public void saveUserGameInformation(List<String> a, List<String> b,
			List<String> c, String holderName, Game game) {
		GameStartAndEndProcessService gameUserProcessService = (GameStartAndEndProcessService) ApplicationContextHolder
				.getApplicationContext().getBean(
						"gameStartAndEndProcessService");
		Iterator<String> it = a.iterator();
		while (it.hasNext()) {
			String name = it.next();
			gameUserProcessService.gameStartProcess(name, game, 1,
					this.getIsHolder(holderName, name));
		}
		it = b.iterator();
		while (it.hasNext()) {
			String name = it.next();
			gameUserProcessService.gameStartProcess(name, game, 2,
					this.getIsHolder(holderName, name));
		}
		it = c.iterator();
		while (it.hasNext()) {
			String name = it.next();
			gameUserProcessService.gameStartProcess(name, game, 3,
					this.getIsHolder(holderName, name));
		}
	}

	public boolean getIsHolder(String holdName, String username) {
		return holdName.equals(username);
	}

	public String userIsInRoom(List<String> a, List<String> b, List<String> c,
			String username) {
		Iterator<String> it = a.iterator();
		while (it.hasNext()) {
			String name = it.next();
			if (name.equals(username))
				return "retail";
		}
		it = b.iterator();
		while (it.hasNext()) {
			String name = it.next();
			if (name.equals(username))
				return "wholesale";
		}
		it = c.iterator();
		while (it.hasNext()) {
			String name = it.next();
			if (name.equals(username))
				return "producer";
		}
		return "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getApplicationData() {
		return applicationData;
	}

	public void setApplicationData(Map<String, Object> applicationData) {
		this.applicationData = applicationData;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
