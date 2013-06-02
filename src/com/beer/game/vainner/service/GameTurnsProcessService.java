/**
 * com.beer.game.vainner.service
 * 2013Jun 1, 2013
 * @author Jiangliwu-Vainner
 */
package com.beer.game.vainner.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.beer.common.utility.SessionFactoryHolder;
import com.beer.game.vainner.dao.GameProducerParameterDAO;
import com.beer.game.vainner.dao.GameProducerRecordDAO;
import com.beer.game.vainner.dao.GameRetailParameterDAO;
import com.beer.game.vainner.dao.GameRetailRecordDAO;
import com.beer.game.vainner.dao.GameWholesaleParameterDAO;
import com.beer.game.vainner.dao.GameWholesalerRecordDAO;
import com.beer.game.vainner.model.GameProducerParameter;
import com.beer.game.vainner.model.GameProducerRecord;
import com.beer.game.vainner.model.GameRetailParameter;
import com.beer.game.vainner.model.GameRetailRecord;
import com.beer.game.vainner.model.GameWholesaleParameter;
import com.beer.game.vainner.model.GameWholesalerRecord;

/**
 * 
 */

@Component("gameTurnsProcessService")
public class GameTurnsProcessService {
	private GameProducerParameterDAO gameProducerParameterDAO;
	private GameRetailParameterDAO gameRetailParameterDAO;
	private GameWholesaleParameterDAO gameWholesaleParameterDAO;
	private int gameId;
	private int turns;

	public GameProducerParameterDAO getGameProducerParameterDAO() {
		return gameProducerParameterDAO;
	}

	public void saveRecord(Map<String, Object> room, String identify,
			int order, int receive, int send, int book, int gameId, int turns) {
		this.gameId = gameId;
		this.turns = turns;
		if (identify.equals("retail")) {
			saveRetailRecord(room, order, receive, send, book);
		} else if (identify.equals("wholesale")) {
			this.saveWholesaleRecord(room, order, receive, send, book);
		} else if (identify.equals("producer")) {
			this.saveProducerRecord(room, order, receive, send, book);
		}
	}

	public void saveRetailRecord(Map<String, Object> room, int order,
			int receive, int send, int book) {
		GameRetailRecord pre = (GameRetailRecord) room.get("retailRecord");
		GameRetailParameter para = (GameRetailParameter) this
				.getGameRetailParameterDAO().findByGameId(this.gameId).get(0);
		GameRetailRecord save = new GameRetailRecord();
		save.setThisTimeBuy(order * 1.0);
		save.setAllNeed(save.getThisTimeBuy() + pre.getAllOwe());
		save.setActualSale(send * 1.0);
		save.setAllOwe(save.getAllNeed() - save.getActualSale());
		save.setDelayCost(save.getAllOwe() * para.getDelayCost());
		save.setBeginGoods(pre.getEndGoods());
		save.setReceiveGoods(receive * 1.0);
		save.setTotalReciveGoods(pre.getTotalReciveGoods()
				+ save.getReceiveGoods());
		save.setTotalUpOweGoods(pre.getTotalOrderGoods()
				- save.getTotalReciveGoods());
		save.setEndGoods(save.getBeginGoods() + save.getReceiveGoods()
				- save.getActualSale());
		save.setStorageCost((save.getBeginGoods() + save.getEndGoods()) * 0.5
				* para.getRepertoryCost());
		save.setOrderGoods(book * 1.0);
		save.setTotalOrderGoods(pre.getTotalOrderGoods() + save.getOrderGoods());
		save.setThisTimeProfit((para.getPrice() - para.getCost())
				* save.getActualSale() - save.getDelayCost()
				- save.getStorageCost());
		if (save.getReceiveGoods() > 0.01)
			save.setThisTimeProfit(save.getThisTimeProfit()
					- para.getTransportCost());
		if (save.getOrderGoods() > 0.01)
			save.setThisTimeProfit(save.getThisTimeProfit()
					- para.getOrderCost());

		save.setGameId(this.gameId);
		save.setTimes(this.turns);
		SessionFactoryHolder.getSession().beginTransaction();
		new GameRetailRecordDAO().save(save);
		SessionFactoryHolder.getSession().getTransaction().commit();
		room.put("retailRecord", save);
	}

