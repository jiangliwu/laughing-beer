package com.beer.game.vainner.model;

public class GameProducerRecord implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer gameRetailRecordId;
	private Double thisTimeBuy;
	private Double allNeed;
	private Double actualSale;
	private Double allOwe;
	private Double delayCost;
	private Double beginGoods;
	private Double receiveGoods;
	private Double endGoods;
	private Double storageCost;
	private Double orderGoods;
	private Double thisTimeProfit;
	private Integer gameId;
	private Integer times;
	private Integer userId;
	private double totalProfilt;

	// Constructors

	public GameProducerRecord() {
	}

	public GameProducerRecord(Double thisTimeBuy, Double allNeed,
			Double actualSale, Double allOwe, Double delayCost,
			Double beginGoods, Double receiveGoods, Double endGoods,
			Double storageCost, Double orderGoods, Double thisTimeProfit,
			Integer gameId, Integer times, Integer userId) {
		this.thisTimeBuy = thisTimeBuy;
		this.allNeed = allNeed;
		this.actualSale = actualSale;
		this.allOwe = allOwe;
		this.delayCost = delayCost;
		this.beginGoods = beginGoods;
		this.receiveGoods = receiveGoods;
		this.endGoods = endGoods;
		this.storageCost = storageCost;
		this.orderGoods = orderGoods;
		this.thisTimeProfit = thisTimeProfit;
		this.gameId = gameId;
		this.times = times;
		this.userId = userId;
	}

	// Property accessors

	public Integer getGameRetailRecordId() {
		return this.gameRetailRecordId;
	}

	public void setGameRetailRecordId(Integer gameRetailRecordId) {
		this.gameRetailRecordId = gameRetailRecordId;
	}

	public Double getThisTimeBuy() {
		return this.thisTimeBuy;
	}

	public void setThisTimeBuy(Double thisTimeBuy) {
		this.thisTimeBuy = thisTimeBuy;
	}

	public Double getAllNeed() {
		return this.allNeed;
	}

	public void setAllNeed(Double allNeed) {
		this.allNeed = allNeed;
	}

	public Double getActualSale() {
		return this.actualSale;
	}

	public void setActualSale(Double actualSale) {
		this.actualSale = actualSale;
	}

	public Double getAllOwe() {
		return this.allOwe;
	}

	public void setAllOwe(Double allOwe) {
		this.allOwe = allOwe;
	}

	public Double getDelayCost() {
		return this.delayCost;
	}

	public void setDelayCost(Double delayCost) {
		this.delayCost = delayCost;
	}

	public Double getBeginGoods() {
		return this.beginGoods;
	}

	public void setBeginGoods(Double beginGoods) {
		this.beginGoods = beginGoods;
	}

	public Double getReceiveGoods() {
		return this.receiveGoods;
	}

	public void setReceiveGoods(Double receiveGoods) {
		this.receiveGoods = receiveGoods;
	}

	public Double getEndGoods() {
		return this.endGoods;
	}

	public void setEndGoods(Double endGoods) {
		this.endGoods = endGoods;
	}

	public Double getStorageCost() {
		return this.storageCost;
	}

	public void setStorageCost(Double storageCost) {
		this.storageCost = storageCost;
	}

	public Double getOrderGoods() {
		return this.orderGoods;
	}

	public void setOrderGoods(Double orderGoods) {
		this.orderGoods = orderGoods;
	}

	public Double getThisTimeProfit() {
		return this.thisTimeProfit;
	}

	public void setThisTimeProfit(Double thisTimeProfit) {
		this.thisTimeProfit = thisTimeProfit;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getTotalProfilt() {
		return totalProfilt;
	}

	public void setTotalProfilt(Double totalProfilt) {
		this.totalProfilt = totalProfilt;
	}

	public String toString() {
		/*
		 * return this.getThisTimeBuy() + "," + this.getAllNeed() + "," +
		 * this.getActualSale() + "," + this.getAllOwe() + "," +
		 * this.getDelayCost() + "," + this.getBeginGoods() + "," +
		 * this.getReceiveGoods() + "," + this.getEndGoods() + "," +
		 * this.getStorageCost() + "," + this.getOrderGoods() + "," +
		 * this.getThisTimeProfit();
		 */

		return this.getThisTimeBuy() + "," + this.getAllOwe() + ","
				+ this.getEndGoods() + "," + this.getThisTimeProfit() + "," + this.getTotalProfilt();
	}

}