/**
 * com.beer.game.vainner.action
 * 2013Jun 3, 2013
 * @author Jiangliwu-Vainner
 */
package com.beer.game.vainner.action;

import java.util.List;
import java.util.Map;

import com.beer.game.vainner.dao.GameProducerRecordDAO;
import com.beer.game.vainner.dao.GameRetailRecordDAO;
import com.beer.game.vainner.dao.GameWholesalerRecordDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 */
public class GameShowRecordAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private List<?> retailRecords;
	private List<?> wholesaleRecords;
	private List<?> producerRecords;
	private Map<String, Object> applicationData;

	public String execute() {
		this.setApplicationData(ActionContext.getContext().getApplication());
		this.getApplicationData().put("room" + this.getId(), null); // clear
		this.retailRecords = new GameRetailRecordDAO().findByGameId(id);
		this.wholesaleRecords = new GameWholesalerRecordDAO().findByGameId(id);
		this.producerRecords = new GameProducerRecordDAO().findByGameId(id);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<?> getRetailRecords() {
		return retailRecords;
	}

	public void setRetailRecords(List<?> retailRecords) {
		this.retailRecords = retailRecords;
	}

	public List<?> getWholesaleRecords() {
		return wholesaleRecords;
	}

	public void setWholesaleRecords(List<?> wholesaleRecords) {
		this.wholesaleRecords = wholesaleRecords;
	}

	public List<?> getProducerRecords() {
		return producerRecords;
	}

	public void setProducerRecords(List<?> producerRecords) {
		this.producerRecords = producerRecords;
	}

	public Map<String, Object> getApplicationData() {
		return applicationData;
	}

	public void setApplicationData(Map<String, Object> applicationData) {
		this.applicationData = applicationData;
	}

}
