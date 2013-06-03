package com.beer.game.vainner.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.beer.game.vainner.model.Game;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GameWaitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Map<String, Object> session;
	private Map<String, Object> applicationData;
	private Game game;
	private static Logger log = Logger.getLogger(GameWaitAction.class);
	private int retailNumber;
	private int wholesaleNumber;
	private int producerNumber;

	public GameWaitAction() {
		this.setSession(ActionContext.getContext().getSession());
		this.setApplicationData(ActionContext.getContext().getApplication());
	}

	@SuppressWarnings("unchecked")
	public String index() {

		String applicationDataKey = "room" + this.getId();

		Map<String, Object> gameInformation = (Map<String, Object>) this
				.getApplicationData().get(applicationDataKey); // 读出房间信息

		List<String> retail = (List<String>) gameInformation.get("retail");
		List<String> wholesale = (List<String>) gameInformation
				.get("wholesale");
		List<String> producer = (List<String>) gameInformation.get("producer");
		List<String> message = (List<String>) gameInformation.get("message");
		Integer total = (Integer) gameInformation.get("total"); // 读出角色信息

		this.retailNumber = (Integer) gameInformation.get("retailNumber");
		this.wholesaleNumber = (Integer) gameInformation.get("wholesaleNumber");
		this.producerNumber = (Integer) gameInformation.get("producerNumber");

		String username = (String) this.getSession().get("username");
		Boolean isInRoom = (Boolean) gameInformation.get((String) this
				.getSession().get("username"));

		if (isInRoom == null) { // 如果不在房间里
			if (retail.size() < this.retailNumber) // 如果目前的人数小于预定的人数
			{
				retail.add(username);
				message.add(username + "加入了房间," + "被分配到了零售商的位置!");
				log.debug(username + "加入了房间," + "被分配到了零售商的位置!");
			} else if (wholesale.size() < this.wholesaleNumber) {
				wholesale.add(username);
				message.add(username + "加入了房间," + "被分配到了批发商的位置!");
				log.debug(username + "加入了房间," + "被分配到了批发商的位置!");
			} else if (producer.size() < this.wholesaleNumber) {
				producer.add(username);
				message.add(username + "加入了房间," + "被分配到了生产商的位置!");
				log.debug(username + "加入了房间," + "被分配到了生产商的位置!");
			} else {
				message.add(username + "想加入房间，不过房间已经满了!");
				log.debug(username + "想加入房间，不过房间已经满了!");
				return "full";
			}
			gameInformation.put((String) this.getSession().get("username"),
					true);
		}

		log.debug("目前人数 : ");
		log.debug("零售商人数" + retail.size());
		log.debug("批发商人数" + wholesale.size());
		log.debug("生产商人数" + producer.size());
		this.applicationData.put(applicationDataKey, gameInformation);

		return "index";
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
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

}