	public void saveWholesaleRecord(Map<String, Object> room, int order,
			int receive, int send, int book) {

		GameWholesalerRecord pre = (GameWholesalerRecord) room
				.get("wholesaleRecord");
		GameWholesaleParameter para = (GameWholesaleParameter) this
				.getGameWholesaleParameterDAO().findByGameId(this.gameId)
				.get(0);

		GameWholesalerRecord save = new GameWholesalerRecord();
		save.setThisTimeBuy(order * 1.0);
		save.setAllNeed(save.getThisTimeBuy() + pre.getAllOwe());
		save.setActualSale(send * 1.0);
		save.setAllOwe(save.getAllNeed() - save.getActualSale());
		save.setDelayCost(save.getAllOwe() * para.getDelayCost());
		save.setBeginGoods(pre.getEndGoods());
		save.setReceiveGoods(receive * 1.0);
		save.setTotalReciveGoods(pre.getTotalReciveGoods()
				+ save.getReceiveGoods());
		save.setTotalUpOweGoods(pre.getTotalOrderGoods()
				- save.getTotalReciveGoods());
		save.setEndGoods(save.getBeginGoods() + save.getReceiveGoods()
				- save.getActualSale());
		save.setStorageCost((save.getBeginGoods() + save.getEndGoods()) * 0.5
				* para.getRepertoryCost());
		save.setOrderGoods(book * 1.0);
		save.setTotalOrderGoods(pre.getTotalOrderGoods() + save.getOrderGoods());
		save.setThisTimeProfit((para.getPrice() - para.getCost())
				* save.getActualSale() - save.getDelayCost()
				- save.getStorageCost());
		if (save.getReceiveGoods() > 0.01)
			save.setThisTimeProfit(save.getThisTimeProfit()
					- para.getTransportCost());
		if (save.getOrderGoods() > 0.01)
			save.setThisTimeProfit(save.getThisTimeProfit()
					- para.getOrderCost());

		save.setGameId(this.gameId);
		save.setTimes(this.turns);
		SessionFactoryHolder.getSession().beginTransaction();
		new GameWholesalerRecordDAO().save(save);
		SessionFactoryHolder.getSession().getTransaction().commit();
		room.put("wholesaleRecord", save);
	}

	public void saveProducerRecord(Map<String, Object> room, int order,
			int receive, int send, int book) {

		GameProducerRecord pre = (GameProducerRecord) room
				.get("producerRecord");
		GameProducerParameter para = (GameProducerParameter) this
				.getGameProducerParameterDAO().findByGameId(this.gameId).get(0);

		GameProducerRecord save = new GameProducerRecord();
		save.setThisTimeBuy(order * 1.0);
		save.setAllNeed(save.getThisTimeBuy() + pre.getAllOwe());
		save.setActualSale(send * 1.0);
		save.setAllOwe(save.getAllNeed() - save.getActualSale());
		save.setDelayCost(save.getAllOwe() * para.getDelayCost());
		save.setBeginGoods(pre.getEndGoods());
		save.setReceiveGoods(receive * 1.0);

		save.setEndGoods(save.getBeginGoods() + save.getReceiveGoods()
				- save.getActualSale());
		save.setStorageCost((save.getBeginGoods() + save.getEndGoods()) * 0.5
				* para.getRepertoryCost());
		save.setOrderGoods(book * 1.0);

		save.setThisTimeProfit((para.getPrice() - para.getCost())
				* save.getActualSale() - save.getDelayCost()
				- save.getStorageCost());

		if (save.getOrderGoods() > 0.01)
			save.setThisTimeProfit(save.getThisTimeProfit()
					- para.getStartCost());

		save.setGameId(this.gameId);
		save.setTimes(this.turns);
		SessionFactoryHolder.getSession().beginTransaction();
		new GameProducerRecordDAO().save(save);
		SessionFactoryHolder.getSession().getTransaction().commit();
		room.put("producerRecord", save);
	}

	@Resource(name = "gameProducerParameterDAO")
	public void setGameProducerParameterDAO(
			GameProducerParameterDAO gameProducerParameterDAO) {
		this.gameProducerParameterDAO = gameProducerParameterDAO;
	}

	public GameRetailParameterDAO getGameRetailParameterDAO() {
		return gameRetailParameterDAO;
	}

	@Resource(name = "gameRetailParameterDAO")
	public void setGameRetailParameterDAO(
			GameRetailParameterDAO gameRetailParameterDAO) {
		this.gameRetailParameterDAO = gameRetailParameterDAO;
	}

	public GameWholesaleParameterDAO getGameWholesaleParameterDAO() {
		return gameWholesaleParameterDAO;
	}

	@Resource(name = "gameWholesaleParameterDAO")
	public void setGameWholesaleParameterDAO(
			GameWholesaleParameterDAO gameWholesaleParameterDAO) {
		this.gameWholesaleParameterDAO = gameWholesaleParameterDAO;
	}

}
