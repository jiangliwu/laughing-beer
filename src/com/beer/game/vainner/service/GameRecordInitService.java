/**
 * com.beer.game.vainner.service
 * 2013May 31, 2013
 * @author Jiangliwu-Vainner
 */
package com.beer.game.vainner.service;

import java.util.Map;


import org.springframework.stereotype.Component;

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

	public GameRetailRecord getFirstRetailRecord(int gameId,
			Map<String, Object> room) {
		GameRetailParameter tmp = (GameRetailParameter) room
				.get("retailConfig");
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

	public GameWholesalerRecord getFirstWholeRecord(int gameId,
			Map<String, Object> room) {
		GameWholesaleParameter tmp = (GameWholesaleParameter) room
				.get("wholesaleConfig");

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

	public GameProducerRecord getFirstProducerRecord(int gameId,
			Map<String, Object> room) {
		GameProducerParameter tmp = (GameProducerParameter) room
				.get("producerConfig");

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

}
