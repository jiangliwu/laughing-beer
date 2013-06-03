package com.beer.index.vainner.action;

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
	private static Logger logger = Logger.getLogger(IndexAction.class);

	public IndexAction() {
		this.setSession(ActionContext.getContext().getSession());
		this.setApplicationData(ActionContext.getContext().getApplication());
	}

	@SuppressWarnings("unchecked")
	public String execute() {
		List<Integer> games = (List<Integer>) applicationData.get("games");
		if (games == null) {
			logger.debug("games List init Success!");
			applicationData.put("games", new LinkedList<Integer>());
		}
		return SUCCESS;
	}

	public String dev()
	{
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
