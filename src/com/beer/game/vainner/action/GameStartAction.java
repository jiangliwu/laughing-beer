package com.beer.game.vainner.action;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.beer.game.vainner.model.UserStatusInTurn;
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

		Map<String, Object> gameInformation = (Map<String, Object>) this
				.getApplicationData().get(applicationDataKey); // read room
																// information

		String username = (String) this.getSession().get("username");
		if (gameInformation == null)
		{
			logger.debug("room " + this.getId() + "not exist!");
			return "un_kown_room";
		}
		
		List<String> retail = (List<String>) gameInformation.get("retail");
		List<String> wholesale = (List<String>) gameInformation
				.get("wholesale");
		List<String> producer = (List<String>) gameInformation.get("producer");

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
				user.setOp("");
				user.setDone(true);
				command.add(user);
			}
			it = producer.iterator();
			while (it.hasNext()) {
				String name = it.next();
				UserStatusInTurn user = new UserStatusInTurn();
				user.setUsername(name);
				user.setOp("");
				user.setDone(true);
				command.add(user);
			}

			gameInformation.put("command", command);
			gameInformation.put("start", true);
			logger.debug("room  " + this.getId()
					+ "init Done , start success !");
		}

		return "success";
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
