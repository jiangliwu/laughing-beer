package com.beer.game.vainner.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GameSwitchIdentify extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> applicationData;
	private static Logger log = Logger.getLogger(GameSwitchIdentify.class);
	private String identify;
	private int position;
	private String key;
	private int id;
	private int retailNumber;
	private int wholesaleNumber;
	private int producerNumber;

	public GameSwitchIdentify() {
		this.setSession(ActionContext.getContext().getSession());
		this.setApplicationData(ActionContext.getContext().getApplication());
	}

	@SuppressWarnings("unchecked")
	public String execute() {

		log.debug(this.identify + " " + this.position + " " + this.key);
		this.setId(new Integer(this.getKey().substring(4))); // 设定跳转的id
		Map<String, Object> gameInformation = (Map<String, Object>) this
				.getApplicationData().get(key); // 读出房间信息

		List<String> retail = (List<String>) gameInformation.get("retail");
		List<String> wholesale = (List<String>) gameInformation
				.get("wholesale");
		List<String> producer = (List<String>) gameInformation.get("producer");
		List<String> message = (List<String>) gameInformation.get("message");
		
		this.retailNumber = (Integer) gameInformation.get("retailNumber");
		this.wholesaleNumber = (Integer) gameInformation.get("wholesaleNumber");
		this.producerNumber = (Integer) gameInformation.get("producerNumber");
		String username = (String) this.getSession().get("username");
		
		if (this.getIdentify().equals("producer")) {
			if (producer.size() < this.getProducerNumber()) {
				producer.add(username); // 放进去
				retail.remove(username);
				wholesale.remove(username);
				message.add(username + "移动到了【生产商" + position+"】"+ "位置");
				log.debug(username + "移动到了【生产商" + position+"】"+ "位置");
			}
		} else if (this.identify.equals("wholesale")) {
			if (wholesale.size() < this.getWholesaleNumber()) {
				wholesale.add(username);
				retail.remove(username);
				producer.remove(username);
				message.add(username + "移动到了【批发商" + position+"】"+ "位置");
				log.debug(username + "移动到了【批发商" + position+"】"+ "位置");
			}
		} else if (this.identify.equals("retail")) {
			if (retail.size() < this.getRetailNumber()) {
				retail.add(username);
				wholesale.remove(username);
				producer.remove(username);
				message.add(username + "移动到了【零售商" + position+"】"+ "位置");
				log.debug(username + "移动到了【零售商" + position+"】"+ "位置");
			}
		}

		this.getApplicationData().put(key, gameInformation);
		return "success";

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

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getId() {
		return id;
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
