package com.beer.game.vainner.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.game.vainner.model.Game;
import com.beer.game.vainner.model.GameProducerParameter;
import com.beer.game.vainner.model.GameRetailParameter;
import com.beer.game.vainner.model.GameWholesaleParameter;
import com.beer.game.vainner.service.GameCreateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GameCreateAction extends ActionSupport {

	/**
	 * 
	 */

	private GameRetailParameter retail;
	private GameWholesaleParameter wholesale;
	private GameProducerParameter producer;
	private static final long serialVersionUID = 1L;
	private String gameTitle;
	private boolean needPassword;
	private String password;
	private int times;
	private int time;
	private int retailNumber;
	private int wholesaleNumber;
	private int producerNumber;
	private int gameId;
	private static Logger log = Logger.getLogger(GameCreateAction.class);

	private Map<String, Object> session;
	private Map<String, Object> applicationData;

	public GameCreateAction() {
		this.session = ActionContext.getContext().getSession();
		this.applicationData = ActionContext.getContext().getApplication();
	}

	public String index() {
		return "index";
	}

	public String create() {

		log.debug("message form game create Action !!!");
		log.debug(retail);
		log.debug(wholesale);
		log.debug(producer);
		log.debug("game title : " + gameTitle);
		log.debug("password : " + needPassword + password);
		log.debug(retailNumber + " " + wholesaleNumber + producerNumber);

		if (!needPassword)
			password = "vainner-no-password";
		Game game = new Game();
		game.setCreateTime(new Timestamp(System.currentTimeMillis()));
		game.setGameTitle(gameTitle);
		game.setGamePassword(password);
		game.setGameStauts(0);
		game.setAllTimes(times);
		game.setOnceTime(time);
		game.setRetailNumber(retailNumber);
		game.setWholesaleNumber(wholesaleNumber);
		game.setProducerNumber(producerNumber);
		GameCreateService gameCreateService = (GameCreateService) ApplicationContextHolder
				.getApplicationContext().getBean("gameCreateService");
		Map<String, String> result = gameCreateService.add(game, retail,
				wholesale, producer);

		if (result.size() == 0) {

			String applicationDataKey = "room" + game.getGameId();
			log.debug("游戏房间application的键值是 ： " + applicationDataKey);
			HashMap<String, Object> gameInformation = new HashMap<String, Object>(); // 创建游戏房间的信息
			List<String> retail = new LinkedList<String>();
			List<String> wholesale = new LinkedList<String>();
			List<String> producer = new LinkedList<String>();
			List<String> message = new LinkedList<String>();
			message.add(this.session.get("username") + "创建了房间！");
			retail.add((String) this.getSession().get("username")); // 把创建者先放入零售商里面
			gameInformation.put("holder", this.getSession().get("username")); // 写入房主信息
			gameInformation.put("retail", retail); // 放入三个表
			gameInformation.put("wholesale", wholesale);
			gameInformation.put("producer", producer);
			gameInformation.put("total", new Integer(retailNumber
					+ wholesaleNumber + producerNumber));
			gameInformation.put((String) this.session.get("username"),
					new Boolean(true));
			gameInformation.put("retailNumber",
					new Integer(game.getRetailNumber()));
			gameInformation.put("wholesaleNumber",
					new Integer(game.getWholesaleNumber()));
			gameInformation.put("producerNumber",
					new Integer(game.getProducerNumber()));
			gameInformation.put("message", message);
			gameInformation.put("start", false);
			this.getApplicationData().put(applicationDataKey, gameInformation); // 写入信息
			this.setGameId(game.getGameId());
			return "success";
		} else {
			for (String key : result.keySet())
				this.addFieldError(key, result.get(key));
			return "error";
		}
	}

	public int getRetailNumber() {
		return retailNumber;
	}

	public void setRetailNumber(int retailNumber) {
		this.retailNumber = retailNumber;
	}

	public int getWholesaleNumber() {
		return wholesaleNumber;
	}

	public void setWholesaleNumber(int wholesaleNumber) {
		this.wholesaleNumber = wholesaleNumber;
	}

	public int getProducerNumber() {
		return producerNumber;
	}

	public void setProducerNumber(int producerNumber) {
		this.producerNumber = producerNumber;
	}

	public GameRetailParameter getRetail() {
		return retail;
	}

	public void setRetail(GameRetailParameter retail) {
		this.retail = retail;
	}

	public GameProducerParameter getProducer() {
		return producer;
	}

	public void setProducer(GameProducerParameter producer) {
		this.producer = producer;
	}

	public GameWholesaleParameter getWholesale() {
		return wholesale;
	}

	public void setWholesale(GameWholesaleParameter wholesale) {
		this.wholesale = wholesale;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean getNeedPassword() {
		return needPassword;
	}

	public void setNeedPassword(boolean needPassword) {
		this.needPassword = needPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getApplicationData() {
		return applicationData;
	}

	public void setApplicationData(Map<String, Object> applicationData) {
		this.applicationData = applicationData;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

}
