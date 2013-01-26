package com.beer.game.vainner.model;

import java.sql.Timestamp;




public  class Game implements java.io.Serializable {

	// Fields
	//s
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer gameId;
	private Timestamp startTime;
	private Timestamp endTime;
	private Timestamp createTime;
	private String gameTitle;
	private String gamePassword;
	private int gameStauts;
	private int allTimes;
	private int onceTime;
	private int retailNumber;
	private int wholesaleNumber;
	private int producerNumber;

	// Property accessors

	public int getRetailNumber() {
		return retailNumber;
	}

	public void setRetailNumber(int retailNumber) {
		this.retailNumber = retailNumber;
	}

	public int getWholesaleNumber() {
		return wholesaleNumber;
	}

	public void setWholesaleNumber(int wholesaleNumber) {
		this.wholesaleNumber = wholesaleNumber;
	}

	public int getProducerNumber() {
		return producerNumber;
	}

	public void setProducerNumber(int producerNumber) {
		this.producerNumber = producerNumber;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public String getGamePassword() {
		return gamePassword;
	}

	public void setGamePassword(String gamePassword) {
		this.gamePassword = gamePassword;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getGameStauts() {
		return gameStauts;
	}

	public void setGameStauts(int gameStauts) {
		this.gameStauts = gameStauts;
	}

	public int getAllTimes() {
		return allTimes;
	}

	public void setAllTimes(int allTimes) {
		this.allTimes = allTimes;
	}

	public int getOnceTime() {
		return onceTime;
	}

	public void setOnceTime(int onceTime) {
		this.onceTime = onceTime;
	}

}