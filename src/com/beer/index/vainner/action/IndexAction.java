package com.beer.index.vainner.action;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private Map<String, Object> applicationData;
	private HashMap<String, Object> gameInformation = null;
	private static Logger logger = Logger.getLogger(IndexAction.class);
	public IndexAction() {
		this.setSession(ActionContext.getContext().getSession());
		this.setApplicationData(ActionContext.getContext().getApplication());
	}

	@SuppressWarnings("unchecked")
	public String execute() {

		String applicationDataKey = "room" + 100;
		gameInformation = (HashMap<String, Object>) this.getApplicationData()
				.get(applicationDataKey); // 读出房间信息

		if (gameInformation == null) {
			HashMap<String, Object> gameInformation = new HashMap<String, Object>(); // 创建游戏房间的信息
			List<String> retail = new LinkedList<String>();
			List<String> wholesale = new LinkedList<String>();
			List<String> producer = new LinkedList<String>();

			retail.add("jiangliwu");
			wholesale.add("vainner");
			producer.add("ipple");

			gameInformation.put("retail", retail); // 放入三个表
			gameInformation.put("wholesale", wholesale);
			gameInformation.put("producer", producer);
			gameInformation.put("total",3);
			gameInformation.put("start", false);
			gameInformation.put("turns",20);
			gameInformation.put("time",30);
			gameInformation.put("now_turns",1);
			
			this.getApplicationData().put(applicationDataKey, gameInformation); // 写入信息
			logger.debug("room " + 100 + "create success !");
			
		}
		return SUCCESS;
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

}
