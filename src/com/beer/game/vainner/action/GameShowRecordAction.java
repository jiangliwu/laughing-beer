/**
 * com.beer.game.vainner.action
 * 2013Jun 3, 2013
 * @author Jiangliwu-Vainner
 */
package com.beer.game.vainner.action;

import java.util.List;
import com.beer.common.utility.SessionFactoryHolder;
import com.beer.game.vainner.dao.GameDAO;
import com.beer.game.vainner.dao.GameProducerRecordDAO;
import com.beer.game.vainner.dao.GameRetailRecordDAO;
import com.beer.game.vainner.dao.GameWholesalerRecordDAO;
import com.beer.game.vainner.model.Game;
import com.beer.game.vainner.model.GameProducerRecord;
import com.beer.game.vainner.model.GameRetailRecord;
import com.beer.game.vainner.model.GameWholesalerRecord;
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

	private Game game;
	private List<?> retailRecords;
	private List<?> wholesaleRecords;
	private List<?> producerRecords;
	private double retailAllProfit;
	private double wholesaleAllProfit;
	private double producerAllProfit;

	public String execute() {

		SessionFactoryHolder.closeSession();
		this.retailRecords = new GameRetailRecordDAO().findByGameId(id);
		retailAllProfit = 0;
		for (int i = 0; i < retailRecords.size(); i++)
			retailAllProfit += ((GameRetailRecord) retailRecords.get(i))
					.getThisTimeProfit();

		wholesaleAllProfit = 0;
		this.wholesaleRecords = new GameWholesalerRecordDAO().findByGameId(id);
		for (int i = 0; i < wholesaleRecords.size(); i++)
			wholesaleAllProfit += ((GameWholesalerRecord) wholesaleRecords.get(i))
					.getThisTimeProfit();

		producerAllProfit = 0;
		this.producerRecords = new GameProducerRecordDAO().findByGameId(id);
		for (int i = 0; i < producerRecords.size(); i++)
			producerAllProfit += ((GameProducerRecord) producerRecords.get(i))
					.getThisTimeProfit();
		
		this.game = new GameDAO().findById(this.getId());
		SessionFactoryHolder.getSession().flush();
		SessionFactoryHolder.getSession().clear();
		SessionFactoryHolder.closeSession();
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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

	public double getRetailAllProfit() {
		return retailAllProfit;
	}

	public void setRetailAllProfit(double retailAllProfit) {
		this.retailAllProfit = retailAllProfit;
	}

	public double getWholesaleAllProfit() {
		return wholesaleAllProfit;
	}

	public void setWholesaleAllProfit(double wholesaleAllProfit) {
		this.wholesaleAllProfit = wholesaleAllProfit;
	}

	public double getProducerAllProfit() {
		return producerAllProfit;
	}

	public void setProducerAllProfit(double producerAllProfit) {
		this.producerAllProfit = producerAllProfit;
	}

}
