package com.beer.game.vainner.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.beer.common.utility.SessionFactoryHolder;
import com.beer.game.vainner.dao.GameDAO;
import com.beer.game.vainner.model.Game;
import com.beer.game.vainner.model.GameProducerParameter;
import com.beer.game.vainner.model.GameRetailParameter;
import com.beer.game.vainner.model.GameWholesaleParameter;
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

	private int randomRetail;
	private int randomWholesale;
	private int randomProducer;
	private Map<String, Object> session;
	private Map<String, Object> applicationData;

	public GameCreateAction() {
		this.session = ActionContext.getContext().getSession();
		this.applicationData = ActionContext.getContext().getApplication();
	}

	public String index() {
		this.setRandomRetail(12);
		this.setRandomWholesale(20);
		this.setRandomProducer(30);
		return "index";
	}

	@SuppressWarnings("unchecked")
	public String create() {

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
		SessionFactoryHolder.getSession().beginTransaction();
		new GameDAO().save(game);
		SessionFactoryHolder.getSession().getTransaction().commit();

		String applicationDataKey = "room" + game.getGameId();
		log.debug("game room application key =  " + applicationDataKey);
		HashMap<String, Object> gameInformation = new HashMap<String, Object>(); // 创建游戏房间的信息
		gameInformation.put("retailConfig", retail);
		gameInformation.put("wholesaleConfig", wholesale);
		gameInformation.put("producerConfig", producer);
		gameInformation.put("game", game);

		List<String> retailPerson = new LinkedList<String>();
		List<String> wholesalePerson = new LinkedList<String>();
		List<String> producerPerson = new LinkedList<String>();
		List<String> message = new LinkedList<String>();

		message.add(this.session.get("username") + "创建了房间！");
		retailPerson.add((String) this.getSession().get("username")); // 把创建者先放入零售商里面

		gameInformation.put("holder", this.getSession().get("username")); // 写入房主信息
		gameInformation.put("retail", retailPerson); // 放入三个表
		gameInformation.put("wholesale", wholesalePerson);
		gameInformation.put("producer", producerPerson);
		gameInformation.put("total", new Integer(retailNumber + wholesaleNumber
				+ producerNumber));
		gameInformation.put((String) this.session.get("username"), new Boolean(
				true));
		gameInformation
				.put("retailNumber", new Integer(game.getRetailNumber()));
		gameInformation.put("wholesaleNumber",
				new Integer(game.getWholesaleNumber()));
		gameInformation.put("producerNumber",
				new Integer(game.getProducerNumber()));
		gameInformation.put("message", message);
		gameInformation.put("turns", game.getAllTimes());
		gameInformation.put("time", game.getOnceTime());
		gameInformation.put("now_turns", 1);
		gameInformation.put("start", false);
		this.getApplicationData().put(applicationDataKey, gameInformation); // 写入信息
		this.setGameId(game.getGameId());

		List<Integer> games = (List<Integer>) this.getApplicationData().get(
				"games");
		games.add(game.getGameId());

		return "success";
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

	public int getRandomRetail() {
		return randomRetail;
	}

	public void setRandomRetail(int randomRetail) {
		this.randomRetail = randomRetail;
	}

	public int getRandomWholesale() {
		return randomWholesale;
	}

	public void setRandomWholesale(int randomWholesale) {
		this.randomWholesale = randomWholesale;
	}

	public int getRandomProducer() {
		return randomProducer;
	}

	public void setRandomProducer(int randomProducer) {
		this.randomProducer = randomProducer;
	}

}
