/**
 * com.beer.game.vainner.service
 * 2013May 31, 2013
 * @author Jiangliwu-Vainner
 */
package com.beer.game.vainner.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.beer.game.vainner.dao.GameProducerParameterDAO;
import com.beer.game.vainner.dao.GameRetailParameterDAO;
import com.beer.game.vainner.dao.GameWholesaleParameterDAO;
import com.beer.game.vainner.model.GameProducerParameter;
import com.beer.game.vainner.model.GameProducerRecord;
import com.beer.game.vainner.model.GameRetailParameter;
import com.beer.game.vainner.model.GameRetailRecord;
import com.beer.game.vainner.model.GameWholesaleParameter;
import com.beer.game.vainner.model.GameWholesalerRecord;

/**
 * 
 */

@Component("gameRecordInitService")
public class GameRecordInitService {
	private GameProducerParameterDAO gameProducerParameterDAO;
	private GameRetailParameterDAO gameRetailParameterDAO;
	private GameWholesaleParameterDAO gameWholesaleParameterDAO;


	public GameRetailRecord getFirstRetailRecord(int gameId) {
		GameRetailParameter tmp = (GameRetailParameter) this.gameRetailParameterDAO
				.findByGameId(gameId).get(0);
		GameRetailRecord ret = new GameRetailRecord();
		ret.setThisTimeBuy(0.0);
		ret.setAllNeed(0.0);
		ret.setActualSale(0.0);
		ret.setAllOwe(0.0);
		ret.setDelayCost(0.0);
		ret.setBeginGoods(tmp.getOrigin());
		ret.setReceiveGoods(0.0);
		ret.setTotalReciveGoods(0.0);
		ret.setTotalUpOweGoods(0.0);
		ret.setEndGoods(tmp.getOrigin());
		ret.setStorageCost((ret.getBeginGoods() + ret.getEndGoods()) * 0.5
				* tmp.getRepertoryCost());
		ret.setOrderGoods(0.0);
		ret.setTotalOrderGoods(0.0);
		ret.setThisTimeProfit((tmp.getPrice() - tmp.getCost())
				* ret.getActualSale() - ret.getDelayCost()
				- ret.getStorageCost());

		// - (ret.getReceiveGoods() == 0.0 ? 0 : tmp.getTransportCost())
		// - ret.getOrderGoods() == 0.0 ? 0 : tmp.getOrderCost());
		if (ret.getReceiveGoods() > 0.01)
			ret.setThisTimeProfit(ret.getThisTimeProfit()
					- tmp.getTransportCost());
		if (ret.getOrderGoods() > 0.01)
			ret.setThisTimeProfit(ret.getThisTimeProfit() - tmp.getOrderCost());

		
		return ret;
	}

	public GameWholesalerRecord getFirstWholeRecord(int gameId) {
		GameWholesaleParameter tmp = (GameWholesaleParameter) this
				.getGameWholesaleParameterDAO().findByGameId(gameId).get(0);

		GameWholesalerRecord ret = new GameWholesalerRecord();
		ret.setThisTimeBuy(0.0);
		ret.setAllNeed(0.0);
		ret.setActualSale(0.0);
		ret.setAllOwe(0.0);
		ret.setDelayCost(0.0);
		ret.setBeginGoods(tmp.getOrigin());
		ret.setReceiveGoods(0.0);
		ret.setTotalReciveGoods(0.0);
		ret.setTotalUpOweGoods(0.0);
		ret.setEndGoods(tmp.getOrigin());
		ret.setStorageCost((ret.getBeginGoods() + ret.getEndGoods()) * 0.5
				* tmp.getRepertoryCost());
		ret.setOrderGoods(0.0);
		ret.setTotalOrderGoods(0.0);
		ret.setThisTimeProfit((tmp.getPrice() - tmp.getCost())
				* ret.getActualSale() - ret.getDelayCost()
				- ret.getStorageCost());

		if (ret.getReceiveGoods() > 0.01)
			ret.setThisTimeProfit(ret.getThisTimeProfit()
					- tmp.getTransportCost());
		if (ret.getOrderGoods() > 0.01)
			ret.setThisTimeProfit(ret.getThisTimeProfit() - tmp.getOrderCost());
		return ret;
	}

	public GameProducerRecord getFirstProducerRecord(int gameId) {
		GameProducerParameter tmp = (GameProducerParameter) this
				.getGameProducerParameterDAO().findByGameId(gameId).get(0);

		GameProducerRecord ret = new GameProducerRecord();
		ret.setThisTimeBuy(0.0);
		ret.setAllNeed(0.0);
		ret.setActualSale(0.0);
		ret.setAllOwe(0.0);
		ret.setDelayCost(0.0);
		ret.setBeginGoods(tmp.getOrigin());
		ret.setReceiveGoods(0.0);

		ret.setEndGoods(tmp.getOrigin() + ret.getReceiveGoods());
		ret.setStorageCost((ret.getBeginGoods() + ret.getEndGoods()) * 0.5
				* tmp.getRepertoryCost());
		ret.setOrderGoods(0.0);
		ret.setThisTimeProfit((tmp.getPrice() - tmp.getCost())
				* ret.getActualSale() - ret.getDelayCost()
				- ret.getStorageCost());

		if (ret.getOrderGoods() > 0.01)
			ret.setThisTimeProfit(ret.getThisTimeProfit() - tmp.getStartCost());
		return ret;
	}

	private GameProducerParameterDAO getGameProducerParameterDAO() {
		return gameProducerParameterDAO;
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
