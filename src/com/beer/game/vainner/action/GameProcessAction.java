/**
 * com.beer.game.vainner.action
 * 2013May 14, 2013
 * @author Jiangliwu-Vainner
 */
package com.beer.game.vainner.action;

import java.sql.Time;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import com.beer.common.utility.ApplicationContextHolder;
import com.beer.game.vainner.model.UserStatusInTurn;
import com.beer.game.vainner.service.GameTurnsProcessService;
import com.beer.game.vainner.service.GameUserProcessService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 */
public class GameProcessAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private Map<String, Object> applicationData;
	private Logger logger = Logger.getLogger(GameStartAction.class);
	private String commandType;
	private int counts;
	private int id;
	private String returnContent;
	private int bookCount;
	private int sendCount;
	private String cache;
	private Map<String, Object> gameInformation = null;
	private String username = null;
	private int userId;

	public GameProcessAction() {
		this.setSession(ActionContext.getContext().getSession());
		this.setApplicationData(ActionContext.getContext().getApplication());
		this.username = (String) this.getSession().get("username");
		this.userId = (Integer) this.getSession().get("id");
	}

	@SuppressWarnings("unchecked")
	public String execute() {

		String applicationDataKey = "room" + this.getId();

		this.gameInformation = (Map<String, Object>) this.getApplicationData()
				.get(applicationDataKey); // read room
		List<UserStatusInTurn> command = (List<UserStatusInTurn>) gameInformation
				.get("command");

		List<String> retail = (List<String>) gameInformation.get("retail");
		List<String> wholesale = (List<String>) gameInformation
				.get("wholesale");
		List<String> producer = (List<String>) gameInformation.get("producer");

		Integer nowTurns = (Integer) gameInformation.get("now_turns");
		Integer totalTurns = (Integer) gameInformation.get("turns");
		if (this.getCommandType().equals("get")) {
			this.returnContent = processGet(command, username, retail,
					wholesale, producer, nowTurns, totalTurns);
		} else if (this.getCommandType().equals("post")) {
			logger.debug(username + " post a command!");
			this.returnContent = processPost(command, this.username, retail,
					wholesale, producer, nowTurns, totalTurns);
		}
		return SUCCESS;
	}

	public String processPost(List<UserStatusInTurn> command, String username,
			List<String> retail, List<String> wholesale, List<String> producer,
			int nowTurns, int totalTurns) {
		for (int i = 0; i < command.size(); i++) {
			UserStatusInTurn user = command.get(i);
			if (user.getUsername().equals(username)) {
				if (!user.isDone()) {
					logger.debug(username + " do a command ! where send = "
							+ this.getSendCount() + " and book = "
							+ this.getBookCount());
					user.setOp("wait");
					user.setDone(true);

					user.setSend(this.getSendCount());
					user.setBook(this.getBookCount());
					((GameTurnsProcessService) ApplicationContextHolder
							.getApplicationContext().getBean(
									"gameTurnsProcessService")).updateRecord(
							gameInformation, this.getUserIndentify(retail,
									wholesale, producer, this.username), user
									.getOrder(), user.getReceive(), user
									.getSend(), user.getBook(), this.getId(),
							nowTurns, true, this.userId);
				}
			}
		}
		
		
		if (isAllDone(command)) {
			logger.debug("turns " + nowTurns
					+ " is Done , now gen the next command List");
			this.gameInformation.put("now_turns", ++nowTurns);
			if (nowTurns > totalTurns) {
				((GameUserProcessService) ApplicationContextHolder
						.getApplicationContext().getBean(
								"gameUserProcessService"))
						.gameEndProcess(this.userId);
			}
			this.gameInformation.put(
					"command",
					genNextTurnCommand(command, retail, wholesale, producer,
							nowTurns));
			return "done";
		}
		return "no-event";
	}

	public List<UserStatusInTurn> genNextTurnCommand(
			List<UserStatusInTurn> command, List<String> retail,
			List<String> wholesale, List<String> producer, int nowTurns) {

		List<UserStatusInTurn> newCommand = new LinkedList<UserStatusInTurn>();
		UserStatusInTurn retailUser = new UserStatusInTurn();
		UserStatusInTurn wholeSaleUser = new UserStatusInTurn();
		UserStatusInTurn producerUser = new UserStatusInTurn();

		retailUser.setUsername(retail.get(0));
		wholeSaleUser.setUsername(wholesale.get(0));
		producerUser.setUsername(producer.get(0));

		retailUser.setOrder(new Random().nextInt() % 10);
		retailUser.setReceive(command.get(1).getSend());
		wholeSaleUser.setOrder(command.get(0).getBook());
		wholeSaleUser.setReceive(command.get(2).getSend());

		producerUser.setOrder(command.get(1).getBook());
		producerUser.setReceive(command.get(2).getOther());
		producerUser.setOther(command.get(2).getBook());

		if (nowTurns == 2) {
			retailUser.setOp("order,send,book");
			wholeSaleUser.setOp("order,send,book");
			producerUser.setOp("book");
		} else if (nowTurns == 3) {
			retailUser.setOp("order,receive,send,book");
			wholeSaleUser.setOp("order,send,book");
			producerUser.setOp("order,receive,send,book");
		} else {
			retailUser.setOp("order,receive,send,book");
			wholeSaleUser.setOp("order,receive,send,book");
			producerUser.setOp("order,receive,send,book");
		}
		newCommand.add(retailUser);
		newCommand.add(wholeSaleUser);
		newCommand.add(producerUser);

		logger.debug("this next Command List is :");
		for (int i = 0; i < newCommand.size(); i++)
			logger.debug(newCommand.get(i));
		return newCommand;
	}

	public String processGet(List<UserStatusInTurn> command, String username,
			List<String> retail, List<String> wholesale, List<String> producer,
			int nowTurns, int totalTurns) {
		Iterator<UserStatusInTurn> it = command.iterator(); // query command
		// list
		while (it.hasNext()) {
			UserStatusInTurn user = it.next(); // extrat command

			if (user.getUsername().equals(username)) {
				// logger.debug(user);
				if (nowTurns > totalTurns) {
					return "gameOver";
				}
				if (user.getOp().equals("")) {
					return "no-event";
				} else if (user.getOp().equals("wait")) {
					return "wait";
				}
				if (user.isGeted() == false) {
					((GameTurnsProcessService) ApplicationContextHolder
							.getApplicationContext().getBean(
									"gameTurnsProcessService")).updateRecord(
							gameInformation, this.getUserIndentify(retail,
									wholesale, producer, this.username), user
									.getOrder(), user.getReceive(), 0, 0, this
									.getId(), nowTurns, false, this.userId);
				}
				user.setGeted(true);
				user.setGetTime(System.currentTimeMillis());
				return user.getOp() + "|" + user.getOrder() + ","
						+ user.getReceive() + "," + user.getSend() + ","
						+ user.getBook();
			}
		}
		return "no-event";

	}

	public boolean isAllDone(List<UserStatusInTurn> command) {
		
		Iterator<UserStatusInTurn> it = command.iterator();
		while (it.hasNext()) {
			UserStatusInTurn user = it.next();
			logger.debug(user.getUsername() + " " + user.isDone());
			if (!user.isDone())
				return false;
		}
		return true;
	}

	public String isSomeOneDrop(List<UserStatusInTurn> command) {
		Iterator<UserStatusInTurn> it = command.iterator();
		while (it.hasNext()) {
			UserStatusInTurn user = it.next();
			if (user.isDone())
				continue;

			long diff = System.currentTimeMillis() - user.getGetTime();
			if (user.isGeted() && diff > 60)
				return user.getUsername();
		}
		return "";
	}

	public String getUserIndentify(List<String> a, List<String> b,
			List<String> c, String username) {
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

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public String getReturnContent() {
		return returnContent;
	}

	public void setReturnContent(String returnContent) {
		this.returnContent = returnContent;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}

	public Map<String, Object> getGameInformation() {
		return gameInformation;
	}

	public void setGameInformation(Map<String, Object> gameInformation) {
		this.gameInformation = gameInformation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

}
